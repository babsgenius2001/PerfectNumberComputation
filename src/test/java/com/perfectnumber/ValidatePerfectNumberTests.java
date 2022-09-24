package com.perfectnumber;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.perfectnumber.service.PerfectNumberServiceImpl;
import org.junit.Before;
import org.junit.Test;
import com.perfectnumber.service.PerfectNumberService;


public class ValidatePerfectNumberTests {

    private PerfectNumberService perfectNumberService;

    @Before
    public void setUp() throws Exception {
        perfectNumberService = new PerfectNumberServiceImpl();
    }

    @Test
    public void shouldTestIfNumberProvidedIsAPerfectNumber() {
        int number = 6;
        String expectedResult = number + " is a perfect number!";
        assertEquals(expectedResult, perfectNumberService.validateIfNumberIsPerfect(number));
    }

    @Test
    public void shouldTestIfNumberProvidedIsNotAPerfectNumber() {
        int number = 100;
        String expectedResult = number + " is not a perfect number!";
        assertEquals(expectedResult, perfectNumberService.validateIfNumberIsPerfect(number));
    }

    @Test
    public void shouldTestForInvalidNumberIfNumberProvidedIsLessThan1() {
        int number = -1;
        String expectedResult = number + " is not a valid number!";
        assertEquals(expectedResult, perfectNumberService.validateIfNumberIsPerfect(number));
    }

    @Test
    public void shouldTestForErrorIfInputIsNotANumber() {
        String number = "gdgdgdgdg";
       assertThrows(NumberFormatException.class, () ->  perfectNumberService.validateIfNumberIsPerfect(Integer.parseInt(number)));
    }

}

