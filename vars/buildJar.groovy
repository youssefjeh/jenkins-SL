#!/usr/bin/env groovy

def call() {
    echo 'building Jar file...'
    sh 'mvn clean package'
}
