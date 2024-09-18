package app.mappers;

import app.dtos.MovieDTO;
import app.entities.Movie;

public class MovieMapper {


    public static Movie fromDTOtoEntity(MovieDTO movieDTO) {
        return new Movie(movieDTO);

    }

}// end class
