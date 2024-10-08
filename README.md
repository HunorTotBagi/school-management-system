# Electronic Diary

This is a backend system for an electronic diary. The system includes functionalities for managing teachers, subjects, students, parents, classes, and grading. It also includes features for authentication, sending emails, logging, and providing endpoints for downloading log files.

## Runnig the project

You need to instal Lombok in order to run the code. You can follow this easy tutorial for this purpose [How to Install Lombok in Eclipse STS (Spring Tool Suite) IDE
](https://www.youtube.com/watch?v=VR7VaiXHJEY)

## Features

### CRUD Operations

- `Teachers`: Create, Read, Update, Delete
- `Subjects`: Create, Read, Update, Delete
- `Students`: Create, Read, Update, Delete
- `Parents`: Create, Read, Update, Delete

### Class Management

- A student attends a class (department)
- A teacher teaches a subject to a class

### Grading System

- Add grading types (e.g., oral examn, written examn, homework)

### Authentication

- Secure login and registration for users with `Baisc Auth`

### Views

- Implement views for managing and displaying data

### Email Notifications

- Send email notifications when a teacher give grade to a student

### Logging

- Implement a logger to track system events and errors
- Provide an endpoint to download the log file

### Swagger 

- Swagger for generating all endpoints implemented
