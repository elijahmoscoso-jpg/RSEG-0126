# RSEG-0126 Elijah Moscoso
Example GitHub repository

This is for RSEG-0126 / updated for Spring 2023. If you have obtained
this file, you have successfully completed a git pull
operation.

This repository also includes other files which we will see later in the course.

!!! CHANGED LINE FOR ASSIGNMENT 1 !!!
REPOSITORY URL: https://github.com/elijahmoscoso-jpg/RSEG-0126.git

ASG 3

Dockerfile Build Commands (Standard ubuntu)
    docker build -f Dockerfile -t sieve:ubuntu .
    docker run -i --rm sieve:ubuntu

Dockerfile Build COmmands (lite)
    docker build -f Dockerfile.lite -t sieve:lite .
    docker run -i --rm sieve:lite 

ASG 4

build pipeline checklist...

build pipeline to create containerized java application

submission format:
    1 gitlab-cmi.yml/jenkinsfile, should probably go with jenkins
    screenshot of run
    docker image <- for this use "docker image save"

Submission contents
    -create a program in java
    -create a build.xml file
    -ant command proof via screenshot 
    -proof built with ant via screenshot 
    -proof program works via screen shot

pipeline stages:
-build: build application from source
-test: test the application with an input of 100, then compare result against expected output
-package: then package the application into a docker container





switch to java 21 and start jenkins 
be here:C:\Program Files\Jenkins
$env:JAVA_HOME = "C:\Program Files\Java\jdk-21"
$env:PATH = "$env:JAVA_HOME\bin;" + $env:PATH
java --version
java -jar jenkins.war

troubleshoot 8080 already in use error (admin powershell)...
netstat -ano | findstr :8080  #last number is pid
taskkill /PID <pidhere> /F
then run 4 commands in section above...


Dockerfile Build Commands (ppln)
    docker build -f Dockerfile.ppln -t sieve:ppln .
    docker run -i --rm sieve:ppln 