package com.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfectNumberApiService {
    private PerfectNumberService  perfectNumberService = new PerfectNumberServiceImpl();

    public String isPerfectNumber(int providedNumber) {
        return perfectNumberService.validateIfNumberIsPerfect(providedNumber);
    }

    public List<Integer> fetchPerfectNumbersInRange(int startNumber, int endNumber) {
        return perfectNumberService.getPerfectNumbers(startNumber, endNumber);
    }
}
