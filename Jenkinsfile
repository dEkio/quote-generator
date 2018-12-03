#!groovy
pipeline {

    agent any

    parameters {
        string(name: 'pactConsumerTags', defaultValue: 'master')
    }

    stage('Build') {
        sh "mvn clean verify -Dpactbroker.tags=${params.pactConsumerTags}"
    }

    stage('Check Pact Verifications') {
        steps {
            sh 'curl -LO https://github.com/pact-foundation/pact-ruby-standalone/releases/download/v1.61.1/pact-1.61.1-linux-x86_64.tar.gz'
            sh 'tar xzf pact-1.61.1-linux-x86_64.tar.gz'
            dir('pact/bin') {
                sh "./pact-broker can-i-deploy -a quote-generator -b http://localhost -e ${GIT_COMMIT}"
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

