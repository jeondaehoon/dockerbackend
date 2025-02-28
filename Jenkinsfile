pipeline {
    agent any

    environment {
        DOCKER_IMAGE = "camperx-api"
        VERSION = "202502281402"
        EC2_IP = "52.79.219.130"
        JAR_FILE = "CamperXoffice-0.0.1-SNAPSHOT.jar"
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
                    sh "docker build -t ${DOCKER_IMAGE}:${VERSION} ."
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    // DockerHub에 로그인 (자격증명 설정 필요)
                    echo "Pushing Docker image to DockerHub"
                    sh "docker push ${DOCKER_IMAGE}:${VERSION}"
                }
            }
        }

        stage('Deploy to EC2') {
            steps {
                script {
                    // EC2로 Docker 이미지 배포
                    echo "Deploying to EC2"
                    sh """
                    ssh -i /path/to/your-key.pem ubuntu@${EC2_IP} << EOF
                    docker pull ${DOCKER_IMAGE}:${VERSION}
                    docker run -d -p 8080:8080 --name camperx-api ${DOCKER_IMAGE}:${VERSION}
                    EOF
                    """
                }
            }
        }
    }
}
