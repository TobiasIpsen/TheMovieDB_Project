package app.entities;

import app.dtos.MovieDTO;
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
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private long id;

    @Column(name = "origin_country")
    @ElementCollection
//    @CollectionTable( more info if needed name, join colun ect. )
    private List<String> originCountry;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;


    public Movie(MovieDTO movieDTO) {
        this.originCountry = movieDTO.getOriginCountry();
        this.title = movieDTO.getTitle();
        this.releaseDate = movieDTO.getReleaseDate();
    }
}
