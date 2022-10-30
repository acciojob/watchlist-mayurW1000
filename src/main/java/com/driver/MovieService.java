package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void add_Movie(Movie movie){
        movieRepository.add_Movie(movie);
    }

    public Movie get_Movie(String name){
        return movieRepository.get_Movie(name);
    }

    public void add_Director(Director director){
        movieRepository.add_Director(director);
    }

    public Director get_Director(String name){
        return movieRepository.get_Director(name);
    }

    public List<Movie> get_all_movies(){
        return movieRepository.get_all_movies();
    }
    public void add_pair(String movie_name, String director_name){
        movieRepository.add_pair(movie_name,director_name);
    }

    public List<String> movies_name_from_director(String name){
        return movieRepository.movies_name_from_director(name);
    }

    public void delete_director(String name){
        movieRepository.delete_director(name);
    }

    public void delete_all(){
        movieRepository.delete_all();
    }
}
