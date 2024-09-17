package app.mappers;

import app.dtos.MovieDTO;
import app.entities.Movie;

import java.util.Arrays;
import java.util.List;

public class MovieMapper {

    public Movie fromDTOtoEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();
        List<String> originCountryList = movie.getOriginCountry();
        return new Movie(
                originCountryList,
                movieDTO.getRelease_date(),
                movieDTO.getTitle());

    }

}// end class
