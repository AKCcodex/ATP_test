pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'master',
                    url: 'https://github.com/AKCcodex/ATP_test.git'
            }
        }

        stage('Start Docker Grid') {
            steps {
                sh '/snap/bin/docker-compose down || true'
                sh 'docker rm -f selenium-hub chrome-node test-runner || true'
                sh '/snap/bin/docker-compose up -d selenium-hub chrome-node'
                sh 'sleep 10'
            }
        }

        stage('Run Tests') {
            steps {
                sh '/snap/bin/docker-compose up --build test-runner'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    allowMissing: true,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Test Report'
                ])
            }
        }
    }

    post {
        always {
            sh '/snap/bin/docker-compose down || true'
        }
    }
}