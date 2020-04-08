package com.example.hotel.ena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.models.RezervacijaEntity;
import com.example.hotel.ena.repository.RezervacijaRepository;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.sql.Date;
import java.util.List;

public class RezervacijaControllerTest extends HotelEnaApplicationTests {
    @Autowired
    private RezervacijaRepository rezervacijaRepozitorij;
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }
    @Test
    public void getRezervacijasList() throws Exception {
        String uri = "/rezervacija/all";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        RezervacijaEntity[]  rezervacijalist = super.mapFromJson(content, RezervacijaEntity[].class);
        assertTrue(rezervacijalist.length > 0);
    }
    @Test
    public void createRezervacija() throws Exception {
        String uri = "/rezervacija";
        Rezervacija rezervacija = new Rezervacija();
       rezervacija.setUser_id(123L);
       rezervacija.setCreatedBy(345L);
       rezervacija.setCreated(new Date(System.currentTimeMillis()));
       rezervacija.setValidFrom((Date.valueOf("1-5-2020")));
        rezervacija.setValidTo((Date.valueOf("10-5-2020")));
        String inputJson = super.mapToJson(rezervacija);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Successfully created!");
    }
    @Test
    public void createRezervacijaError() throws Exception {
        String uri = "/rezervacija";
        Rezervacija rezervacija = new Rezervacija();
        rezervacija.setUser_id(123L);
        rezervacija.setCreatedBy(456L);
        rezervacija.setCreated(new Date(System.currentTimeMillis()));
        rezervacija.setValidFrom(Date.valueOf("11-5-2020"));
        rezervacija.setValidTo(Date.valueOf("15-5-2020"));

        String inputJson = super.mapToJson(rezervacija);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "User_id required");
    }
    @Test
        public void deleteRezervacija() throws Exception {
            String uri = "/rezervacija/1";
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertEquals(200, status);
            String content = mvcResult.getResponse().getContentAsString();
            assertEquals(content, "Rezervacija is deleted successfully");
        }
    //}
}
