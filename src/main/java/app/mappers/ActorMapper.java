package app.mappers;

import app.dtos.ActorDTO;
import app.entities.Actor;

public class ActorMapper {

    public static Actor actorDTOtoEntity(ActorDTO actorDTO) {
        return new Actor(actorDTO);
    }

}// end class
