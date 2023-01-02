pipeline {
    agent any

    stages {
        stage('Informacion del sistema') {
            steps {
                echo 'version de java'
                sh "java --version"
                echo 'version de maven'
                sh "mvn --version"
            }
        }
        stage('Clonado del proyecto de ejemplo y compilacion') {
            steps {
                echo 'Se clona el proyecto de github'
                git branch: 'feature/app', credentialsId: '663f2944-7e26-4e0c-8349-07e2b8338417', url: 'https://github.com/davidaltair/testing.git'
                sh ' mvn clean package'
            }
        }
        stage('Se copia a webapps de tomcat') {
            steps {
                echo 'Se copia el war al tomcat'
                sh 'cp ./target/hello-world-maven.war /opt/tomcat/webapps'
            }
        }
    }
}
