Jenkinsfile
pipeline {
    agent { docker { image 'maven:3.3.3' } }
    stages {
        stage('build') {
            steps {
                bat 'set'
            }
        }
        stage('Test'){
            steps{
                bat 'echo "Fail!"; exit 1'
            }
        }
    }
}