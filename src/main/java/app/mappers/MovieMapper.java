package app.mappers;

import app.dtos.MovieDTO;
import app.entities.Movie;

import java.util.Arrays;
import java.util.List;

public class MovieMapper {


    public static Movie fromDTOtoEntity(MovieDTO movieDTO) {
        Movie movie = new Movie();

        return new Movie(
                movieDTO.getOriginCountry(),
                movieDTO.getReleaseDate(),
                movieDTO.getTitle());

    }

}// end class
