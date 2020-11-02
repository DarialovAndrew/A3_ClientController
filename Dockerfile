FROM openjdk:11
EXPOSE 8887
ADD target/ClientsService-0.0.1-SNAPSHOT.jar ClientsService-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ClientsService-0.0.1-SNAPSHOT.jar"]