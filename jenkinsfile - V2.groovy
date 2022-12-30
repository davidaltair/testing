pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Archivo de jenkinsfile de GitHub'
            }
        }
        stage('Clonado del proyecto') {
            steps {
                echo 'Se clona el proyecto'
                //git branch: 'main', credentialsId: '663f2944-7e26-4e0c-8349-07e2b8338417', url: 'https://github.com/davidaltair/testing.git'
                sh ' git clone https://github.com/davidaltair/testing.git ./testing_clone'
            }
        }
        stage('Informacion del sistema') {
            steps {
                echo 'version de java'
                sh "java --version"
                echo 'version de maven'
                sh "mvn --version"
            }
        }
        stage('Clonado del proyecto de ejemplo') {
            steps {
                echo 'Clonado del proyecto de ejemplo, archivo groovy'
                git 'https://github.com/jenkins-docs/simple-java-maven-app.git'
            }
        }
    }
}
