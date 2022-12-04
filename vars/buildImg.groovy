#!/usr/bin/env groovy

def call() {
    echo 'building docker image..'
    withCredentials([usernamePassword(credentialsId:'dockerhub-rep', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t youssefjeh/my-app:3.0 .'
        sh 'docker tag youssefjeh/my-app:3.0 dockerysf/my-app:3.0'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push dockerysf/my-app:3.0'

}