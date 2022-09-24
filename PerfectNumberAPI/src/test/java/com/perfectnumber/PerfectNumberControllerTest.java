package com.perfectnumber;


import com.perfectnumber.controller.PerfectNumberController;
import com.perfectnumber.service.PerfectNumberApiService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PerfectNumberController.class)
public class PerfectNumberControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PerfectNumberApiService perfectNumberApiService;

    @Test
    public void testCheckPerfectNumberWithAPerfectNumber() throws Exception {
        int testNumber = 28;
        String expectedResponse = testNumber + " is a perfect number!";

        when(perfectNumberApiService.isPerfectNumber(testNumber)).thenReturn(expectedResponse);
        this.mockMvc.perform(get("/api/checkPerfectNumber")
                        .queryParam("number", String.valueOf(testNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedResponse)));
    }

    @Test
    public void testCheckPerfectNumberWithAnImperfectNumber() throws Exception {
        int testNumber = 100;
        String expectedResponse = testNumber + " is not a perfect number!";

        when(perfectNumberApiService.isPerfectNumber(testNumber)).thenReturn(expectedResponse);
        this.mockMvc.perform(get("/api/checkPerfectNumber")
                        .queryParam("number", String.valueOf(testNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedResponse)));
    }

    @Test
    public void testCheckPerfectNumberWithANumberLessThanOne() throws Exception {
        int testNumber = -1;
        String expectedResponse = testNumber + " is not a valid number!";

        when(perfectNumberApiService.isPerfectNumber(testNumber)).thenReturn(expectedResponse);
        this.mockMvc.perform(get("/api/checkPerfectNumber")
                        .queryParam("number", String.valueOf(testNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString(expectedResponse)));
    }

    @Test
    public void testCheckPerfectNumberWithAStringValue() throws Exception {
        String testInput = "dsfsfddgdg";

        this.mockMvc.perform(get("/api/checkPerfectNumber")
                        .queryParam("number", testInput))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testCheckPerfectNumberWithAnEmptyOrNullValue() throws Exception {

        this.mockMvc.perform(get("/api/checkPerfectNumber")
                        .queryParam("number", ""))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testListPerfectNumbersBetweenARangeOfNumbersReturnsValues() throws Exception {
        int firstNumber = 1;
        int secondNumber = 100;
        List<Integer> expectedResponse = Arrays.asList(6, 28);

        when(perfectNumberApiService.fetchPerfectNumbersInRange(firstNumber, secondNumber)).thenReturn(expectedResponse);

        this.mockMvc.perform(get("/api/listPerfectNumbers")
                        .queryParam("startNumber", String.valueOf(firstNumber))
                        .queryParam("endNumber", String.valueOf(secondNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value((expectedResponse.size())))
                .andExpect(jsonPath("$.*").isNotEmpty())
                .andExpect(content().json(String.valueOf(expectedResponse)));
    }

    @Test
    public void testListPerfectNumbersIfNoPerfectNumberExistsBetweenARangeOfNumbers() throws Exception {
        int firstNumber = 100;
        int secondNumber = 400;

        when(perfectNumberApiService.fetchPerfectNumbersInRange(firstNumber, secondNumber)).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/api/listPerfectNumbers")
                        .queryParam("startNumber", String.valueOf(firstNumber))
                        .queryParam("endNumber", String.valueOf(secondNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0))
                .andExpect(jsonPath("$.*").isEmpty());
    }

    @Test
    public void testListPerfectNumbersIfAnyInputNumberIsInvalid() throws Exception {
        int firstNumber = -1;
        int secondNumber = 100;

        when(perfectNumberApiService.fetchPerfectNumbersInRange(firstNumber, secondNumber)).thenReturn(new ArrayList<>());

        this.mockMvc.perform(get("/api/listPerfectNumbers")
                        .queryParam("startNumber", String.valueOf(firstNumber))
                        .queryParam("endNumber", String.valueOf(secondNumber)))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(0))
                .andExpect(jsonPath("$.*").isEmpty());
    }

    @Test
    public void testListPerfectNumbersIfAnyInputNumberIsNotANumber() throws Exception {
        String firstNumber = "test";
        int secondNumber = 100;

        this.mockMvc.perform(get("/api/listPerfectNumbers")
                        .queryParam("startNumber", firstNumber)
                        .queryParam("endNumber", String.valueOf(secondNumber)))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }
}
