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
public class EmployeeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public  void should_return_except_list_when_get_all_employees() throws Exception {
        mockMvc.perform(
                get("/employees")
                       .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"xiaoming\",\n" +
                        "        \"age\": 22,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5000\n" +
                        "    },\n" +
                        "    {\n" +
                        "        \"id\": 2,\n" +
                        "        \"name\": \"xiaohong\",\n" +
                        "        \"age\": 24,\n" +
                        "        \"gender\": \"female\",\n" +
                        "        \"salary\": 6000\n" +
                        "    }\n" +
                        "]"));
    }
    @Test
    public  void should_return_except_list_when_give_salary_male() throws Exception {
        mockMvc.perform(
                get("/employees").param("salary","male")
                        .contentType(MediaType.APPLICATION_JSON_UTF8))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\n" +
                        "    {\n" +
                        "        \"id\": 1,\n" +
                        "        \"name\": \"xiaoming\",\n" +
                        "        \"age\": 22,\n" +
                        "        \"gender\": \"male\",\n" +
                        "        \"salary\": 5000\n" +
                        "    }\n" +
                        "]"));
    }
}