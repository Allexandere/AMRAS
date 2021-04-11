FROM openjdk:8-alpine
WORKDIR /workdir
COPY target/*.jar app.jar
COPY ../wait-for-it.sh entrypoint.sh .
EXPOSE 8084
ENTRYPOINT ["java","-jar","app.jar"]