pipeline {

    agent any

    environment {
        // Global variables
        NEXUS_CREDENTIALS      = "mydnacodes-nexus-user"
        // Local variables
        COMMIT_AUTHOR          = ""
        COMMIT_MESSAGE         = ""
        //COMMIT_BRANCH          = ""
    }

    tools {
        maven "mvn-3.6"
        jdk "jdk-11"
    }

    stages {
        //stage("Clone git") {
        //    steps {
                //script {
                //    //COMMIT_BRANCH = "${GIT_BRANCH.split("/")[1]}"
                //}

        //        git branch: COMMIT_BRANCH,
        //            credentialsId: "github",
        //            url: "https://github.com/mydna-codes/lib-rest.git"
        //    }
        //}
        stage("Set environment variables") {
            steps {
                script {
                    COMMIT_MESSAGE       = sh script: "git show -s --pretty='%s'", returnStdout: true
                    COMMIT_AUTHOR        = sh script: "git show -s --pretty='%cn <%ce>'", returnStdout: true
                    COMMIT_AUTHOR        = COMMIT_AUTHOR.trim()
                }
            }
        }
        stage("Deploy libraries") {
           steps {
               withCredentials([usernamePassword(credentialsId: NEXUS_CREDENTIALS, passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                   sh "mvn clean deploy -DskipTests=true -Dnexus.username=$USERNAME -Dnexus.password=$PASSWORD --settings .ci/settings.xml"
               }
           }
        }
        stage("Clean maven packages") {
            steps {
                sh "mvn clean"
            }
        }
    }
    post {
       success {
           slackSend (color: '#57BA57', message: "[<${env.BUILD_URL}|Build ${env.BUILD_NUMBER}>] *SUCCESSFUL*\n\nJob: *${env.JOB_NAME}*\n\nBranch: ${COMMIT_BRANCH}\nAuthor: ${COMMIT_AUTHOR}\nMessage: COMMIT_MESSAGE")
       }
       failure {
           slackSend (color: '#BD0808', message: "[<${env.BUILD_URL}|Build ${env.BUILD_NUMBER}>] *FAILED*\n\nJob: *${env.JOB_NAME}*\n\nBranch: ${COMMIT_BRANCH}\nAuthor: ${COMMIT_AUTHOR}\nMessage: COMMIT_MESSAGE")
       }
    }
}