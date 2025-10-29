package com.example.calculator.controller;

import com.example.calculator.model.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockitoBean
    private Calculator calculator;

    @Test
    void messageWelcome() throws Exception {
        RequestBuilder request = get("/calculator/welcome");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        Mockito.when(calculator.sum(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(5D);
        RequestBuilder request = get("/calculator/addNumbers")
                .param("number1", "2")
                .param("number2", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 5.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        Mockito.when(calculator.sub(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(1D);
        RequestBuilder request = get("/calculator/subNumbers")
                .param("number1", "3")
                .param("number2", "2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 1.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        Mockito.when(calculator.divide(Mockito.anyDouble(), Mockito.anyDouble())).thenReturn(2D);
        RequestBuilder request = get("/calculator/divideNumbers")
                .param("number1", "4")
                .param("number2", "2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 2.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        Mockito.when(calculator.factorial(Mockito.anyInt())).thenReturn(6);
        RequestBuilder request = get("/calculator/factorial")
                .param("factorial", "3");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 6", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        Mockito.when(calculator.calculeDayBetweenDate(Mockito.any(), Mockito.any())).thenReturn(2);
        RequestBuilder request = get("/calculator/calculeDayBetweenDate")
                .param("localDate1", "2025-10-27")
                .param("localDate2", "2025-10-29");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 2", result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        Mockito.when(calculator.integerToBinary(Mockito.anyInt())).thenReturn(10);
        RequestBuilder request = get("/calculator/integerToBinary")
                .param("number1", "2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 10", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        Mockito.when(calculator.integerToHexadecimal(Mockito.anyInt())).thenReturn("2");
        RequestBuilder request = get("/calculator/integerToHexadecimal")
                .param("number1", "2");
        MvcResult result = mvc.perform(request).andReturn();
        assertEquals("Resultado: 2", result.getResponse().getContentAsString());
    }
}
