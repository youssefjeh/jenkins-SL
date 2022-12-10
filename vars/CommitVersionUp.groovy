#!/usr/bin/env groovy

def call() {
    echo 'Commit Version Update..'
    withCredentials([usernamePassword(credentialsId:'git-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'git config --global user.email "jenkins@exemple.com"'
	sh 'git config --global user.name "jenkins"'

	sh 'git status'
	sh 'git branch'
	sh 'git config --list'

	sh 'git remote set-url origin https://"USER":"PASS"@github.com/youssefjeh/my-app.git'
	sh 'git add .'
	sh 'git commit -m "ci: version bump"'
	sh 'git push origin HEAD:VersionTest'
    }
}
