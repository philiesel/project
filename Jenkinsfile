pipeline {
    agent any

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

        stage('Сделать исполняемым mvnw') {
            steps {
                script {
                    sh 'chmod +x mvnw'
                }
            }
        }

         stage('Установить WebDriver') {
            steps {
                script {
                    if (BROWSER == 'chrome') {
                        sh 'java -jar webdriver-manager.jar chrome'
                    } else if (BROWSER == 'firefox') {
                        sh 'java -jar webdriver-manager.jar firefox'
                    }
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
                branch 'jenkins_test'
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