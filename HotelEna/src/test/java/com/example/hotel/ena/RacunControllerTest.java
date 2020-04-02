package com.example.hotel.ena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.exception.ApiError;
import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import com.sun.research.ws.wadl.Response;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


import java.io.File;
import java.util.List;
import io.restassured.RestAssured;

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
            racun.setCreated("2020-03-02");
            racun.setCreatedBy("nejra");
            racun.setPaid(true);
            racun.setUserId("5");
            racun.setReservationId("4");
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
        racun.setCreated("2020-03-02");
        racun.setCreatedBy("nejra");
        racun.setPaid(true);
        racun.setUserId("5");
        racun.setReservationId("4");
        String inputJson = super.mapToJson(racun);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Iznos is not valid!");
    }


         @Test
         public void whenMethodArgumentMismatch_thenBadRequest() {
       /*Response response = givenAuth().get(URL_PREFIX + "/api/foos/ccc");
        ApiError error = response.as(ApiError.class);

        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("should be of type"));

        final Response response = RestAssured.given().get("http://localhost:8181/primes/abc");
        final ApiError error = response.as(ApiError.class);
        assertEquals(HttpStatus.BAD_REQUEST, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("should be of type"));*/
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

    @Test
    
    public void whenSendInvalidHttpMediaType_thenUnsupportedMediaType() {
        Response response = givenAuth().body("").post(URL_PREFIX + "/api/foos");
        ApiError error = response.as(ApiError.class);

        assertEquals(HttpStatus.UNSUPPORTED_MEDIA_TYPE, error.getStatus());
        assertEquals(1, error.getErrors().size());
        assertTrue(error.getErrors().get(0).contains("media type is not supported"));
    }

    private ResponseEntity.BodyBuilder givenAuth() {
        return RestAssured.given()
                .auth().preemptive()
                .basic("user", "userPass")
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

        @Test
        public void deleteRacun() throws Exception {
            String uri = "/racun";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Racun is deleted successsfully");
        }*/
    //}
}
