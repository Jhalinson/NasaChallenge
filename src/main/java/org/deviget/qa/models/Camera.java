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
public class Camera implements Serializable {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("rover_id")
    public int rover_id;
    @JsonProperty("full_name")
    public String full_name;
}
