pipeline {
    agent any
    environment {
        DOCKER_COMPOSE_FILE = 'docker-compose.yml'
        IMAGE_NAME = "camperx-api"
        GIT_REPO = "https://github.com/jeondaehoon/dockerbackend.git"
        BRANCH_NAME = "deploy"
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'Github-credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
                        git branch: "${BRANCH_NAME}", url: "${GIT_REPO}", credentialsId: 'Github-credentials'
                    }
                }
            }
        }

        stage('Build Java Project') {
            steps {
                script {
                    docker.image('maven:3.8.4').inside("--entrypoint=''") {
                        echo "Docker 내부에서 Maven을 사용하여 Java 프로젝트 빌드 중"
                        sh 'mvn clean install -P alzza -DskipTests spring-boot:repackage'
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    env.IMAGE_TAG = new Date().format("yyyyMMddHHmm")
                    echo "태그 ${env.IMAGE_TAG}로 Docker 이미지 빌드 중"
                    sh "docker build -t ascdee1234/camperx-api:${env.IMAGE_TAG} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        echo "Docker Hub에 로그인 중"
                        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                        echo "Docker 이미지를 Docker Hub에 푸시 중"
                        sh "docker push ascdee1234/camperx-api:${env.IMAGE_TAG}"
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    withCredentials([sshUserPrivateKey(credentialsId: 'ec2-ssh', keyFileVariable: 'SSH_KEY_PATH', usernameVariable: 'SSH_USER')]) {
                        echo "EC2에 배포 중"
                        sh(script: """
                            ssh -i $SSH_KEY_PATH $SSH_USER@52.79.219.130 << 'EOF'
                                set -x
                                cd /home/ubuntu
                                docker-compose pull
                                docker-compose up -d --force-recreate web
                                if [ \$? -ne 0 ]; then
                                    echo "docker-compose 배포 실패"
                                    exit 1
                                fi
                            EOF
                        """, returnStatus: true)
                    }
                }
            }
        }
    }
}