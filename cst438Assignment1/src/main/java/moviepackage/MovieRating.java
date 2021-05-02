package moviepackage;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This is the Model Object Class defining the entity that will be stored in the
 * database
 * 
 * @author Max Halbert
 * @since 2021-05-02
 */
@Entity
public class MovieRating {

    @Id
    @GeneratedValue
    private long id;

    @NotNull
    @Min(1)
    @Max(5)
    private int rating;

    @NotNull
    @Size(min = 1, max = 60)
    private String title;

    @NotNull
    @Size(min = 1, max = 35)
    private String firstName;

    @NotNull
    @Size(min = 1, max = 35)
    private String lastName;

    private java.util.Date date;

    public MovieRating() {
        this.rating = 1;
    }

    public MovieRating(long id, int rating, String title, String firstName, String lastName,
            java.util.Date date) {
        super();
        this.id = id;
        this.rating = rating;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }

}
