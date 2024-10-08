# Etapa de construção
FROM maven:3.8.6-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o arquivo pom.xml e o código fonte
COPY pom.xml .
COPY src ./src

# Faz o build do projeto
RUN mvn clean package -DskipTests

# Etapa de execução
FROM openjdk:17-jdk-slim

# Copia o artefato gerado da etapa de build
COPY --from=build /app/target/*.jar app.jar

# Expondo a porta
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
