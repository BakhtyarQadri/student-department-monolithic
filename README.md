# Features
- Three layer architecture (controller, service, persistance)
- Restful CRUD api's for "Student"
- Basic validations
- Centralize exception handling
- DTO's
# Endpoints

### POST - add a student <br>
http://localhost:8080/students <br>
{
    "name": "Shahryar",
    "email": "mshahryarqadri@gmail.com",
    "age": 20,
    "departmentId": 1
}
### GET - get all students <br>
http://localhost:8080/students
### GET - get a student by id <br>
http://localhost:8080/students/1
### PUT - update a student by id <br>
http://localhost:8080/students/1 <br>
{
    "name": "Bakhtyar",
    "email": "bakhtyar@gmail.com",
    "age": 24,
    "departmentId": 2
}
### DELETE - delete a student by id <br>
http://localhost:8080/students/1
