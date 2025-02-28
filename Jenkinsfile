pipeline {
    agent { docker { image 'maven:3.8.4-openjdk-17' } }
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        stage('Docker Build') {
            steps {
                script {
                    def app = docker.build("ascdee1234/my-spring-boot-app:${BUILD_NUMBER}", '.')
                    docker.withRegistry('https://index.docker.io/v1/', 'dockerhub-credentials') {
                        app.push()
                    }
                }
            }
        }
        stage('Deploy') {
            steps {
                sh 'docker stop my-spring-boot-container'
                sh 'docker rm my-spring-boot-container'
                sh 'docker run -d -p 80:8080 ascdee1234/my-spring-boot-app:${BUILD_NUMBER} --name my-spring-boot-container'
            }
        }
    }
}
