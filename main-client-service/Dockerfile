FROM openjdk:8-alpine
WORKDIR workdir/app
RUN apk update && apk add bash
COPY main-client-service/target/*.jar app.jar
COPY ./wait-for-it.sh .
CMD java -jar app.jar
