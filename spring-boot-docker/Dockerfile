FROM openjdk:8
ADD target/spring-boot-docker.jar spring-boot-docker.jar
EXPOSE 8092
ENTRYPOINT ["java", "-jar", "spring-boot-docker.jar"]