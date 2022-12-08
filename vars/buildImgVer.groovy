#!/usr/bin/env groovy

def call() {
    echo 'building docker image..'
    withCredentials([usernamePassword(credentialsId:'dockerhub-rep', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t youssefjeh/my-app:${IMAGE_NAME} ."
        sh "docker tag youssefjeh/my-app:${IMAGE_NAME} dockerysf/my-app:${IMAGE_NAME}"
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push dockerysf/my-app:${IMAGE_NAME}"
    }
}
