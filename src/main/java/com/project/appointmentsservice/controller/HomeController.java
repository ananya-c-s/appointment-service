package com.project.appointmentsservice.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
@RestController
@RequestMapping("")
@CrossOrigin(origins = "*")
@Slf4j
@Validated
public class HomeController {


    @PostMapping
    public ResponseEntity<?> blueee() {
      return new ResponseEntity<>("Login Successful", HttpStatus.OK);
    }
}




