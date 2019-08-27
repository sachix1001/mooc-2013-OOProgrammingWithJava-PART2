/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import reference.comparator.FilmComparator;
import reference.comparator.PersonComparator;
import reference.domain.Film;
import reference.domain.Person;
import reference.domain.Rating;

/**
 *
 * @author teruaki
 */
public class Reference {

    private RatingRegister ratingRegister;
    private FilmComparator filmComparator;

    public Reference(RatingRegister ratingRegister) {
        this.ratingRegister = ratingRegister;
    }

    public Film recommendFilm(Person person1) {
        List<Film> films = films();

        if (!ratingRegister.reviewers().contains(person1)) {
            filmComparator = new FilmComparator(ratingRegister.filmRatings());
            Collections.sort(films, filmComparator);
            return films.get(0);
        }

        Person recommender = pickRecommender(person1);
        Film recommended = recommendedFilm(person1, recommender);

        return recommended;
    }

    /**
     * pick highest rating film Person hasn't watched
     *
     * @param person recommendation to this person
     * @param recomender from recommender
     * @return film
     */
    private Film recommendedFilm(Person person, Person recommender) {
        Film unwatchedFilm = null;
        Map<Film, Rating> recommenderList = ratingRegister.getPersonalRatings(recommender);

        for (Film film : ratingRegister.getPersonalRatings(recommender).keySet()) {
            if (!ratingRegister.getPersonalRatings(person).containsKey(film)) {
                if(unwatchedFilm == null ||
                        recommenderList.get(unwatchedFilm).getValue() <
                        recommenderList.get(film).getValue()){
                    unwatchedFilm = film;
                }
            }
        }
        return unwatchedFilm;
    }

    /**
     * @param person1
     * @return Person who has similar rating with parameter person
     */
    private Person pickRecommender(Person person1) {
        //list of persons except person1
        List<Person> recommenders = recommenders(person1);
        //map of person1's ratings
        Map<Film, Rating> person1Rating = ratingRegister.getPersonalRatings(person1);
        //map of other persons and preference similarity point
        Map<Person, Integer> points = new HashMap<Person, Integer>();
        //list of persons to be removed
        List<Person> toBeRemoved = new ArrayList<Person>();

        for (Person recomender : recommenders) {
            int point = 0;
            //map of recomender's ratings
            Map<Film, Rating> recomenderRating = ratingRegister.getPersonalRatings(recomender);

            //check if recomender watched the same film
            for (Film film : person1Rating.keySet()) {
                if (recomenderRating.containsKey(film)) {
                    point += person1Rating.get(film).getValue()
                            * recomenderRating.get(film).getValue();
                }
            }
            if (point == 0) {
                toBeRemoved.add(recomender);
            }
            points.put(recomender, point);
        }
        // remove persons who doesn't watch the same film as parameter person
        recommenders.removeAll(toBeRemoved);

        Person recomender = sortRecomenders(points);
        return recomender;
    }

    /**
     * sort
     *
     * @param map
     * @return
     */
    private Person sortRecomenders(Map<Person, Integer> map) {
        Person person = null;
        for (Person p : map.keySet()) {
            if (person == null || map.get(person) < map.get(p)) {
                person = p;
            }
        }
        return person;
    }

    /**
     * return a list of Person except parameter person
     *
     * @param person
     * @return a list of person except parameter person
     */
    public List<Person> recommenders(Person person) {
        List<Person> recomenders = new ArrayList<Person>();
        for (Person reviewer : ratingRegister.reviewers()) {
            if (!reviewer.equals(person)) {
                recomenders.add(reviewer);
            }
        }
        return recomenders;
    }

    private List<Film> films() {
        List<Film> filmList = new ArrayList<Film>();
        for (Film film : ratingRegister.filmRatings().keySet()) {
            filmList.add(film);
        }
        return filmList;
    }
}
