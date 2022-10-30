package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie movie){
        movieService.add_Movie(movie);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director director){
        movieService.add_Director(director);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam String movie_name,
                                                       @RequestParam String director_name){
        movieService.add_pair(movie_name,director_name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String name){
        if(movieService.get_Movie(name)!=null){
        return new ResponseEntity<>(movieService.get_Movie(name),HttpStatus.OK);}
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable String name){
        if(movieService.get_Director(name)!=null){
        return new ResponseEntity<>(movieService.get_Director(name),HttpStatus.OK);}
        else{
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable String director){
        return new ResponseEntity<>(movieService.movies_name_from_director(director),HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        return new ResponseEntity<>(movieService.get_all_movies(),HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam String name){
        movieService.delete_director(name);
        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String>deleteAllDirectors(){
        movieService.delete_all();
        return new ResponseEntity<>("success",HttpStatus.OK);
    }
}
