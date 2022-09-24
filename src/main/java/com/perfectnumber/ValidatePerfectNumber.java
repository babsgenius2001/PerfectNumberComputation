package com.perfectnumber;

import com.perfectnumber.service.PerfectNumberService;
import com.perfectnumber.service.PerfectNumberServiceImpl;

import java.util.Scanner;

public class ValidatePerfectNumber {
    private static int providedNumber;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        providedNumber = scanner.nextInt();

        PerfectNumberService perfectNumberService = new PerfectNumberServiceImpl();
        System.out.println(perfectNumberService.validateIfNumberIsPerfect(providedNumber));
        scanner.close();
    }
}
