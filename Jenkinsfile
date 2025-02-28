pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "camperx-api"
        VERSION = "202502281402"
        EC2_IP = "52.79.219.130"
        JAR_FILE = "CamperXoffice-0.0.1-SNAPSHOT.jar"
        DOCKER_REPO = "jeondaehoon"  // Docker Hub 계정명
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/jeondaehoon/dockerbackend.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    echo "Building Docker image with tag ${VERSION}"
                    sh "docker build -t ${DOCKER_REPO}/${DOCKER_IMAGE}:${VERSION} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-credentials', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
                        echo "Logging into Docker Hub"
                        // Docker login 수정
                        sh "docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}"

                        echo "Pushing Docker image to DockerHub"
                        // docker push 명령어 확인
                        sh "docker push ${DOCKER_REPO}/${DOCKER_IMAGE}:${VERSION}"
                    }
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    withCredentials([sshUserPrivateKey(credentialsId: 'ec2-ssh-key', keyFileVariable: 'SSH_KEY')]) {
                        echo "Deploying to EC2"
                        sh """
                        ssh -o StrictHostKeyChecking=no -i ${SSH_KEY} ubuntu@${EC2_IP} << EOF
                        docker login -u ${DOCKER_USERNAME} -p ${DOCKER_PASSWORD}
                        docker pull ${DOCKER_REPO}/${DOCKER_IMAGE}:${VERSION}
                        docker stop camperx-api || true
                        docker rm camperx-api || true
                        docker run -d -p 8080:8080 --name camperx-api ${DOCKER_REPO}/${DOCKER_IMAGE}:${VERSION}
                        EOF
                        """
                    }
                }
            }
        }
    }
}
