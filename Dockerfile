FROM adoptopenjdk/openjdk11:alpine-jre  
ARG JAR_FILE=build/libs/crud-0.0.1-SNAPSHOT.jar 
WORKDIR /opt/app  
COPY ${JAR_FILE} web-crud.jar  
ENTRYPOINT ["java","-jar","web-crud.jar"]
EXPOSE 8282