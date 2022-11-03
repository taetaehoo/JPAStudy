package jpa.start.Entity.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@DiscriminatorValue("Customer")
public class Customer extends Person{
    private Long mileage;
}
