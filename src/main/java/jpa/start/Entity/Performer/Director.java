package jpa.start.Entity.Performer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Director")
public class Director extends Performer {
    private String birthPlace;


}
