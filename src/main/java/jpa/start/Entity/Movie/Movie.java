package jpa.start.Entity.Movie;

import jpa.start.Entity.Common.Log;
import jpa.start.Entity.Performer.Actor;
import jpa.start.Entity.Performer.Director;
import jpa.start.Entity.Performer.MovieActor;
import jpa.start.Entity.Performer.Performer;
import jpa.start.Entity.Screen.Screen;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Movie extends Log {
    @Id
    @Column(name = "MOVIE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "MOVIE_NAME")
    private String name;

    @OneToMany(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<MovieActor> movieActors = new ArrayList<>();
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "DIRECTOR_ID")
    private Director director;

    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    private int runningTime;

    @OneToOne(mappedBy = "movie", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Screen screen;
    public void setDirector(Performer director) {
        this.director = (Director)director;
        if(!director.getMovies().contains(this))
            director.getMovies().add(this);
    }

    public void addMovieActor(MovieActor movieActor) {
        this.movieActors.add(movieActor);
        if(movieActor.getMovie() != this)
            movieActor.setMovie(this);
    }
}
