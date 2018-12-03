package com.endava.quote.generator.api;

import com.endava.quote.generator.model.QuoteServiceResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("prod")
public class QuoteControllerIT {


    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
                .build();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void shouldReturnQuote() throws Exception {
        String contentAsString = mockMvc.perform(get("/quote")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn().getResponse().getContentAsString();
        QuoteServiceResponse quoteServiceResponse = new ObjectMapper().readValue(contentAsString, QuoteServiceResponse.class);
        Assert.assertEquals("Springy", quoteServiceResponse.getAuthor());
    }
}