#FROM ubuntu:latest
#LABEL authors="User"
#ENTRYPOINT ["top", "-b"]
# Используем базовый образ Amazon Corretto 17
FROM amazoncorretto:17-alpine

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный JAR в контейнер
COPY target/REST-0.0.1-SNAPSHOT.jar app.jar

# Открываем порт, на котором работает приложение
EXPOSE 8080

# Команда запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]