#!/usr/bin/env groovy

def call() {
    echo 'building docker image..'
    withCredentials([usernamePassword(credentialsId:'dockerhub-rep', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t youssefjeh/Crud-Application-React-MaterialUI:v6.0 .'
        sh 'docker tag youssefjeh/Crud-Application-React-MaterialUI:v6.0 dockerysfCrud-Application-React-MaterialUI:v6.0'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push dockerysf/Crud-Application-React-MaterialUI:v6.0'
    }
}
