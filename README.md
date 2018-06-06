# Seventh project for the OpenClassRooms/Capgemini training

## requirement

Having docker and docker-compose installed on your computer

## running the project

After cloning the project simply launch:

```sh
docker-compose up
```

## sending email with batch

The batch is not dockerized but since the web-service is exposed locally you can
run the batch locally with a simple.

```sh
java -jar target/library-batch-0.1.0.jar
```
