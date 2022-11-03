package jpa.start.Entity.Common;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class Log {

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(value = TemporalType.TIMESTAMP)
    private Date lastModifiedDate;
}
