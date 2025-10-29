# ---- स्टेज 1: बिल्ड (Build) ----
# Java 21 JDK (Java Development Kit) का उपयोग करके ऐप को बिल्ड करें
FROM eclipse-temurin:21-jdk AS builder

# वर्किंग डायरेक्टरी सेट करें
WORKDIR /app

# Maven रैपर (wrapper) फ़ाइलों को कॉपी करें
COPY .mvn/ .mvn
COPY mvnw .
COPY pom.xml .

# केवल ज़रूरी निर्भरता (dependencies) डाउनलोड करें
RUN ./mvnw dependency:go-offline

# बाकी सोर्स कोड को कॉपी करें
COPY src/ src/

# ऐप को पैकेज (JAR फ़ाइल) करें
# -DskipTests टेस्ट को छोड़ देगा और बिल्ड को तेज़ करेगा
RUN ./mvnw clean package -DskipTests


# ---- स्टेज 2: रन (Run) ----
# एक छोटी Java 21 JRE (Java Runtime Environment) इमेज का उपयोग करें
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# ज़रूरी: सुनिश्चित करें कि यह .jar फ़ाइल का नाम आपके /target फोल्डर में मौजूद नाम से मेल खाता हो
# (आमतौर पर यह <artifactId>-<version>.jar होता है)
COPY --from=builder /app/target/tracker-0.0.1-SNAPSHOT.jar app.jar

# ऐप जिस पोर्ट पर चलेगा उसे बताएँ
# (हमने application.properties में 8080 को डिफ़ॉल्ट सेट किया है)
EXPOSE 8080

# ऐप को चलाने के लिए कमांड
ENTRYPOINT ["java", "-jar", "app.jar"]