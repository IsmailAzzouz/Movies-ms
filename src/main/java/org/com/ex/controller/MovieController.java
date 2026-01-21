package org.com.ex.controller;

import org.com.ex.model.MovieDetails;
import org.com.ex.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDetails>> getAllMovies(){
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        movieDetailsList = movieService.getMoviesList();
        return  new ResponseEntity<>(movieDetailsList,HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDetails> addMovies(@RequestBody MovieDetails movieDetails){
        movieService.addMovies(movieDetails);
        return  new ResponseEntity<>(movieDetails,HttpStatus.CREATED);
    }
}
