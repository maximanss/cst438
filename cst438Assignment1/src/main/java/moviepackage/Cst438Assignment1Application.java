package moviepackage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * This is a web application that allow users to enter/display movie ratings
 * that are stored in a database with movie title, rating, user name, and
 * posting time.
 * 
 * @author Max Halbert
 * @since 2021-05-02
 */
@SpringBootApplication
public class Cst438Assignment1Application {

    public static void main(String[] args) {
        SpringApplication.run(Cst438Assignment1Application.class, args);
    }

}
