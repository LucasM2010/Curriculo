# Etapa de construção
FROM maven:3.8.6-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e as dependências para o contêiner
COPY pom.xml .
COPY src ./src

# Faz o build do projeto e gera o .jar
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Copia o .jar gerado na etapa anterior
COPY --from=build /app/target/*.jar app.jar

# Define a variável de ambiente para o nome da aplicação
ENV SPRING_APPLICATION_NAME=curriculo-api

# Expondo a porta em que a aplicação será executada
EXPOSE 8080

# Comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "/app.jar"]
