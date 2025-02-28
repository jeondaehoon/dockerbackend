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

        stage('Build Docker Image') {
            steps {
                script {
                    def now = new Date().format("yyyyMMddHHmm")
                    def OLD_TAG = now

                    sh "docker tag ${IMAGE_NAME}:latest ${IMAGE_NAME}:${OLD_TAG} || true"
                    sh "docker build -t ${IMAGE_NAME}:${OLD_TAG} . || exit 1"
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    echo "Logging in to Docker Hub..."
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                        sh 'docker login -u $DOCKER_USERNAME -p $DOCKER_PASSWORD'
                    }

                    echo "Pushing Docker image"
                    def now = new Date().format("yyyyMMddHHmm")
                    def OLD_TAG = now
                    sh "docker push ${DOCKER_USERNAME}/${IMAGE_NAME}:${OLD_TAG}"
                }
            }
        }

        stage('Deploy') {
            steps {
                script {
                    echo "Deploying with docker-compose..."
                    sh "docker-compose -f ${DOCKER_COMPOSE_FILE} up -d || exit 1"
                }
            }
        }
    }
}