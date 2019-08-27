/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.List;
import java.util.*;
import reference.domain.Film;
import reference.domain.*;

/**
 *
 * @author teruaki
 */
public class RatingRegister {

    private Map<Film, List<Rating>> ratingList;
    private Map<Person, Map<Film, Rating>> personalRatings = new HashMap<Person, Map<Film, Rating>>();

    public RatingRegister() {
        ratingList = new HashMap<Film, List<Rating>>();
    }

    public void addRating(Film film, Rating rating) {
        if (!ratingList.containsKey(film)) {
            ratingList.put(film, new ArrayList<Rating>());
        }
        ratingList.get(film).add(rating);
    }

    public List<Rating> getRatings(Film film) {
        return ratingList.get(film);
    }

    public Map<Film, List<Rating>> filmRatings() {
        return ratingList;
    }

    public void addRating(Person person, Film film, Rating rating) {
        if (!personalRatings.containsKey(person)) {
            personalRatings.put(person, new HashMap<Film, Rating>());
        }
        if (!personalRatings.get(person).containsKey(film)) {

            personalRatings.get(person).put(film, rating);
        }

        this.addRating(film, rating);
    }

    public Rating getRating(Person person, Film film) {
        if (!personalRatings.containsKey(person)) {
            return Rating.NOT_WATCHED;
        }
        if (!personalRatings.get(person).containsKey(film)) {
            return Rating.NOT_WATCHED;
        }

        return personalRatings.get(person).get(film);
    }

    public Map<Film, Rating> getPersonalRatings(Person person) {
        if(!personalRatings.containsKey(person)){
            return new HashMap<Film,Rating>();
        }
        return personalRatings.get(person);
    }

    public List<Person> reviewers() {
        List<Person> reviewers = new ArrayList<Person>();
        
        for(Person person: personalRatings.keySet()){
            reviewers.add(person);
        }
        return reviewers;
    }
}
