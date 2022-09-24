package com.perfectnumber;

import com.perfectnumber.service.PerfectNumberService;
import com.perfectnumber.service.PerfectNumberServiceImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class GetPerfectNumbersTest {

    private PerfectNumberService perfectNumberService;

    @Before
    public void setUp() {
        perfectNumberService = new PerfectNumberServiceImpl();
    }

    @Test
    public void shouldReturnListOfPerfectNumbersInRange() {
        int firstNumber = 1;
        int secondNumber = 100;
        List<Integer> expectedResult = Arrays.asList(6, 28);

        assertNotNull(perfectNumberService.getPerfectNumbers(firstNumber, secondNumber));
        assertEquals(expectedResult, perfectNumberService.getPerfectNumbers(firstNumber, secondNumber));
    }

    @Test
    public void shouldReturnEmptyListIfNoPerfectNumberIsAvailableInRange() {
        int firstNumber = 100;
        int secondNumber = 400;

        assertEquals(new ArrayList<>(), perfectNumberService.getPerfectNumbers(firstNumber, secondNumber));
    }

    @Test
    public void shouldReturnEmptyListIfEitherInputNumberIsNotAValidNumber() {
        assertEquals(new ArrayList<>(), perfectNumberService.getPerfectNumbers(-1, 100));
    }

    @Test
    public void shouldTestForErrorIfEitherInputIsNotANumber() {
        String number = "gdgdgdgdg";
        assertThrows(NumberFormatException.class, () -> perfectNumberService.getPerfectNumbers(Integer.parseInt(number), Integer.parseInt(number)));
    }
}
