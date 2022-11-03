package jpa.start.Entity.User;

import jpa.start.Entity.Common.Address;
import jpa.start.Entity.Common.Log;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "USER_TYPE")
@Table(name = "User")
public abstract class Person extends Log {
    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(value = TemporalType.DATE)
    private Date birth;

    @Embedded
    private Address address;
}
