package org.deviget.qa.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Photo implements Serializable {
    @JsonProperty("id")
    public int id;
    @JsonProperty("sol")
    public int sol;
    @JsonProperty("camera")
    public Camera camera;
    @JsonProperty("img_src")
    public String img_src;
    @JsonProperty("earth_date")
    public String earth_date;
    @JsonProperty("rover")
    public Rover rover;
}
