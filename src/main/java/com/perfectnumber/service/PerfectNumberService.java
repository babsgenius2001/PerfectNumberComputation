package com.perfectnumber.service;

import java.util.List;

public interface PerfectNumberService {
    List<Integer> getPerfectNumbers(int startNumber, int endNumber);

    String validateIfNumberIsPerfect(int number);

}
