package com.tw.apistackbase.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void should_return_except_list_when_get_company_1() throws Exception {
        mockMvc.perform(
                get("/companies/{id}","1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "    \"id\": 1,\n" +
                        "    \"companyName\": \"thoughtworks\",\n" +
                        "    \"employeeNumber\": 2,\n" +
                        "    \"employees\": [\n" +
                        "        {\n" +
                        "            \"id\": 1,\n" +
                        "            \"name\": \"小明\",\n" +
                        "            \"age\": 10,\n" +
                        "            \"gender\": \"male\",\n" +
                        "            \"salary\": 6000\n" +
                        "        },\n" +
                        "        {\n" +
                        "            \"id\": 2,\n" +
                        "            \"name\": \"小红\",\n" +
                        "            \"age\": 20,\n" +
                        "            \"gender\": \"female\",\n" +
                        "            \"salary\": 6000\n" +
                        "        }\n" +
                        "    ]\n" +
                        "}"));
    }

    @Test
    public  void should_return_except_list_when_litmit_page_and_pageSize() throws Exception {
        mockMvc.perform(
                get("/companies").param("page","1").param("pageSize","1")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"companyName\": \"thoughtworks\",\n" +
                        "        \"employeeNumber\": 2,\n" +
                        "        \"employees\": [\n" +
                        "            {\n" +
                        "                \"id\": 1,\n" +
                        "                \"name\": \"小明\",\n" +
                        "                \"age\": 10,\n" +
                        "                \"gender\": \"male\",\n" +
                        "                \"salary\": 6000\n" +
                        "            },\n" +
                        "            {\n" +
                        "                \"id\": 2,\n" +
                        "                \"name\": \"小红\",\n" +
                        "                \"age\": 20,\n" +
                        "                \"gender\": \"female\",\n" +
                        "                \"salary\": 6000\n" +
                        "            }\n" +
                        "        ]\n" +
                        "    }\n" +
                        "]"));
    }

}