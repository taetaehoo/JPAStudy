package jpa.start.Entity.Theater;

import jpa.start.Entity.Screen.Screen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Theater {
    @Id
    @Column(name = "THEATER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "THEATER_NAME")
    private String name;

    private int floor;

    @OneToOne(mappedBy = "theater", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Screen screen;
    @OneToMany(mappedBy = "theater", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    public void addSeat(Seat seat) {
        this.seats.add(seat);
        if(seat.getTheater() != this)
            seat.setTheater(this);
    }
}
