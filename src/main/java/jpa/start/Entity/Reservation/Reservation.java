package jpa.start.Entity.Reservation;

import jpa.start.Entity.Screen.Screen;
import jpa.start.Entity.Theater.Seat;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Reservation {
    @Id
    @Column(name = "RESERVATION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen;

    @OneToMany(mappedBy = "reservation", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Seat> seats = new ArrayList<>();

    @Enumerated(value = EnumType.STRING)
    private ReservationStatus reservationStatus;

    public void addSeat(Seat seat) {
        this.seats.add(seat);
        if(seat.getReservation() != this)
            seat.setReservation(this);
    }
}
