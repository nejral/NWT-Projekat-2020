FROM openjdk:8-jre-slim
RUN groupadd -g 12000 eureka && \
    useradd -r -u 11000 -g eureka eureka
USER 11000
VOLUME /tmp
EXPOSE 8761
WORKDIR /home/eureka
ADD target/eureka-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["sh", "-c", "java -jar /home/eureka/app.jar"]