package jpa.start.Entity.Screen;

import jpa.start.Entity.Movie.Movie;
import jpa.start.Entity.Reservation.Reservation;
import jpa.start.Entity.Theater.Theater;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Screen{
    @Id
    @Column(name = "SCREEN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @OneToOne(mappedBy = "screen", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Reservation reservation;
    @Embedded
    private RunningTime runningTime;
}
