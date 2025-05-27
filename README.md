# Blog Web Application

A full-stack blog application built with Spring Boot 3, Thymeleaf, and MySQL. This project demonstrates modern web development practices and includes essential features for a robust, secure, and user-friendly blog platform.

## Features

- **User Authentication**
  - Secure registration, login, and logout using Spring Security and Thymeleaf Security
- **Post Management**
  - Create, view, edit, and delete your own posts
  - List all posts with dynamic pagination
- **Comment System**
  - Add and view comments on posts
- **Search Functionality**
  - Search posts via a fully integrated navbar search bar
- **Dynamic Navigation**
  - Navbar adapts to user roles and authentication status
- **Rich Text Editing**
  - Rich text editor with HTML content support and automatic styling
- **Error Handling**
  - Custom, dynamic error pages for all HTTP status codes
- **Admin Features**
  - View, edit, and delete any post or comment
  - Access restricted admin-only routes
- **Validation and Security**
  - Form and bean validation using Hibernate Validator
  - Authentication and authorization via Spring Security

## Architecture

- **Three-Layer Architecture**
  - Controller, Service, and Repository/DAO layers
- **Spring MVC**
  - Model-View-Controller design for backend logic and frontend integration
- **Thymeleaf Templating**
  - Server-side rendering with Thymeleaf attributes, layouts, and form handling
- **Entity Mappers**
  - Custom mapper for converting between Entity and DTO objects

## Technologies

| Technology           | Purpose/Description                        |
|----------------------|--------------------------------------------|
| Java 23              | Core programming language                  |
| Spring Boot 3        | Application framework                      |
| Spring Framework 6   | Dependency injection, core utilities       |
| Spring MVC 6         | Web application framework                  |
| Thymeleaf            | Server-side templating engine              |
| Bootstrap CSS 5      | Frontend styling and responsive design     |
| Spring Security 6    | Authentication and authorization           |
| Spring Data JPA      | Data access and persistence                |
| Hibernate 6          | ORM framework                              |
| MySQL                | Relational database                        |
| Maven                | Dependency management and build tool       |
| IntelliJ IDEA        | IDE for development                        |
| Lombok               | Java annotation processor for boilerplate  |

## Database Setup

- **Auto-configured MySQL database**
  - Edit `application.properties` with your MySQL credentials
  - Uses MySQL Workbench for database management

## Getting Started

1. **Clone the repository**
2. **Set up your MySQL database**
   - Update `application.properties` with your database credentials
3. **Build and run the application**
   - Use Maven to build and start the application
4. **Access the application**
   - Open your browser and navigate to `http://localhost:8080/posts`

## Features Overview

- **User Experience**
  - Intuitive navigation and dynamic content based on user role
  - Rich text editing for posts and comments
- **Security**
  - Role-based access control (admin vs. standard user)
  - Secure authentication and session management
- **Customization**
  - Ability to customize error pages and admin features

## Screenshots

Below you can find a collection of screenshots showcasing the main features of the application.

### Imgur Album

You can view all screenshots in the following Imgur album:

## Screenshots

[Screenshot preview](https://imgur.com/a/j63h9O5)  
[View all screenshots on Imgur](https://imgur.com/a/XpNWwxC)
