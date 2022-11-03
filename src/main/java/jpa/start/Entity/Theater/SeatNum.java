package jpa.start.Entity.Theater;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
public class SeatNum {
    @Column(name = "SEAT_ROW")
    private int row;
    @Column(name = "SEAT_COL")
    private int col;
}
