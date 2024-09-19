package app.entities;

import app.dtos.CastDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "casts")
public class Cast {

    @Id
    @Column (name = "castID", nullable = false, unique = true)
    private int castID;

    @Column (name = "name")
    private String name;

    @Column (name = "know_for_department")
    private String department;

    @Column (name = "character")
    private String character;

    //owning side
    @ManyToMany(mappedBy = "casts")
    private List<Movie> movieList;

    public Cast(CastDTO castDTO) {
        this.castID = castDTO.getCastID();
        this.name = castDTO.getName();
        this.department = castDTO.getDepartment();
        this.character = castDTO.getCharacter();
    }

    public void addMovieToList(Movie movie) {
        movieList.add(movie);
    }
}
