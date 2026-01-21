package org.com.ex.repository;

import org.com.ex.model.MovieDetails;
import org.springframework.data.convert.ReadingConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieDetails,Long> {
}
