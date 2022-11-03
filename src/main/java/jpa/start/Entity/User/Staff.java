package jpa.start.Entity.User;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@Entity
@DiscriminatorValue("Staff")
public class Staff extends Person {
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date startedWorkDate;
}
