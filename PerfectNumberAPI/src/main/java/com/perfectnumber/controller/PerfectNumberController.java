package com.perfectnumber.controller;

import com.perfectnumber.model.RequestDAO;
import com.perfectnumber.service.PerfectNumberApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
public class PerfectNumberController {
    private final PerfectNumberApiService perfectNumberApiService;

    public PerfectNumberController(PerfectNumberApiService perfectNumberApiService) {
        this.perfectNumberApiService = perfectNumberApiService;
    }

    @GetMapping("/checkPerfectNumber")
    public ResponseEntity<String> checkIfPerfectNumber(@RequestParam int number) {
        try {
            return new ResponseEntity<>(perfectNumberApiService.isPerfectNumber(number), HttpStatus.OK);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/listPerfectNumbers")
    public ResponseEntity fetchAllPerfectNumbersInRange(@RequestParam int startNumber, @RequestParam int endNumber) {
        try {
            return new ResponseEntity<>(perfectNumberApiService.fetchPerfectNumbersInRange(startNumber, endNumber), HttpStatus.OK);
        } catch (Exception ex) {

            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
