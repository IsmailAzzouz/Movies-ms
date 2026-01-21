package org.com.ex.service;

import org.com.ex.model.MovieDetails;
import org.com.ex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieDetails> getMoviesList(){
        List<MovieDetails> movieDetailsList = new ArrayList<>();
        movieRepository.findAll().forEach(movieDetailsList::add);
        return movieDetailsList;
    }

    public MovieDetails addMovies(MovieDetails movieDetails){
        movieRepository.save(movieDetails);
        return movieDetails;
    }

}
