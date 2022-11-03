package jpa.start.Entity.Performer;

import jpa.start.Entity.Movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MovieActor {
    @Id
    @Column(name = "MOVIEACTOR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "ACTOR_ID")
    private Actor actor;
    public void setMovie(Movie movie) {
        this.movie = movie;
        if(!movie.getMovieActors().contains(this))
            movie.getMovieActors().add(this);
    }
}
