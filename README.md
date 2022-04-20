# BookStore

It's a BookStore restfull service. It uses an in-memory database H2 with Spring Data Integration with JPA/Hibernate. It uses Global exception Handling. It run on default 8080
 
Here we can perform Adding new books, Get particular book based on Id, Get all the books, Edit a book based on ID, and Delete particular book based on Id.

Here are some endpoints you can call:

### Create a book

POST /books

This API validate the given input and create a book with auto generated ID.

### Get all book

GET /books

This will get all the books from the data base. If no books exists it will return "Failed due to bad input message".

### Get particular book by ID

GET /books/{id}

This API will return the particular book based on the id given. If the book dosen't exists it will through "Failed due to bad input message".

### Update particular book by ID

PUT /books/{id}

It will validate the given input and update all the fields of the particular book based on ID. If the input validation failes it throug 	
"Updated failed due to bad input" (400). If the book dosen't exist it will through "Unable to find book with the given id". 

### Update the given field book by ID
PATCH /books/{id}

Validate the given input and update the particular filed present n the input.

### Delete the book by ID

DELETE /books/{id}

Delete the particular record from the DB.




