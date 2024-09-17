package app.entities;

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
    private List<String> originCountry;

    @Column(name = "title")
    private String title;

    @Column(name = "release_date")
    private String releaseDate;

    public Movie(List<String> originCountry, String title, String releaseDate) {
        this.originCountry = originCountry;
        this.title = title;
        this.releaseDate = releaseDate;
    }
}
