package jpa.start.Entity.Performer;

import jpa.start.Entity.Movie.Movie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PERFORMER_TYPE")
@Table(name = "Performer")
public abstract class Performer {
    @Id
    @Column(name = "PERFORMER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Temporal(value = TemporalType.DATE)
    private Date birth;

    @OneToMany(mappedBy = "director", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Movie> movies = new ArrayList<>();

    public void addMovie(Movie movie) {
        this.movies.add(movie);
        if(movie.getDirector() != this)
            movie.setDirector(this);
    }
}
