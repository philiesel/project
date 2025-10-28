pipeline {
    agent any

    environment {
        MAVEN_WRAPPER = './mvnw'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'HWF_API', url: 'https://github.com/philiesel/project'
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
                branch 'HWF_API'
            }
            steps {
                echo 'Deploying application...'
            }
        }
    }

    post {
        success {
            echo 'Build and tests completed successfully!'
        }
        failure {
            echo 'Build or tests failed!'
        }
    }
}