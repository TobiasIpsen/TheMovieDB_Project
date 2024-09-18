package app.entities;

import app.dtos.ActorDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "movies")
public class Actor {

    @Id
    @Column (name = "actor_id", nullable = false, unique = true)
    private int actorID;

    @Column (name = "name")
    private String name;

    @Column (name = "know_for_department")
    private String department;

    @Column (name = "character")
    private String character;

    //owning side
    @ManyToMany
    private List<Movie> movieList;

    public Actor(ActorDTO actorDTO) {
        this.actorID = actorDTO.getActorID();
        this.name = actorDTO.getName();
        this.department = actorDTO.getDepartment();
        this.character = actorDTO.getCharacter();
    }
}
