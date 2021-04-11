FROM openjdk:8-alpine
WORKDIR /workdir
COPY target/*.jar app.jar
EXPOSE 8888
ENTRYPOINT ["java","-jar","app.jar"]