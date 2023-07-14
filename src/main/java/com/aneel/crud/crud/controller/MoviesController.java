package com.aneel.crud.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aneel.crud.crud.model.Movies;
import com.aneel.crud.crud.service.MoviesService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("api/v1")
public class MoviesController {
    
    @Autowired
    MoviesService ms;

    @GetMapping("/movies")
    public ResponseEntity<List<Movies>> getMovies(){
        return ms.getMovies();
    }

    @GetMapping("/movie/{imdbId}")
    public ResponseEntity<Optional<Movies>> getMovie(@PathVariable String imdbId){
        return ms.getMovie(imdbId);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addMovie(@RequestBody Movies movie){
        return ms.addMovie(movie);
    }
}
