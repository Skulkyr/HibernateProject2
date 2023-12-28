package entity.location;

import jakarta.persistence.*;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class City {
    @Id
    @Column(name = "city_id")
    private Integer id;
    @Column(length = 50, nullable = false)
    private String city;
    @ManyToOne()
    @JoinColumn(name = "country_id")
    private Country country;

    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
