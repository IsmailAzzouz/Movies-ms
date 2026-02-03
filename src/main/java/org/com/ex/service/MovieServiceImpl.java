package org.com.ex.service;

import org.com.ex.model.MovieDetails;
import org.com.ex.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MovieServiceImpl {

    @Autowired
    MovieRepository movieRepository;

    public List<MovieDetails> getMoviesList(){
        return movieRepository.findAll();
    }

    /**
     * Retrieves a paginated list of movies.
     */
    public Page<MovieDetails> getMoviesPaginated(int page, int size) {
        return movieRepository.findAll(PageRequest.of(page, size));
    }

    public MovieDetails addMovies(MovieDetails movieDetails){
        return movieRepository.save(movieDetails);
    }

}
