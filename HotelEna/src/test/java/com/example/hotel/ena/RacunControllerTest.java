package com.example.hotel.ena;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.exception.ApiError;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import com.example.hotel.ena.exception.ApiError;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import io.restassured.RestAssured;
import io.restassured.response.Response;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { TestConfig.class }, loader = AnnotationConfigContextLoader.class)
public class RacunControllerTest extends HotelEnaApplicationTests {
        @Autowired
        private RacunRepository racunRepozitorij;
        private static final String URL_PREFIX = "http://localhost:8080/spring-security-rest";
        @Override
        @Before
        public void setUp() {
            super.setUp();
        }



        @Test
        public void getRacunsList() throws Exception {
            String uri = "/racun";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                    .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            RacunEntity[]  racunlist = super.mapFromJson(content, RacunEntity[].class);
            assertTrue(racunlist.length > 0);
        }
        @Test
        public void createRacun() throws Exception {
            String uri = "/racun";
            RacunEntity racun = new  RacunEntity();
            racun.setCost(120);
            //racun.setCreated();
            racun.setCreatedBy(Long.valueOf(1));
            racun.setPaid(true);
            racun.setUserId((long) 5);
            racun.setReservationId(Long.valueOf(4));
            String inputJson = super.mapToJson(racun);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Racun created successfully");
        }
        @Test
         public void createRacunError() throws Exception {
        String uri = "/racun";
        RacunEntity racun = new  RacunEntity();
        racun.setCost(-120);
        //racun.setCreated(LocalDateTime.now());
        racun.setCreatedBy(Long.valueOf(1));
        racun.setPaid(true);
        racun.setUserId((long) 5);
        racun.setReservationId(Long.valueOf(4));
        String inputJson = super.mapToJson(racun);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Iznos is not valid!");
    }



          /* private RequestSpecification givenAuth() {
        // return RestAssured.given().auth().form("user", "userPass", formConfig);
        // if (cookie == null) {
        // cookie = RestAssured.given().contentType("application/x-www-form-urlencoded").formParam("password", "userPass").formParam("username", "user").post(URL_PREFIX + "/login").getCookie("JSESSIONID");
        // }
        // return RestAssured.given().cookie("JSESSIONID", cookie);
        return RestAssured.given()
                .auth().preemptive()
                .basic("user", "userPass");
    }

    @Test
    public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
        Response response = givenAuth().delete(URL_PREFIX + "/api/foos/1");
        ApiError error = response.as(ApiError.class);

        assertEquals(HttpStatus.METHOD_NOT_ALLOWED, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("Supported methods are"));
    }*/





//AMINA
        // private FormAuthConfig formConfig = new FormAuthConfig(URL_PREFIX + "/login", "temporary", "temporary");

        private String cookie;

        private RequestSpecification givenAuth() {
            // return RestAssured.given().auth().form("user", "userPass", formConfig);
            // if (cookie == null) {
            // cookie = RestAssured.given().contentType("application/x-www-form-urlencoded").formParam("password", "userPass").formParam("username", "user").post(URL_PREFIX + "/login").getCookie("JSESSIONID");
            // }
            // return RestAssured.given().cookie("JSESSIONID", cookie);
            return RestAssured.given()
                    .auth().preemptive()
                    .basic("user", "userPass");
        }

        @Test
        public void whenTry_thenOK() {
            final Response response = givenAuth().get(URL_PREFIX + "/api/foos");
            assertEquals(200, response.statusCode());
            System.out.println(response.asString());

        }

        @Test
        public void whenMethodArgumentMismatch_thenBadRequest() {
            final Response response = givenAuth().get(URL_PREFIX + "/api/foos/ccc");
            final ApiError error = response.as(ApiError.class);
            assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
            assertEquals(1, error.getErrors().size());
            assertTrue(error.getErrors().get(0).contains("should be of type"));
        }

        @Test
        public void whenNoHandlerForHttpRequest_thenNotFound() {
            final Response response = givenAuth().delete(URL_PREFIX + "/api/xx");
            final ApiError error = response.as(ApiError.class);
            assertEquals(HttpStatus.NOT_FOUND, error.getStatus());
            assertEquals(1, error.getErrors().size());
            assertTrue(error.getErrors().get(0).contains("No handler found"));
            System.out.println(response.asString());

        }

        @Test
        public void whenHttpRequestMethodNotSupported_thenMethodNotAllowed() {
            final Response response = givenAuth().delete(URL_PREFIX + "/api/foos/1");
            final ApiError error = response.as(ApiError.class);
            assertEquals(HttpStatus.METHOD_NOT_ALLOWED, error.getStatus());
            assertEquals(1, error.getErrors().size());
            assertTrue(error.getErrors().get(0).contains("Supported methods are"));
            System.out.println(response.asString());

        }

        @Test
        public void whenSendInvalidHttpMediaType_thenUnsupportedMediaType() {
            final Response response = givenAuth().body("").post(URL_PREFIX + "/api/foos");
            final ApiError error = response.as(ApiError.class);
            assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, error.getStatus());
            assertEquals(1, error.getErrors().size());
            assertTrue(error.getErrors().get(0).contains("media type is not supported"));
            System.out.println(response.asString());

        }

        @org.springframework.context.annotation.Configuration
        public static class ContextConfiguration {
        }



    /*



        @Test
        public void updateRacun() throws Exception {
            String uri = "/racun";
            RacunEntity racun = new  RacunEntity();

            racun.setCost(250);
            String inputJson = super.mapToJson(racun);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Racun is updated successsfully");
        }
*/
        @Test
        public void deleteRacun() throws Exception {
            String uri = "/racun/1";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Racun is deleted successsfully");
        }
    //}
}
