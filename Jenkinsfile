pipeline {
    agent any
    environment {
        DOCKER_COMPOSE_FILE = '/home/ubuntu/docker-compose.yml'
        IMAGE_NAME = "camperX-api"
        GIT_REPO = "https://github.com/jeondaehoon/dockerbackend.git"
        BRANCH_NAME = "deploy"
        PATH = "/usr/bin:/usr/local/bin:/usr/sbin:$PATH"
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
                    sh "docker tag ${IMAGE_NAME}:latest ${IMAGE_NAME}:${OLD_TAG}"
                    sh "docker build -t ${IMAGE_NAME}:${OLD_TAG} ."
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
                    def OLD_TAG = now
                    sh "docker push ${DOCKER_USERNAME}/camperx-backend:${OLD_TAG}"
                }
            }
        }
        
        stage('Deploy') {
            steps {
                script {
                    // 환경 변수 확실히 인식하도록 sh 명령어 내에서 export 사용
                    echo "Deploying with docker-compose..."
                    sh """
                    export DOCKER_COMPOSE_FILE=${DOCKER_COMPOSE_FILE}
                    export IMAGE_NAME=${IMAGE_NAME}
                    docker-compose -f \${DOCKER_COMPOSE_FILE} up -d
                    """
                }
            }
        }
    }
}
