FROM gradle:latest

WORKDIR /home/gradle/src

COPY . .

RUN gradle build

