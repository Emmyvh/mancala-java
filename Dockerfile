FROM gradle:latest

WORKDIR /MANCALA-JAVA
COPY . .
RUN gradle build

EXPOSE 8080
ENTRYPOINT gradle run

