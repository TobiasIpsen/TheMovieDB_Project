package app.dtos;

import app.entities.Actor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

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



//    private String[] origin_country;
    // better with list than array when mapping. cuz of the flexibilty in List
    private List<String> origin_country;


    //    List<Genres> genresList;
    //    private Credits credits;


//    public class Credits {
//        private List<Actor> cast;
//    }


//    public class Genres {
//        private String name;
//    }

}