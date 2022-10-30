package com.driver;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class MovieRepository {

    HashMap<String,Movie>storeMovie=new HashMap<>();
    HashMap<String,Director>storeDirector=new HashMap<>();
    HashMap<String,List<String>>storepair=new HashMap<>();

    public void add_Movie(Movie movie){
        storeMovie.put(movie.getName(), movie);
    }

    public Movie get_Movie(String name){
        return storeMovie.get(name);
    }

    public void add_Director(Director director){
        storeDirector.put(director.getName(), director);
    }

    public Director get_Director(String name){
        return storeDirector.get(name);
    }

    public void add_pair(String movie_name, String director_name){
        if(storeMovie.containsKey(movie_name) && storeDirector.containsKey(director_name)){
        if(!storepair.containsKey(director_name)){
            storepair.put(director_name,new ArrayList<String>());
            storepair.get(director_name).add(movie_name);
        }
        else {
            storepair.get(director_name).add(movie_name);
        }
    }
    }

    public List<Movie> get_all_movies(){
        List<Movie>list=new ArrayList<>();
        for(String name:storeMovie.keySet()){
            list.add(storeMovie.get(name));
        }
        return list;
    }

    public List<String> movies_name_from_director(String name){
        return storepair.get(name);
    }

    public void delete_director(String name){
        List<String>temp=storepair.get(name);
        storepair.remove(name);
        storeDirector.remove(name);
        if(temp!=null) {
            for (int i = 0; i < temp.size(); i++) {
                storeMovie.remove(temp.get(i));
            }
        }
    }

    public void delete_all(){
        if(!storeDirector.isEmpty()) {
            storeDirector = new HashMap<>();
        }
        if(!storepair.isEmpty()) {
            for (String name : storepair.keySet()) {
                if (storeMovie.containsKey(name)) {
                    List<String> temp = new ArrayList<>();
                    for (int i = 0; i < temp.size(); i++) {
                        storeMovie.remove(temp.get(i));
                    }
                }
            }
        }
        if(!storepair.isEmpty()) {
            storepair = new HashMap<>();
        }
    }
}