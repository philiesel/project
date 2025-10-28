pipeline {
    agent any

    environment {
        MAVEN_WRAPPER = './mvnw'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'IF_HW6', url: 'https://github.com/philiesel/project.git'
            }
        }

        stage('Сделать исполняемым mvnw') {
            steps {
                script {
                    sh 'chmod +x mvnw'
                }
            }
        }

        stage('Build') {
            steps {
                sh "'$MAVEN_WRAPPER' clean install"
            }
        }

        stage('Test') {
            steps {
                sh "'$MAVEN_WRAPPER' test"
            }
        }

        stage('Deploy') {
            when {
                branch 'IF_HW6'
            }
            steps {
                echo 'Развертывание приложения...'
            }
        }
    }

    post {
        success {
            echo 'Сборка и испытания завершены успешно!'
        }
        failure {
            echo 'Сборка или тесты не пройдены!'
        }
    }
}