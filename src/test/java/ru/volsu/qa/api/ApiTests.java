package ru.volsu.qa.api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import ru.volsu.qa.models.Post;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ApiTests {

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.port = 443;
    }

    @Test
    @Ignore
    public void testVerifyStatusCodeForGetPosts() {
        when()
                .request("GET", "/posts")
        .then()
                .statusCode(200);
    }

    @Test
    @Ignore
    public void testVerifyStatusCodeForGetPostsWithLogging() {
        given()
                .log().all()
        .when()
                .request("GET", "/posts")
        .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    @Ignore
    public void testVerifyStatusCodeForGetPostsWithConditionalLogging() {
        given()
                .log().ifValidationFails()
        .when()
                .request("GET", "/posts")
        .then()
                .log().ifValidationFails()
                .statusCode(200);
    }

    @Test
    @Ignore
    public void testVerifyResponseTimeForGetPosts() {
        when()
                .request("GET", "/posts")
        .then()
                .time(lessThan(5000L));
    }

    @Test
    @Ignore
    public void testVerifyResponseStatusForCreatePost() {
        Post newPost = new Post(2, "Title", "Some text");
        given()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .post( "/posts")
        .then()
                .statusCode(201);
    }

    @Test
    @Ignore
    public void testVerifyResponseBodyForCreatePost() {
        Post newPost = new Post(2, "Title", "Some text");
        given()
                .contentType(ContentType.JSON)
                .body(newPost)
        .when()
                .post( "/posts")
        .then()
                .assertThat()
                .body("userId", equalTo(newPost.getUserId()))
                .body("title", equalTo(newPost.getTitle()))
                .body("body", equalTo("fgdgfgdf"))
                .body("id", notNullValue());
    }
}
