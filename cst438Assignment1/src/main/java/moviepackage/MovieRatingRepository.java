package moviepackage;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * This is the interface for the movie repository in mySQL
 * 
 * @author Max Halbert
 * @since 2021-05-02
 */

public interface MovieRatingRepository extends CrudRepository<MovieRating, Long> {
    @Query("select m from MovieRating m order by title, date desc")
    List<MovieRating> findAllMovieRatingsOrderByTitleDateDesc();
}
