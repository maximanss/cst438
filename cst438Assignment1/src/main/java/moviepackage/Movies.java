package moviepackage;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * This is the controller that process user requests
 * 
 * @author Max Halbert
 * @since 2021-05-02
 */

@Controller
public class Movies {

    @Autowired
    MovieRatingRepository movieRepository;

    /**
     * Response to user request like URL localhost:8080/movies/new
     * 
     * @param model
     * @return a blank movie rating form for the user to enter movie ratings
     */
    @GetMapping("/movies/new")
    public String createMovieRating(Model model) {
        MovieRating movieRating = new MovieRating();
        model.addAttribute("movieRating", movieRating);
        return "movie_form";
    }

    /**
     * Process the movie rating entries from the movie form and stored them into
     * database if the entries are valid
     * 
     * @param movieRating
     * @param result
     * @param model
     * @return the stored movie rating that was entered if successfully saved into
     *         database or back to the movie rating form for any error in the input
     */
    @PostMapping("/movies/new")
    public String processMovieForm(@Valid MovieRating movieRating, BindingResult result,
            Model model) {
        if (result.hasErrors()) {
            return "movie_form";
        }
        movieRating.setDate(new java.util.Date());  // set the posting time with current time
        movieRepository.save(movieRating);
        return "movie_show";
    }

    /**
     * Display a list of all movies and their ratings ordered by title and posting
     * time, which is in descending order
     * 
     * @param model
     * @return the page with all the movie ratings in the database
     */
    @GetMapping("/movies")
    public String displayAllRatings(Model model) {
        Iterable<MovieRating> movieRatings = movieRepository
                .findAllMovieRatingsOrderByTitleDateDesc();
        model.addAttribute("movieRatings", movieRatings);
        return "movie_list";
    }

}
