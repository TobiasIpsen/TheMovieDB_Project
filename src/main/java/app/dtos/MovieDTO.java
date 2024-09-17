package app.dtos;

import app.entities.Actor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class MovieDTO {


    @JsonProperty("original_title")
    private String title;

    private String release_date;

//    List<Genres> genresList;

    private String[] origin_country;

//    private Credits credits;


//    public class Credits {
//        private List<Actor> cast;
//    }


//    public class Genres {
//        private String name;
//    }

}
