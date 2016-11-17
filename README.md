# Scanbook-Project
Scanbook - To search with isbn and retrieve books from google API call


FRONT-END ->

LIBRARIES - BOOSTRAP,AJAX( To provide asynchronous calls and web responsive page)
LANGUAGES - PHP/HTML/JAVASCRIPT
DATABASE- MYSQL (note - mysql dump files are located in back-end folder)

Validation of ISBN with error message (numeric, 13 digits long, starting with 9 and weighted sum checksum) 

The ISBN is used to lookup book Title, Author, Number of pages using https://developers.google.com/books/ API

There is a way for the user to indicate they have or have not read the book -(using checkboxes)

A notes section allows the user to provide notes on the book 

All information is entered and presented on a single web page

If the ISBN already exists in the database then return the stored information instead of looking it up using the Google book API

The web page makes asynchronous calls to a back-end server (that you create) to populate the web page.


BACK-END ->

LANGUAGES - JAVA
FRAMEWORK/API - SPRING REST API
DATABASE - MYSQL

Write a REST web service that allows me to inventory my books. Use Java Spring as the framework and mySQL as the database.
(GET METHOD - REST API)


As a user of this service, it should allow me to add a book along with attributes such as the barcode, title, author, number of pages, and whether or not I've read it.
(POST METHOD)


I should be able to delete a book by barcode. Also, I want to be able to retrieve information about a book by barcode.
(DELETE METHOD)

