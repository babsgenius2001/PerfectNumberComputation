package com.perfectnumber.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfectNumberServiceImpl implements PerfectNumberService {
    @Override
    public List<Integer> getPerfectNumbers(int startNumber, int endNumber) {
        List<Integer> perfectNumbers = new ArrayList<>();
        if (isValidNumber(startNumber) && isValidNumber(endNumber)) {
            for (int i = startNumber + 1; i < endNumber; i++) {
                if (checkIfPerfectNumber(i)) {
                    perfectNumbers.add(i);
                }
            }
            return perfectNumbers.isEmpty() ? new ArrayList<>() : perfectNumbers;
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public String validateIfNumberIsPerfect(int number) {
        String conclusion = "";

        if (isValidNumber(number)) {
            if (checkIfPerfectNumber(number)) {
                conclusion = number + " is a perfect number!";
            } else {
                conclusion = number + " is not a perfect number!";
            }
        } else {
            conclusion = number + " is not a valid number!";
        }
        return conclusion;
    }

    public static boolean checkIfPerfectNumber(int number) {
        boolean result;
        int sumOfNumbers = 0;
        for (int i = 1; i <= number / 2; i++) {
            if (number % i == 0) {
                sumOfNumbers += i;
            }
        }
        result = (sumOfNumbers == number);
        return result;
    }

    public static boolean isValidNumber(int number) {
        return (number > 0);
    }
}
