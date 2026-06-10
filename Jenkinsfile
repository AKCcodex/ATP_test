pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/yourrepo/yourproject.git'
            }
        }

        stage('Start Docker Grid') {
            steps {
                sh 'docker-compose up -d selenium-hub chrome-node'
                sh 'sleep 10' // wait for grid to be ready
            }
        }

        stage('Run Tests') {
            steps {
                sh 'docker-compose up --build test-runner'
            }
        }

        stage('Publish Report') {
            steps {
                publishHTML(target: [
                    allowMissing: false,
                    alwaysLinkToLastBuild: true,
                    keepAll: true,
                    reportDir: 'test-output',
                    reportFiles: 'ExtentReport.html',
                    reportName: 'Extent Test Report'
                ])
            }
        }

        stage('Cleanup') {
            steps {
                sh 'docker-compose down'
            }
        }
    }

    post {
        always {
            sh 'docker-compose down'
            cleanWs()
        }
    }
}