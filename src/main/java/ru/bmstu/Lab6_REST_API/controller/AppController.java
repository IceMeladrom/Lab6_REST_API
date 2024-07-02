package ru.bmstu.Lab6_REST_API.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/")
public class AppController {
    @GetMapping("getStatus")
    public ResponseEntity<String> getStatus(){
        return new ResponseEntity<>("Server is up", HttpStatus.OK);
    }
}
