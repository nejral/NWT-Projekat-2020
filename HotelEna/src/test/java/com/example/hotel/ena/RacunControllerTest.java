package com.example.hotel.ena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.models.RacunEntity;
import com.example.hotel.ena.repository.RacunRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import java.util.List;

public class RacunControllerTest extends HotelEnaApplicationTests {
    @Autowired
    private RacunRepository racunRepozitorij;
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
       /* @Test
        public void updateProduct() throws Exception {
            String uri = "/products/2";
            Product product = new Product();
            product.setName("Lemon");
            String inputJson = super.mapToJson(product);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();

            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Product is updated successsfully");
        }
        @Test
        public void deleteProduct() throws Exception {
            String uri = "/products/2";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Product is deleted successsfully");
        }*/
    //}
}
