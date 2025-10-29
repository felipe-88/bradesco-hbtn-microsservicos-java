package com.example.calculator.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setup() {
        calculator = new Calculator();
    }

    @Test
    void sumTest() {
        Double sum = calculator.sum(2D, 3D);
        Assertions.assertEquals(5d, sum);
    }

    @Test
    public void numbersNullSumTest() {
        NullPointerException nullPointerException = Assertions.assertThrows(NullPointerException.class, () -> calculator.sum(null, 2D));
        Assertions.assertEquals("Número 1 e número 2 são obrigatórios.", nullPointerException.getMessage());
    }

    @Test
    void subTest() {
        Double sub = calculator.sub(3D, 2D);
        Assertions.assertEquals(1D, sub);
    }

    @Test
    void divideTest() {
        Double divide = calculator.divide(4D, 2D);
        Assertions.assertEquals(2D, divide);
    }

    @Test
    public void divisionByZeroTest() {
        ArithmeticException arithmeticException = Assertions.assertThrows(ArithmeticException.class, () -> calculator.divide(4D, 0D));
        Assertions.assertEquals("Divisão por zero não é permitido.", arithmeticException.getMessage());
    }

    @Test
    void factorialTest() {
        Integer factorial = calculator.factorial(3);
        Assertions.assertEquals(6, factorial);
    }

    @Test
    void integerToBinaryTest() {
        Integer i = calculator.integerToBinary(2);
        Assertions.assertEquals(10, i);
    }

    @Test
    void integerToHexadecimalTest() {
        String s = calculator.integerToHexadecimal(2);
        Assertions.assertEquals("2", s);
    }

    @Test
    void calculeDayBetweenDateTest() {
        int i = calculator.calculeDayBetweenDate(LocalDate.of(2025, 10, 27), LocalDate.now());
        Assertions.assertEquals(2, i);
    }
}
