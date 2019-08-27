/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reference.comparator;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import reference.domain.Film;
import reference.domain.Rating;

/**
 *
 * @author teruaki
 */
public class FilmComparator implements Comparator<Film>{
    private Map<Film, List<Rating>> ratings;

    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.ratings = ratings;
    }
    
    

    @Override
    public int compare(Film o1, Film o2) {
        if(average(ratings.get(o2)) < average(ratings.get(o1))){
            return -1;
        }else if(average(ratings.get(o2)) > average(ratings.get(o1))){
            return 1;
        }
        return 0;
    }
    
    public float average(List<Rating> ratingList){
        int total = 0;
        for(Rating rating: ratingList){
            total += rating.getValue();
        }
        
        return total/ratingList.size();
    }
}
