package com.example.hotel.ena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.repository.KorisnikRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;



import java.util.List;

public class KorisnikControllerTest extends HotelEnaApplicationTests {
    @Autowired
    private KorisnikRepository korisnikRepozitorij;
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getKorisniksList() throws Exception {
        String uri = "/korisnik/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        KorisnikEntity[]  racunlist = super.mapFromJson(content, KorisnikEntity[].class);
        assertTrue(racunlist.length > 0);
    }
    @Test
    public void createKorisnik() throws Exception {
        String uri = "/korisnik";
        Korisnik korisnik = new Korisnik();
       korisnik.setName("Amina");
       korisnik.setPassword("something");
       korisnik.setSurname("Fajic");
       korisnik.setUsername("aminaanaan1");
        String inputJson = super.mapToJson(korisnik);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Successfully created!");
    }
    @Test
    public void createKorisnikError() throws Exception {
        String uri = "/korisnik";
        Korisnik korisnik = new Korisnik();
        korisnik.setName("Amina");
        korisnik.setPassword("something");
        korisnik.setSurname("Fajic");
        korisnik.setUsername("");

        String inputJson = super.mapToJson(korisnik);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Username required");
    }
       /* @Test
        public void updateKorisnik() throws Exception {
            String uri = "/korisnik/2";
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
       /*/ @Test
        public void deleteKorisnik() throws Exception {
            String uri = "/korisnik/1";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Korisnik is deleted successfully");
        }
    //}
}
