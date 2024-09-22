package app.dtos;

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

    @JsonProperty("id")
    private int id;

    @JsonProperty("original_title")
    private String title;

    @JsonProperty("release_date")
    private String releaseDate;


    //    private String[] origin_country;
    // better with list than array when mapping. cuz of the flexibilty in List
    @JsonProperty("origin_country")
    private List<String> originCountry;

    @JsonProperty("genres")
    private List<GenresDTO> genresList;

    @JsonProperty("credits")
    private Credits credits;

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Setter
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class Credits {

        @JsonProperty("cast")
        private List<CastDTO> cast;


//        @JsonProperty("crew")
//        private List<CrewDTO> crew;
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    @Setter
    @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class GenresDTO {
        private String name;
    }

}
