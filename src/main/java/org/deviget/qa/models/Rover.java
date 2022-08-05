package org.deviget.qa.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Rover implements Serializable {
    @JsonProperty("id")
    public int id;
    @JsonProperty("name")
    public String name;
    @JsonProperty("landing_date")
    public String landing_date;
    @JsonProperty("launch_date")
    public String launch_date;
    @JsonProperty("status")
    public String status;
}
