#!/usr/bin/env groovy

def call() {
    echo 'azure login and push the docker image to acr hub ...'
    withCredentials([usernamePassword(credentialsId:'azure_acr_credentials-', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker tag youssefjeh/my-app:v6.0 javamvn.azurecr.io/my-app:v6.0'
        sh "echo $PASS | docker login -u $USER --password-stdin javamvn.azurecr.io"
        sh 'docker image push javamvn.azurecr.io/my-app:v6.0'
    }
}
