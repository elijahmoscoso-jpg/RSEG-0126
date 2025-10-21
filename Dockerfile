# Build stage
FROM ubuntu:latest AS build

#install openjdk 17
RUN apt-get update && \
    apt-get install -y openjdk-17-jdk && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists*

WORKDIR /app
COPY Sieve.java .
RUN javac Sieve.java 
RUN test -f Sieve.class

FROM ubuntu:latest

#install openjdk 17 jre
RUN apt-get update && \
    apt-get install -y openjdk-17-jre && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

WORKDIR /app 
COPY --from=build /app/Sieve.class .
ENTRYPOINT ["java", "Sieve"]