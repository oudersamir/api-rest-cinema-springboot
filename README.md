# Sample REST CRUD API with Spring Boot, Mysql, JPA and Hibernate for cinema app
<h2>Steps to Setup</h2>
<h3>1. Clone the application</h3>
<p> https://github.com/oudersamir/api-rest-cinema-springboot.git </p>

<h3>2. Create Mysql database</h3>

<p> create db_cinema </p>

<h3>3. Change mysql username and password as per your installation </h3>

<p>open src/main/resources/application.properties</p>


<p>change spring.datasource.username and spring.datasource.password as per your mysql installation</p>

<h3>4. Build and run the app using maven</h3>

<strong>mvn package<strong>
<p>java -jar target/Cinema-0.0.1-SNAPSHOT.jar</p>

<p>Alternatively, you can run the app without packaging it using -</p>

<strong>mvn spring-boot:run</strong>
<p>The app will start running at http://localhost:8080<p>

<strong>Explore Rest APIs.</strong> <br>
The app defines following CRUD APIs <br>

 ![alt text](https://raw.githubusercontent.com/oudersamir/api-rest-cinema-springboot/master/src/main/resources/static/swagger-description.PNG)
