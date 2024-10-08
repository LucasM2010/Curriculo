# Etapa de construção
FROM maven:3.8.6-openjdk-17 AS build

# Define o diretório de trabalho
WORKDIR /app

# Copia o pom.xml e a fonte
COPY pom.xml .
COPY src ./src

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR gerado na etapa de construção
COPY --from=build /app/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Comando para rodar a aplicação
CMD ["java", "-jar", "demo.jar"]
