pipeline {
    agent any //run on any node in env
    
    //sets up env variables for later use in Package pipeline stage
    environment {
        DOCKER_IMAGE = 'sieve-app'
        DOCKER_TAG = 'latest'
    }
    
    stages {
        //runs ant commands to build Sieve.jar
        stage('Build') {
            steps {
                echo 'Building Java Sieve with Ant...'
                bat '''
                    ant clean 
                    ant compile
                    ant jar
                    echo "✅ Build successful - JAR created in build/jar/"
                '''
            }
        }
        
        //test Sieve.jar with an input of 100, then asserts result
        stage('Test') {
            steps {
                echo 'Testing Application with input 100...'
                script {
                    // Run test and capture output
                    def testOutput = bat(
                        script: '''
                            ant test
                            type test_output.txt
                        ''',
                        returnStdout: true
                    ).trim() // .trim() removes trailing whitespace from returnStdout
                    
                    // Read expected output 
                    def case100success = readFile('case100success.txt').trim()
                    
                    // Compare outputs (basic comparison - remove spaces and compare)
                    def receivedOutput = testOutput.replaceAll("[^0-9,]", "").trim()
                    def expectedOutput = case100success.replaceAll("[^0-9,]", "").trim()
                    
                    //display answer and result for visibility
                    echo "Received output: ${receivedOutput}"
                    echo "Expected output: ${expectedOutput}"
                    
                    //report test results
                    if (receivedOutput == expectedOutput) {
                        echo "✅ Test PASSED!"
                        currentBuild.result = 'SUCCESS'
                    } else {
                        error("❌ Test FAILED! Outputs don't match.")
                    }
                }
            }
        }
        
        //This stage buuilds the docker container
        stage('Package') {
            steps {
                echo 'Building Docker Container...'
                bat '''
                    REM Build Docker image
                    docker build -t %DOCKER_IMAGE%:%DOCKER_TAG% .
                    
                    REM Test the container
                    echo "Testing container..."
                    docker run --rm %DOCKER_IMAGE%:%DOCKER_TAG% 5
                    
                    echo "✅ Docker image built successfully!"
                    echo "Image: %DOCKER_IMAGE%:%DOCKER_TAG%"
                '''
            }
        }
    }
    
    //this block will ALWAYS BE entered regardless of pipeline success status. sub-blocks are conditional
    post {
        always {
            // delete up test output
            bat 'del /F test_output.txt || echo "No test_output.txt to delete"'
            
            // save Docker image 
            bat '''
                docker save %DOCKER_IMAGE%:%DOCKER_TAG% > sieve-image.tar
                echo "Docker image saved as sieve-image.tar"
            '''
        }
        success {
            echo '🎉 Pipeline completed successfully!'
        }
        failure {
            echo '💥 Pipeline failed!'
        }
    }
}