package jpa.start.Entity.Theater;

import jpa.start.Entity.Reservation.Reservation;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @Column(name = "SEAT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private SeatNum seatNum;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @Enumerated(value = EnumType.STRING)
    private SeatStatus status;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservation;
    public void setTheater(Theater theater) {
        this.theater = theater;
        if(!theater.getSeats().contains(this))
            theater.getSeats().add(this);
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
        if(!reservation.getSeats().contains(this))
            reservation.getSeats().add(this);
    }
}
