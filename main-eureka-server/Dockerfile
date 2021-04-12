FROM openjdk:8-alpine
WORKDIR workdir/app
RUN apk update && apk add bash
COPY target/*.jar app.jar
COPY ./wait-for-it.sh .
CMD java -jar app.jar
