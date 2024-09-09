# REST API Architecture Module Practical Task

## Necessary Tools

Java Development Kit 11+

Apache Maven 3.6.0+, Gradle

## Task 1.
Please make a code review. 
```
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserController {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASS = "password"; 

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        String userId = request.getParameter("userId");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
            
            String sql = "SELECT * FROM Users WHERE id = '" + userId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            
            List<String> users = new ArrayList<>();
            while (rs.next()) {
                users.add(rs.getString("name"));
            }

            response.setContentType("application/json");
            response.setStatus(200); 

            response.getWriter().println(users.toString());

            rs.close();
            stmt.close();
            conn.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (username.length() < 5) {
            try {
                resp.getWriter().write("Username is too short!");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        this.DB_URL = "jdbc:mysql://localhost:3306/anotherdb"; // Intentional bad practice

        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            resp.setStatus(500); 
            return;
        }

        System.out.println("Received user: " + username);

        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(i + " ");
            }
        }
        resp.getWriter().write("User successfully created!");
    }
}
```

## TASK 2.
**Hands-on Project: Building a REST API**

**Step 1: Set Up the Project Environment**

1. **Create a New Spring Boot Project:**
    1. Use Spring Initializr or your favorite IDE to create a new Spring Boot project.
    1. Choose the following dependencies:
        1. **Spring Web**: For building web applications.
        1. **Spring Data JPA**: For data persistence.
        1. **Spring Boot Security**: For authentication and authorization.
        1. **H2 Database**: For an in-memory database (or use MySQL/PostgreSQL for a production-like environment).
        1. **Spring Boot Actuator**: For monitoring and management.
1. **Configure the Application Properties:**
    1. Open application.properties or application.yml and configure the following:

**Step 2: Define the Data Model**

1. **Create a User Entity:**
    1. Define a User entity to represent the user data in the database.
1. **Create a User Repository:**
    1. Create a repository interface for the User entity.

**Step 3: Implement CRUD Operations**

1. **Create a User Service:**
    1. Implement a service class to handle the business logic for the User entity.
1. **Create a User Controller:**
    1. Implement a controller class to handle HTTP requests and map them to the service methods.

**Step 4: Implement Authentication and Authorization**

1. **Configure Security:**
    1. Create a security configuration class to set up basic authentication.

**Step 5: Implement Error Handling**

1. **Create a Global Exception Handler:**
    1. Use @ControllerAdvice to handle exceptions globally.
1. **Define Error Response Structure:**
    1. Create an ErrorResponse class to structure error messages.

**Step 6: Implement Versioning**

1. **Use URI Versioning:**
    1. Implement versioning by creating different versions of the controllers.

**Step 7: Implement Pagination**

1. **Add Pagination to the User Controller:**
    1. Modify the getUsers method to support pagination




