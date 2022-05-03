FROM openjdk:11
EXPOSE 8022
ADD target/microservicio-pasive-card.jar microservicio-pasive-card.jar
ENTRYPOINT ["java","-jar","/microservicio-pasive-card.jar"]