pipeline {
    agent any
    environment {
        DOCKER_COMPOSE_FILE = '/home/ubuntu/docker-compose.yml'
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
                    echo "Building Java project with Maven"
                    sh "mvn clean install"  // Maven을 사용해 JAR 파일 빌드
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def now = new Date().format("yyyyMMddHHmm")
                    echo "Building Docker image with tag ${now}"
                    sh "docker build -t ascdee1234/camperx-api:${now} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        echo "Logging into Docker Hub"
                        sh "docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD"
                        echo "Pushing Docker image to DockerHub"
                        def now = new Date().format("yyyyMMddHHmm")
                        sh "docker push ascdee1234/camperx-api:${now}"
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'SSH_KEY', usernameVariable: 'SSH_USER', passwordVariable: 'SSH_PASSWORD']]) {
                        echo "Deploying to EC2"
                        sh """
                            ssh -o StrictHostKeyChecking=no -i /path/to/your/private/key $SSH_USER@ec2-instance-ip << 'EOF'
                                cd /home/ubuntu/docker-app
                                docker-compose pull
                                docker-compose up -d
                            EOF
                        """
                    }
                }
            }
        }
    }
}
