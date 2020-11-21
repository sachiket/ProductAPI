pipeline{
    agent any
    tools {
		maven 'maven'
	}
    environment
    {
        VERSION="$BUILD_NUMBER"
        PROJECT='NODE_APP'
        IMAGE= "$PROJECT:$VERSION"
        ECRURL='https://196737838717.dkr.ecr.ap-south-1.amazonaws.com/product'
        ECRCRED='ecr:ap-south-1:0f3ebdb1-d235-4a5b-8f86-e1cd4e6c2d78'

    }

    stages {
       
        stage ('Compile Stage'){
			steps{
				sh 'mvn clean compile'	
			}	
		}
        stage ('Build executable jar'){
			steps{
				sh 'mvn install'	
			}	
		}
        stage ('Sonarqube deployment Stage'){
			steps{
				bat 'mvn sonar:sonar'	
			}	
		}
        stage('Image Build'){
            steps{
                script{
                    docker.build('$IMAGE')
                }
            }
        }
        stage('Push Image'){
            steps{
                script{
                    docker.withRegistry(ECRURL, ECRCRED){
                        docker.image(IMAGE).push()
                    }
                }
            }  
        }
    }

    post{
        always{
            sh "docker rmi $IMAGE | true"
        }
    }
}