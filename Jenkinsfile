pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'pipeline {
    agent any

    stages {
        stage('Checkout') {
            steps {
                git 'https:/'/https://github.com/chloeled/intellij.git'  // Remplace avec ton URL GitHub
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            junit '/target/test-*.xml'  // Pour publier les résultats des tests JUnit dans Jenkins
        }
    }
}'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
    post {
        always {
            junit '/target/test-*.xml'  // Pour publier les résultats des tests JUnit dans Jenkins
        }
    }
}