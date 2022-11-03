package jpa.start.Entity.Screen;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Embeddable
@Getter
@Setter
public class RunningTime {
    @Temporal(value = TemporalType.TIME)
    private Date startTime;

    @Temporal(value = TemporalType.TIME)
    private Date endTime;
}
