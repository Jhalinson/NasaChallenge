package org.deviget.qa.models;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Photos implements Serializable {
    private ArrayList<Photo> photos;
}
