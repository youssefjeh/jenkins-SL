#!/usr/bin/env groovy

def call() {
    echo 'deploy to Nexus..'
    withCredentials([usernamePassword(credentialsId: 'nexus credentials',usernameVariable: 'USERNAME', passwordVariable: 'PASSWORD')]) {
      sh "mvn deploy -DaltDeploymentRepository=releases::default::http://20.199.22.41:8081/repository/release-maven/ -Dusername=${USERNAME} -Dpassword=${PASSWORD}"
    }
}
