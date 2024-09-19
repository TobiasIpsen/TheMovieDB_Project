package app.mappers;

import app.dtos.CastDTO;
import app.dtos.MovieDTO;
import app.entities.Cast;
import app.entities.Movie;

public class Mapper {


    public static Movie fromDTOtoEntity(MovieDTO movieDTO) {
        return new Movie(movieDTO);
    }

    public static Cast castDTO2Entity(CastDTO castDTO){
        return new Cast(castDTO);
    }

}// end class
