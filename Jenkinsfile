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
                    docker.image('maven:3.8.4').inside {
                        echo "Building Java project with Maven inside Docker"
                        sh 'mvn clean install -P alzza -DskipTests'
                    }
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
                    withCredentials([usernamePassword(credentialsId: 'dockerhub-creds', usernameVariable: 'DOCKER_USERNAME', passwordVariable: 'DOCKER_PASSWORD')]) {
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
                    withCredentials([[$class: 'SSHUserPrivateKey', credentialsId: 'SSH_KEY', keyFileVariable: 'SSH_KEY_PATH', usernameVariable: 'SSH_USER']]) {
                        echo "Deploying to EC2"
                        sh """
                            ssh -o StrictHostKeyChecking=no -i $SSH_KEY_PATH $SSH_USER@ec2-instance-ip << 'EOF'
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