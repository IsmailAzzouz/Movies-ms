package org.com.ex.controller;

import org.com.ex.model.MovieDetails;
import org.com.ex.service.MovieServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MovieController {

    @Autowired
    MovieServiceImpl movieService;

    /**
     * Retrieves a paginated list of movies.
     * @param page current page (0-indexed)
     * @param size number of movies per page
     * @return Page containing movies and total pages
     */
    @GetMapping("/movies")
    public ResponseEntity<Page<MovieDetails>> getMovies(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        if (page < 0 || size <= 0) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "page must be >= 0 and size must be > 0"
            );
        }
        return new ResponseEntity<>(movieService.getMoviesPaginated(page, size), HttpStatus.OK);
    }

    @GetMapping("/movies/all")
    public ResponseEntity<List<MovieDetails>> getAllMovies(){
        List<MovieDetails> movieDetailsList = movieService.getMoviesList();
        return  new ResponseEntity<>(movieDetailsList,HttpStatus.OK);
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDetails> addMovies(@RequestBody MovieDetails movieDetails){
        movieService.addMovies(movieDetails);
        return  new ResponseEntity<>(movieDetails,HttpStatus.CREATED);
    }
}
