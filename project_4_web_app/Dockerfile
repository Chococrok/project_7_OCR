FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn clean tomcat7:run \
	-Dlibrary.app.port=${ENV_WEB_APP_PORT}
