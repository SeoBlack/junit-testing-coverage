#
# BUILD STAGE
#
FROM maven:3.9-eclipse-temurin-21-alpine AS build
WORKDIR /app

# Copy project descriptor and source
COPY pom.xml ./
COPY src ./src

# Build and run tests (produces JAR and JaCoCo report)
RUN mvn -f pom.xml clean verify -DskipTests=false

#
# PACKAGE STAGE — run tests when container starts
#
FROM maven:3.9-eclipse-temurin-21-alpine
WORKDIR /app

# Copy full project from build stage so we can run tests
COPY --from=build /app/pom.xml ./
COPY --from=build /app/src ./src
COPY --from=build /app/target ./target

# Run tests (and generate reports) when container runs
CMD ["mvn", "verify", "-f", "pom.xml"]
