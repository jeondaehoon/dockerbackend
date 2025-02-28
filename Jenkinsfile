pipeline {
    agent any

    environment {
        DOCKER_USERNAME = credentials('docker-hub-username')  // Jenkins Credentials ID
        DOCKER_PASSWORD = credentials('docker-hub-password')  // Jenkins Credentials ID
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
                    echo "Logging into Docker Hub"
                    sh "echo ${DOCKER_PASSWORD} | docker login -u ${DOCKER_USERNAME} --password-stdin"

                    echo "Pushing Docker image to DockerHub"
                    sh "docker push ${DOCKER_REPO}/${DOCKER_IMAGE}:${VERSION}"
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    echo "Deploying to EC2"
                    sh """
                    ssh -o StrictHostKeyChecking=no -i /path/to/your-key.pem ubuntu@${EC2_IP} << EOF
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
