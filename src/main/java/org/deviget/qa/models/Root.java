package org.deviget.qa.models;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Generated
@AllArgsConstructor
@NoArgsConstructor
public class Root implements Serializable {
    public List<Photo> photos = new ArrayList<>();
}
