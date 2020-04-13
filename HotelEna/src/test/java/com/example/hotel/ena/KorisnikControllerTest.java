package com.example.hotel.ena;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.example.hotel.ena.dto.Korisnik;
import com.example.hotel.ena.dto.Racun;
import com.example.hotel.ena.dto.Rezervacija;
import com.example.hotel.ena.exception.*;
import com.example.hotel.ena.models.KorisnikEntity;
import com.example.hotel.ena.repository.KorisnikRepository;
import com.google.gson.*;
import io.swagger.annotations.*;
import org.junit.*;
import org.junit.Test;
import org.junit.jupiter.api.*;
import org.junit.runners.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.mock.web.*;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.sql.*;
import java.time.*;
import java.time.format.*;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
        KorisnikEntity[] racunlist = super.mapFromJson(content, KorisnikEntity[].class);
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
        assertEquals(content, "User successfully created");
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
        assertEquals(400, status);
        String content = mvcResult.getResponse().getContentAsString();
       // LocalDateTime timestamp=LocalDateTime.now();
        //assertEquals(content, "{\"apierror\":{\"status\":\"BAD_REQUEST\",\"timestamp\":\""+timestamp.toString()+"\",\"message\":\"Validation error\",\"debugMessage\":null,\"subErrors\":[{\"object\":\"korisnikRequest\",\"field\":\"username\",\"rejectedValue\":\"\",\"message\":\"size must be between 5 and 30\"},{\"object\":\"korisnikRequest\",\"field\":\"username\",\"rejectedValue\":\"\",\"message\":\"Username is mandatory\"}]}}");
    }

    @Test

    public void updateKorisnik() throws Exception {
        String uri = "/korisnik";
        Korisnik korisnik = new Korisnik();
        KorisnikEntity korisnikEntity = korisnikRepozitorij.findAll().get(0);
        BeanUtils.copyProperties(korisnikEntity
                , korisnik);
        korisnik.setPassword("somethingnew");

        String inputJson = super.mapToJson(korisnik);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "Updated successfully");
    }

    @Test

    public void zdeleteKorisnik() throws Exception {
        String uri = "/korisnik/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        assertEquals(content, "User is deleted successfully");
    }
    @Test

    public void zdeleteKorisnikError() throws Exception {
        String uri = "/korisnik/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.delete(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(404, status);
        String content = mvcResult.getResponse().getContentAsString();
    }
    @Test

    public void zupdateKorisnikError() throws Exception {

            String uri = "/korisnik";
            Korisnik korisnik = new Korisnik();
            korisnik.setId(Long.valueOf(1));
            korisnik.setUsername("amina");
            korisnik.setName("Amina");
            korisnik.setSurname("Fajic");
            korisnik.setPassword("somethingnew");

            String inputJson = super.mapToJson(korisnik);
            MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .content(inputJson)).andReturn();
            int status = mvcResult.getResponse().getStatus();
            assertEquals(404, status);
            String content = mvcResult.getResponse().getContentAsString();
        }
    //testovi za feign cliente
    @Test

    public void findRacunByUserIdEmployee() throws Exception {
        String uri = "/korisnik/1/zaposlenik/racun";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getGuestsReservations() throws Exception {
        String uri = "/korisnik/rezervacija/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void getEmployeeReservations() throws Exception {
        String uri = "/korisnik/rezervacija/zaposlenik/1";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void pay() throws Exception {
        String uri = "/korisnik/zaposlenik/racun/pay";
        List<Long> ids = new ArrayList<Long>();
        ids.add(Long.valueOf(1));
        ids.add(Long.valueOf(2));

        String inputJson = super.mapToJson(ids);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.put(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }

    @Test
    public void findRacunByUserId() throws Exception {
        String uri = "/korisnik/1/racun";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }


}
