package app.entities;

import app.dtos.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "genres")
public class Genre {

    @Id
    @Column(name = "name", nullable = false, unique = true)
    private String name;

    public Genre(MovieDTO.GenresDTO genresDTO) {
        this.name = genresDTO.getName();
    }
}
