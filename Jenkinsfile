#!groovy
pipeline {

    agent any

    parameters {
        string(name: 'pactConsumerTags', defaultValue: 'master')
    }
    stages {
        stage('Build') {
            bat "mvn clean verify -Dpactbroker.tags=${params.pactConsumerTags}"
        }

        stage('Check Pact Verifications') {
            steps {
                dir('pact/bin') {
                    bat ".\\pact-broker.bat can-i-deploy -a quote-generator -b http://localhost -e ${GIT_COMMIT}"
                }
            }
        }
        stage('Deploy') {
            when {
                branch 'master'
            }
            steps {
                echo 'Deploying to prod now...'
            }
        }
    }
}

