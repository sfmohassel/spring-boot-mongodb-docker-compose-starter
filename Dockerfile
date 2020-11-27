FROM openjdk:11-jdk-slim

# time zone
ENV TZ=Asia/Tehran
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

# remove us from sources list
RUN sed -i 's|http://us.|http://|g' /etc/apt/sources.list

# add iran sources
RUN > /etc/apt/sources.list
RUN echo "deb http://debian.asis.ai/debian buster main" >> /etc/apt/sources.list
RUN echo "deb http://debian.asis.ai/debian-security buster/updates main" >> /etc/apt/sources.list

# update sources
RUN apt-get update

# install some packages
RUN apt-get install -y curl

# run under a user
RUN groupadd normalgroup
RUN useradd -G normalgroup normaluser
USER normaluser:normalgroup

# run app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar

# if you want to start the app using an application.properties file located
#ENTRYPOINT ["java","-jar","/app.jar", "--spring.config.location=file:/application.properties"]

# if you've already overriden configuration settings via environment variables
ENTRYPOINT ["java","-jar","/app.jar"]