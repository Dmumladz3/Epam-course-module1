package com.epam.resttest;

import com.epam.restservice.jpa.Employee;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class RestServiceApplicationTest {

    private final String employeeLoad = "{\n" +
            "  \"email\": \"ivan.spresov@gmail.com\",\n" +
            "  \"firstName\": \"Ivan\",\n" +
            "  \"lastName\": \"Spresov\"\n" +
            "}";

    private final Gson gson = new Gson();
    private Long id = null;

    @BeforeEach
    public void configureRestAssured() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON).body(employeeLoad);
        var response = httpRequest.post("/employees");
        var body = response.getBody();
        var employee = gson.fromJson(body.asString(), Employee.class);
        id = employee.getId();
    }

    @AfterEach
    public void clearRestAssured() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        httpRequest.delete("/employees/{id}", id);
    }

    @Test
    public void testCreateEmployee() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON).body(employeeLoad);
        var response = httpRequest.post("/employees");
        var body = response.getBody();
        var employee = gson.fromJson(body.asString(), Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void testResponseData() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        var response = httpRequest.get("/employees");
        var body = response.getBody();
        var listType = new TypeToken<List<Employee>>() {
        }.getType();
        List<Employee> employees = gson.fromJson(body.asString(), listType);
        var employee = employees.get(0);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void testGetEmployeeById() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        var response = httpRequest.get("/employees/{id}", id);
        var body = response.getBody();
        var employee = gson.fromJson(body.asString(), Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void testUpdateEmployee() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        httpRequest.contentType(ContentType.JSON).body(employeeLoad);
        var response = httpRequest.put("/employees/{id}", id);
        var body = response.getBody();
        var employee = gson.fromJson(body.asString(), Employee.class);
        assertEquals("Ivan", employee.getFirstName());
    }

    @Test
    public void testDeleteEmployee() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        var response = httpRequest.delete("/employees/{id}", id);
        var body = response.getBody();
        assertTrue(body.asString().isEmpty());
    }

    @Test
    public void testDeleteAll() {
        RestAssured.baseURI = "http://localhost:8080";
        var httpRequest = RestAssured.given();
        var response = httpRequest.delete("/employees");
        var body = response.getBody();
        assertTrue(body.asString().isEmpty());
    }

}
