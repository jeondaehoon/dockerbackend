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
                    
                    // Docker 이미지를 빌드한 후, 태그를 추가
                    sh "docker build -t ${IMAGE_NAME}:${OLD_TAG} ."
                    sh "docker tag ${IMAGE_NAME}:${OLD_TAG} ${IMAGE_NAME}:latest" // 최신 태그를 추가
                }
            }
        }
        
        stage('Push Docker Image') {
            steps {
                script {
                    // Docker Hub에 로그인
                    echo "Logging in to Docker Hub..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    }

                    // Docker 이미지를 푸시
                    echo "Pushing Docker image"
                    def now = new Date().format("yyyyMMddHHmm")
                    OLD_TAG = now
                    sh "docker push ${DOCKER_USERNAME}/${IMAGE_NAME}:${OLD_TAG}"
                    sh "docker push ${DOCKER_USERNAME}/${IMAGE_NAME}:latest" // 최신 태그도 푸시
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
