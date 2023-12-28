package entity.location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.hibernate.annotations.Type;

import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Country {

    @Column(name = "country_id")
    @Id
    private Integer id;
    @Column(length = 50, nullable = false)
    private String country;
    @Column(name = "last_update", nullable = false)
    private Timestamp lastUpdate;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("country", country)
                .append("lastUpdate", lastUpdate)
                .toString();
    }
}
