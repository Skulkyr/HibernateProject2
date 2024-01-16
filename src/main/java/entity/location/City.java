package entity.location;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.UpdateTimestamp;



import java.time.LocalDateTime;

@Entity
public class City {
    @Id
    @Column(name = "city_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Short id;
    @Column(length = 50, nullable = false)
    private String city;
    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "last_update", nullable = false)
    @UpdateTimestamp
    private LocalDateTime lastUpdate;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("city", city)
                .append("country", country)
                .append("lastUpdate", lastUpdate)
                .toString();
    }

    public City() {
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
