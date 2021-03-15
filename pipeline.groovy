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
        stage('Deploy - Staging') {
            steps {
                echo 'Deploying'
            }
        }
    }
    post {
        failure {
            mail to: 'L00162972@student.lyit.ie',
                subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                body: "Something is wrong with ${env.BUILD_URL}"
        }
    }

}