package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Country {
    @Id
    @Column(name = "country_id", nullable = false)
    private Integer countryId;
    @Basic
    public String getCountry() {
        return country;
    }
    private String country;
    @OneToMany(mappedBy = "countryByCountryId")
    private Collection<City> citiesByCountryId;

    public void setCountryId(Integer countryId) {
        this.countryId = countryId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Country country1 = (Country) o;
        return Objects.equals(countryId, country1.countryId) &&
                Objects.equals(country, country1.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, country);
    }

}
