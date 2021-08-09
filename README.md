##Spring Boot Rest Server
This project is an app that cruds data in the database.

###Setup

####Prerequirements
* PostgresSQL with cmd tools (psql added to path)
* Java 16
* IntelliJ IDE

1. Log in to db with cmd (psql -U postgres)
2. (Optional) List all the tables \d
3. If table "person" is not present, create one:
```shell
CREATE DATABASE person;
```
4. Set credentials in the .properties file:
```properties
spring.datasource.username=postgres
spring.datasource.password=your_password
```
5. Run the project. Default object should appear in endpoint below:
```shell
http://localhost:8080/api/v1/person
```

####Requests
```http request
POST http://localhost:8080/api/v1/person
Content-Type: application/json

{
  "name": "John",
  "email": "john.smith@gmail.com",
  "dob": "1995-12-17"
}
```

####View data in cmd
1. Log in to db with cmd (psql -U postgres)
2. (Optional) List all the tables \d
3. Give privileges to db: 
```sql
   GRANT ALL PRIVILEGES ON DATABASE "person" TO postgres;
   ```
4. Connect to database: \c person
5. Display table structure: \d person
6. Display table with values:
```sql
SELECT * FROM person;
```   
