FROM openjdk:8-alpine
WORKDIR workdir/app
RUN apk update && apk add bash
COPY moviedb-api-service/target/*.jar app.jar
COPY ./wait-for-it.sh .
CMD java -jar app.jar
