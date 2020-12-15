pipeline {
    agent { label 'nodejs' }

    // Set your OCP project
    environment { APP_NAMESPACE = '...' }

    stages{

        stage('Test'){
            steps {
                sh "node test.js"
            }
        }

        // Add more stages here
    }
}
