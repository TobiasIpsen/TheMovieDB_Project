package app.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CastDTO {

    @JsonProperty("id")
    private int castID;

    @JsonProperty("name")
    private String name;

    @JsonProperty("known_for_department")
    private String department;

    @JsonProperty("character")
    private String character;

}
