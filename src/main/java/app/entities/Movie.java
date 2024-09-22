package app.entities;

import app.dtos.MovieDTO;
import app.mappers.Mapper;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
@Table(name = "movies")
public class Movie {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "origin_country")
    @ElementCollection
//    @CollectionTable( more info if needed name, join colun ect. )
    private List<String> originCountry;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    //    @ManyToMany(cascade = CascadeType.PERSIST)
    @ManyToMany
    @ToString.Exclude
    private List<Cast> casts;

    @ManyToMany
    private List<Genre> genres;

    public Movie(MovieDTO movieDTO) {
        this.id = movieDTO.getId();
        this.originCountry = movieDTO.getOriginCountry();
        this.title = movieDTO.getTitle();
        this.releaseDate = movieDTO.getReleaseDate();
        this.casts = movieDTO.getCredits().getCast().stream()
                .map(Mapper::castDTO2Entity)
                .collect(Collectors.toList());
        this.genres = movieDTO.getGenresList().stream()
                .map(Mapper::genresToEntity)
                .collect(Collectors.toList());
    }

    public Movie(Movie movie) {
        this.id = movie.id;
        this.originCountry = movie.originCountry;
        this.title = movie.title;
        this.releaseDate = movie.releaseDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return Objects.equals(id, movie.id) && Objects.equals(originCountry, movie.originCountry) && Objects.equals(title, movie.title) && Objects.equals(releaseDate, movie.releaseDate) && Objects.equals(casts, movie.casts) && Objects.equals(genres, movie.genres);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originCountry, title, releaseDate, casts, genres);
    }

    public Movie(Integer id, List<String> originCountry, String title, String releaseDate, List<Genre> genres) {
        this.id = id;
        this.originCountry = originCountry;
        this.title = title;
        this.releaseDate = releaseDate;
        this.genres = genres;
    }
}// end class
