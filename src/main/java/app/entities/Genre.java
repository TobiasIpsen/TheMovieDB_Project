package app.entities;

import app.dtos.MovieDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Genre genre = (Genre) o;
        return Objects.equals(name, genre.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }
}
