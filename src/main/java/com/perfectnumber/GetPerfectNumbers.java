package com.perfectnumber;

import com.perfectnumber.service.PerfectNumberService;
import com.perfectnumber.service.PerfectNumberServiceImpl;

import java.util.Scanner;


public class GetPerfectNumbers {
    private static int startingNumber;
    private static int endingNumber;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        startingNumber = scan.nextInt();
        endingNumber = scan.nextInt();

        PerfectNumberService perfectNumberService = new PerfectNumberServiceImpl();
        System.out.println(perfectNumberService.getPerfectNumbers(startingNumber, endingNumber));
        scan.close();
    }
}
