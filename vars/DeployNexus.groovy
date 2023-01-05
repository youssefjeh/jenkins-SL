#!/usr/bin/env groovy

def call() {
    echo 'deploy to Nexus..'
    pom = readMavenPom file: "pom.xml";
    filesByGlob = findFiles(glob: "target/*.${pom.packaging}");
    echo "${filesByGlob[0].name} ${filesByGlob[0].path} ${filesByGlob[0].directory} ${filesByGlob[0].length} ${filesByGlob[0].lastModified}"
    artifactPath = filesByGlob[0].path;
    artifactExists = fileExists artifactPath;
    if(artifactExists) {
        echo "*** File: ${artifactPath}, group: ${pom.groupId}, packaging: ${pom.packaging}, version ${pom.version}";
        nexusArtifactUploader(
                            nexusVersion: 'nexus3,
                            protocol: 'http',
                            nexusUrl: '20.199.22.41:8081',
                            groupId: 'pom.in.javahome',
                            version: 'pom.1.0.1-SNAPSHOT',
                            repository: 'MavenYJ-central',
                            credentialsId: 'NEXUS_CRED,
                            artifacts: [
                                [artifactId: 'pom.simple-app',
                                classifier: '',
                                file: artifactPath,
                                type: pom.packaging],
                                [artifactId: 'pom.simple-app',
                                classifier: '',
                                file: "pom.xml",
                                type: "pom"]
                            ]
                        );
                    } else {
                        error "*** File: ${artifactPath}, could not be found";
                      }
}
