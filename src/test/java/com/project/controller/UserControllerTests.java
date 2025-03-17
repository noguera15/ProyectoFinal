package com.project.controller;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.project.entity.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTests {


    @Autowired
    TestRestTemplate restTemplate;

    /**
    @Test
    public void getEmptyStringWhenGetExample() {
        ResponseEntity<String> createResponse = restTemplate.getForEntity(
                "/example",
                String.class,
                "example");
        assertThat(createResponse.getBody()).isEqualTo("example");
    }

    @Test
    public void getAllUsers() {
        ResponseEntity<List> createResponse = restTemplate.getForEntity(
                "/users",
                List.class,
                List.of());
        assertThat(createResponse.getBody()).isEqualTo(List.of());
    }**/

    @Test
    public void getUserById() {
        ResponseEntity<User> response = restTemplate.getForEntity("/user/1", User.class);

        ResponseEntity<String> responseForTest = restTemplate.getForEntity("/another", String.class);

        assertThat(response.getBody()).isEqualTo(new User());
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        //assertThat(id).isEqualTo(99);

        Double amount = documentContext.read("$.amount");
        //assertThat(amount).isEqualTo(123.45);
    }
    /**
    @Test
    void shouldReturnACashCardWhenDataIsSaved() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/99", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);

        DocumentContext documentContext = JsonPath.parse(response.getBody());
        Number id = documentContext.read("$.id");
        assertThat(id).isEqualTo(99);

        Double amount = documentContext.read("$.amount");
        assertThat(amount).isEqualTo(123.45);
    }

    @Test
    void shouldNotReturnACashCardWithAnUnknownId() {
        ResponseEntity<String> response = restTemplate.getForEntity("/cashcards/1000", String.class);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(response.getBody()).isBlank();
    }

    @Test
    void shouldCreateANewCashCard() {
    CashCard newCashCard = new CashCard(null, 250.00);
        ResponseEntity<Void> createResponse = restTemplate.postForEntity("/cashcards", newCashCard, Void.class);
        assertThat(createResponse.getStatusCode()).isEqualTo(HttpStatus.OK);
    }**/
}
