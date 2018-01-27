FROM maven:3-jdk-8

WORKDIR /app

ADD . /app

CMD mvn clean tomcat7:run \
	-Dlibrary.service.host=${VAR_WEB_SERVICE} \
	-Dlibrary.service.port=${VAR_WEB_SERVICE_PORT} \
	-Dlibrary.app.port=${VAR_WEB_APP_PORT}
