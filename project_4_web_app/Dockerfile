FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn clean tomcat7:run -Dlibrary.service.host=${VAR_SERVICE_HOST}
