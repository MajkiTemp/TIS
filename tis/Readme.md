# Product Review Service

The Product Review Service is a Java Spring Boot application that allows users to manage products and their reviews. It provides RESTful APIs for creating products, retrieving products based on filters, and getting the top 3 popular products based on average ratings.

## Features

- Create products with details such as code, name, price, and description.
- Add reviews to products, including reviewer name, text, and rating.
- Retrieve products based on optional filters such as code and name.
- Get the top 3 popular products based on average ratings.

## Technologies Used

- Java 8+
- Maven
- Spring Boot
- H2 Database
- JPA (Java Persistence API)
- RESTful APIs

## Installation

1. Clone the repository:

git clone https://github.com/MajkiTemp/TIS.git

2. Navigate to the project directory:


3. Build the project using Maven:

mvn clean install


4. Run the application:

java -jar out/artifacts/tis_jar/tis.jar


5. The application will start, and you can access the APIs using Swagger at url:
   http://localhost:8080/swagger-ui/index.html



