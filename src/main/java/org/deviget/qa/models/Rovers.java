package org.deviget.qa.models;

import lombok.*;

import java.io.Serializable;
import java.util.List;
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Rovers implements Serializable {
    private List<Photo> rovers;
}
