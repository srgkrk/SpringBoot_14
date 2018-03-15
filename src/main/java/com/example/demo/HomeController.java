package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    DirectorRepository directorRepository;

    @RequestMapping("/")
    public String index(Model model) {
        Director director = new Director();
        director.setName("Stephen Bollock");
        director.setGenre("Sci Fi");

        // creat movie
         Movie movie = new Movie();
         movie.setTitle("Star Movie");
         movie.setYear(2017);
         movie.setDescription("About Stars...");

        // Add the movie to an epty list
        Set<Movie> movies = new HashSet<Movie>();
        movies.add(movie);

        movie = new Movie();
        movie.setTitle("DeathStar Ewoke");
        movie.setYear(2011);
        movie.setDescription("About Evoke on the DethStar");
        movies.add(movie);

        //Add the list of movies
        director.setMovies(movies);

        //Save the Director to the database
        directorRepository.save(director);

        //Grab all the directors and send to the template
        model.addAttribute("directors", directorRepository.findAll());
        return "index";




    }
}
