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
                sh 'rm -r /var/lib/jenkins/workspace/Proyecto_Jenkinsfile'
                echo 'Se clona el proyecto'
                //git branch: 'main', credentialsId: '663f2944-7e26-4e0c-8349-07e2b8338417', url: 'https://github.com/davidaltair/testing.git'
                sh ' git clone https://github.com/davidaltair/testing.git /var/lib/jenkins/workspace/Proyecto_Jenkinsfile'
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
                sh 'rm -r /var/lib/jenkins/workspace/Proyecto_Ejemplo'
                echo 'Clonado del proyecto de ejemplo, archivo groovy'
                //git 'https://github.com/jenkins-docs/simple-java-maven-app.git'
                sh ' git clone -b feature/app https://github.com/davidaltair/testing.git /var/lib/jenkins/workspace/Proyecto_Ejemplo'

            }
        }
        stage('Compilacion'){
            steps{
                echo 'Compilacion del proyecto de ejemplo - jar'
                sh 'cd /var/lib/jenkins/workspace/Proyecto_Ejemplo'
                sh 'mvn clean package'
                sh 'ls -lha'
            }
        }
    }
}