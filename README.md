# Todo List Application

A simple Todo List application built with Spring Boot and Thymeleaf. This application allows users to create, manage, and filter tasks with deadlines.

## Features

- Add new tasks with titles and deadlines.
- Mark tasks as completed or incomplete.
- Filter tasks by completion status.
- Sort tasks by title or deadline.
- Delete tasks.

## Technologies Used

- **Spring Boot**: A framework for building Java applications.
- **Thymeleaf**: A modern server-side Java template engine for web and standalone environments.
- **JPA (Java Persistence API)**: For database interactions.
- **MySQL**: A relational database management system.
- **Lombok**: A Java library that helps to reduce boilerplate code.

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven
- MySQL Server

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/yourusername/todo-list-app.git
   cd todo-list-app```

2. Update the application.properties file to configure your database connection:

    ```spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update```
    

3. Build the project using Maven:

    ```mvn clean install```


4. Run the application:

    ```mvn spring-boot:run```


5. Open your browser and navigate to http://localhost:8080.

**Usage**
- To add a new task, enter the task title and deadline in the form and click "Add Task".
- Use the filter and sort options to manage your tasks effectively.
- Click on the checkbox next to a task to mark it as completed or incomplete.
- Click "Delete" to remove a task from the list.

**Contributing**
Contributions are welcome! Please feel free to submit a pull request or open an issue.

**License**
This project is licensed under the MIT License - see the LICENSE file for details.

**Tools**
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Thymeleaf](https://www.thymeleaf.org/)
- [MySQL](https://www.mysql.com/)
- [Lombok](https://projectlombok.org/)
