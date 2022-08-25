package com.example.myshop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.util.MimeTypeUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyShopTestIntegration {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getListArticle() throws Exception {
        ResultActions result = mockMvc.perform(
                        get("/article")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
        result.andExpect(status().isOk());
    }

    @Test
    public void getArticle() throws Exception {
        mockMvc.perform(
                        get("/article/1")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    public void getArticle2() throws Exception {
        ResultActions result = mockMvc.perform(
                        get("/article/2")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE));
        result.andExpect(status().isOk());
        result.andExpect(jsonPath("$[?(@.nombre === 'Sound System')]").exists());
    }

    @Test
    public void getNotFound() throws Exception {
        mockMvc.perform(
                        get("/article/3")
                                .accept(MimeTypeUtils.APPLICATION_JSON_VALUE))
                .andExpect(status().isNotFound())
                .andReturn();
    }

}
