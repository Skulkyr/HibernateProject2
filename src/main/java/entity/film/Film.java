package entity.film;

import entity.location.Language;
import entity.persons.Actor;
import jakarta.persistence.*;
import mapper.RattingMapper;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class Film {

    @Column(name = "film_id")
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(columnDefinition = "text")
    //@Type(type = "org.hibernate.type.StringType")
    private String description;

    @Column(name = "release_year")
    private LocalDateTime releaseYear;

    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;

    @ManyToOne
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    @Column(name = "rental_duration")
    private Short rentalDuration;

    @Column(name = "rental_rate", columnDefinition = "decimal(4,2)")
    private BigDecimal rentalRate;

    private Short length;

    @Column(name = "replacement_cost", columnDefinition = "decimal(5,2)")
    private BigDecimal replacementCost;

    @Column(columnDefinition = "ENUM('G', 'PG', 'PG-13', 'R', 'NC-17')")
    @Convert(converter = RattingMapper.class)
    private Rating rating;

    @Column(name = "special_features", columnDefinition = "SET('Trailers', 'Commentaries', 'Deleted Scenes', 'Behind the Scenes')")
    private String features;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "actor_id"))
    private Set<Actor> actors;

    @ManyToMany
    @JoinTable(name = "film_category",
    joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "film_id"),
    inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "category_id"))
    private Set<Category> categories;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDateTime releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public Language getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(Language originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public Short getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(Short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Short getLength() {
        return length;
    }

    public void setLength(Short length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getFeatures() {
        return features;
    }

    public void setFeatures(String features) {
        this.features = features;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Actor> getActors() {
        return actors;
    }

    public void setActors(Set<Actor> actors) {
        this.actors = actors;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public Short getId() {
        return id;
    }

}
