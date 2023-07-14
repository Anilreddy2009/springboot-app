package com.aneel.crud.crud.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.aneel.crud.crud.service.ReviewService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ReviewController {
    
    @Autowired
    ReviewService rs;

    @PostMapping("review")
    public ResponseEntity<String> addReview(@RequestBody Map<String,String> payload){
        return new ResponseEntity<>(rs.addReview(payload.get("reviewBody"), payload.get("imdbId")), HttpStatus.CREATED);
    }
}
