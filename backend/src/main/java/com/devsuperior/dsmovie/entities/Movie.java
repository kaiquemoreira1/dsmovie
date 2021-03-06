package com.devsuperior.dsmovie.entities;

import com.devsuperior.dsmovie.dto.MovieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String title;
    @Column
    private Double score;
    @Column
    private Integer count;
    @Column
    private String image;
    @OneToMany(mappedBy = "id.movie")
    private Set<Score> scores = new HashSet<Score>();

    public Movie(MovieDTO m) {
        this.id = m.getId();
        this.title = m.getTitle();
        this.score = m.getScore();
        this.count = m.getCount();
        this.image = m.getImage();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Movie movie = (Movie) o;
        return id != null && Objects.equals(id, movie.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
