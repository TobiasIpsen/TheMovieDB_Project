package app.mappers;

import app.dtos.MovieDTO;
import app.entities.Movie;

public class MovieMapper {

    public Movie fromDTOtoEntity(MovieDTO movieDTO) {
        return new Movie(
                movieDTO.getOrigin_country(),
                movieDTO.getRelease_date(),
                movieDTO.getTitle());

    }

}// end class
