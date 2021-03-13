pipeline {
    agent any
    stages {
        stage("build") {
            steps {
                sh 'mvn clean'
            }
        }
        stage("test") {
            steps {
                sh 'mvn test'
            }
        }
        stage("package") {
            steps {
                sh 'mvn package'
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml' 
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'deploying'
            } 
            
        }
    }

}