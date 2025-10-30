pipeline {
    agent {
        docker {
            image 'jenkins-agent-chrome:latest'
            args '-u root:root'
        }
    }
    environment {
        MAVEN_WRAPPER = './mvnw'
        BROWSER = 'chrome'
    }

    stages {
        stage('Переключаемся на нужную ветку') {
            steps {
                git branch: 'jenkins_test', url: 'https://github.com/philiesel/project.git'
            }
        }

        stage('Права на запуск mvnw') {
            steps {
                sh 'chmod +x mvnw'
            }
        }

        stage('Build') {
            steps {
                echo "Запускаем тесты через Maven Wrapper"
                sh "${MAVEN_WRAPPER} clean test -Dmaven.test.failure.ignore=false"
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