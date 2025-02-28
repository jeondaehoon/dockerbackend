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
                    // Git 저장소에서 배포할 브랜치 가져오기
                    git branch: "${BRANCH_NAME}", url: "${GIT_REPO}"
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    // 현재 날짜를 "yyyyMMddHHmm" 형식으로 얻기
                    def now = new Date().format("yyyyMMddHHmm")
                    def OLD_TAG = now  // 현재 시간을 태그로 사용

                    // 환경 변수로 설정
                    env.OLD_TAG = OLD_TAG

                    // Docker 이미지 빌드
                    echo "Building Docker image with tag ${OLD_TAG}"
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
                    echo "Pushing Docker image ${IMAGE_NAME}:${OLD_TAG} to Docker Hub"
                    sh "docker push ${DOCKER_USERNAME}/${IMAGE_NAME}:${OLD_TAG}"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    // Docker Compose로 배포
                    echo "Deploying with docker-compose..."
                    sh "DOCKER_USERNAME=${DOCKER_USERNAME} OLD_TAG=${OLD_TAG} docker-compose -f ${DOCKER_COMPOSE_FILE} up -d --build --force-recreate"
                }
            }
        }
    }
}
