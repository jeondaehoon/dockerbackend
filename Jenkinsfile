pipeline {
    agent any
    environment {
        DOCKER_COMPOSE_FILE = '/home/ubuntu/docker-compose.yml' // Docker Compose 파일 경로
        IMAGE_NAME = "camperx-api" // 이미지 이름
        GIT_REPO = "https://github.com/jeondaehoon/dockerbackend.git" // Git repository URL
        BRANCH_NAME = "deploy" // 사용할 브랜치 이름
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    // Git repository에서 코드를 체크아웃
                    withCredentials([[$class: 'UsernamePasswordMultiBinding', credentialsId: 'Github-credentials', usernameVariable: 'GIT_USERNAME', passwordVariable: 'GIT_PASSWORD']]) {
                        git branch: "${BRANCH_NAME}", url: "${GIT_REPO}", credentialsId: 'Github-credentials'
                    }
                }
            }
        }

        stage('Build Java Project') {
            steps {
                script {
                    // Docker 안에서 Maven을 사용하여 Java 프로젝트를 빌드
                    docker.image('maven:3.8.4').inside("--entrypoint=''") {
                        echo "Building Java project with Maven inside Docker"
                        sh 'mvn clean install -P alzza -DskipTests' // Maven 빌드 명령어
                    }
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    def now = new Date().format("yyyyMMddHHmm") // 현재 시간으로 태그 생성
                    echo "Building Docker image with tag ${now}"
                    // Docker 이미지를 빌드하고 태그를 생성
                    sh "docker build -t ascdee1234/camperx-api:${now} ." // Docker 빌드 명령어
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        echo "Logging into Docker Hub"
                        // Docker Hub에 로그인
                        sh "echo \$DOCKER_PASSWORD | docker login -u \$DOCKER_USERNAME --password-stdin"
                        echo "Pushing Docker image to DockerHub"
                        def now = new Date().format("yyyyMMddHHmm") // 태그 날짜
                        // Docker 이미지를 Docker Hub에 푸시
                        sh "docker push ascdee1234/camperx-api:${now}" // Docker 푸시 명령어
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    withCredentials([[$class: 'SSHUserPrivateKey', credentialsId: 'ec2-ssh', keyFileVariable: 'SSH_KEY_PATH', usernameVariable: 'SSH_USER']]) {
                        echo "Deploying to EC2"
                        // EC2 서버에 배포
                        sh(script: """
                            ssh -i $SSH_KEY_PATH $SSH_USER@52.79.219.130 << 'EOF'
                                cd /home/ubuntu/docker-app
                                # Docker Compose 파일을 최신 상태로 가져오고
                                docker-compose pull
                                # Docker Compose로 컨테이너 실행
                                docker-compose up -d
                            EOF
                        """, returnStatus: true)
                    }
                }
            }
        }
    }
}
