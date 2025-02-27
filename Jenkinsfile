pipeline {
    agent any
    environment {
        DOCKER_COMPOSE_FILE = '/home/ubuntu/docker-compose.yml'
        IMAGE_NAME = "camperX-api"
        GIT_REPO = "https://github.com/jeondaehoon/dockerbackend.git"
        BRANCH_NAME = "deploy"
        PATH = "/usr/bin:$PATH"
    }
    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: "${BRANCH_NAME}", url: "${GIT_REPO}"
                }
            }
        }
        
        stage('Build Docker Image') {
            steps {
                script {
                    // 현재 날짜를 "yyyyMMdd" 형식으로 얻기
                    def now = new Date().format("yyyyMMddHHmm")
                    def OLD_TAG = now 
                    
                    // Docker 이미지 태그 붙이기
                    // 태그에 날짜를 추가함으로써 이미지버전에 대한 태그를 관리하는데 유용함
                    sh "docker tag ${IMAGE_NAME}:latest ${IMAGE_NAME}:${OLD_TAG}"
                    sh "docker build -t ${IMAGE_NAME}:${OLD_TAG} ."
                }
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script {
                    // Docker Hub에 로그인
                    // withCredentials = Docker Hub의 아이디와 비밀번호를 직접 노출하지 않고
                    // Jenkins의 credentials에 Docker Hub 정보를 연동하여 안전하게 로그인한다
                    echo "Logging in to Docker Hub..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    }

                    // Docker 이미지를 푸시
                    echo "Pushing Docker image"
                    def now = new Date().format("yyyyMMddHHmm")
                    OLD_TAG = now
                    sh "docker push ${DOCKER_USERNAME}/camperx-backend:${OLD_TAG}"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    // 새로 만들어진 이미지를 배포 실행한다
                    echo "Deploying with docker-compose..."
                    // Docker Compose로 배포
                    sh 'docker-compose -f ${DOCKER_COMPOSE_FILE} up -d'
                }
            }
        }
    }
}
