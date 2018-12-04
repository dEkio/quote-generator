#!groovy
pipeline {

    agent any

    parameters {
        string(name: 'pactConsumerTags', defaultValue: 'master')
        string(name: 'pactVersion', defaultValue: '1')
    }
    stages {
        stage('Build') {
            steps {
                bat "mvn clean verify -Dpactbroker.tags=${params.pactConsumerTags}"
            }
        }

        stage('Check Pact Verifications') {
            steps {
                dir('pact/bin') {
                    bat ".\\pact-broker.bat can-i-deploy -a quote-generator -b http://localhost -e ${params.pactVersion}"
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

