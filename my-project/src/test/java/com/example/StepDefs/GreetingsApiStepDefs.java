package com.example.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@CucumberContextConfiguration
@AutoConfigureMockMvc
public class GreetingsApiStepDefs {

    @Autowired
    private MockMvc mockMvc;

    private MvcResult result;

    @Given("the application is running")
    public void the_application_is_running() {
        // This step ensures that the application is running, and we do not need to do anything here
    }

    @When("I send a GET request to {string}")
    public void i_send_a_get_request_to(String string) throws Exception {
        result = mockMvc.perform(MockMvcRequestBuilders.get("/greet"))
                .andExpect(status().isOk())  // Expect status 200
                .andReturn();  // Store the result for later verification

    }

    @Then("I should receive a response with status code 200")
    public void i_should_receive_a_response_with_status_code_200() {
        // Verify that the status code in the response is 200 (OK)
        assertEquals(200, result.getResponse().getStatus());
    }

    @Then("the response body should be {string}")
    public void the_response_body_should_be(String expectedResponseBody) throws UnsupportedEncodingException {
        // Verify that the response body matches the expected value
        assertEquals(expectedResponseBody, result.getResponse().getContentAsString());
    }
}
