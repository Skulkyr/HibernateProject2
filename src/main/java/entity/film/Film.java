package entity.film;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Film {

    @Column(name = "film_id")
    @Id()
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Column(nullable = false, length = 128)
    private String title;

    @Column(name = "release_year")
    private Date releaseYear;


}
