package jpa.start.Entity.Performer;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue(value = "Actor")
public class Actor extends Performer {
    private int height;

    private String company;
}
