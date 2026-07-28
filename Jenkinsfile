pipeline {

    agent any

    environment {
        BROWSER = "chrome"
        ENV = "qa"
    }

    stages {

        stage('Checkout') {
            steps {
                checkout scm
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Run Tests') {
            steps {
                bat "mvn test -Dbrowser=%BROWSER% -Denv=%ENV%"
            }
        }

        stage('Archive Extent Report') {
            steps {
                archiveArtifacts artifacts: 'test-output/ExtentReports/**/*.*',
                        fingerprint: true,
                        allowEmptyArchive: true            }
        }

        stage('Archive Screenshots') {
            steps {
                archiveArtifacts artifacts: 'test-output/screenshots/**/*.*',
                        fingerprint: true,
                        allowEmptyArchive: true            }
        }
    }

    post {

        always {

            junit '**/target/surefire-reports/*.xml'

            archiveArtifacts(
                    artifacts: 'test-output/**/*.*',
                    fingerprint: true,
                    allowEmptyArchive: true
            )

            cleanWs()
        }

        success {
            echo 'Automation Execution Successful.'
        }

        failure {
            echo 'Automation Execution Failed.'
        }
    }
}