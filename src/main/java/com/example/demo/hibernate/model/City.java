package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class City {
    @Id
    @GeneratedValue(generator = "actor_id_seq", strategy = GenerationType.SEQUENCE)
    @Column(name = "city_id", nullable = false)
    private Integer cityId;
    @Basic
    @Column(name = "city", nullable = false, length = 50)
    private String city;
    @OneToMany(mappedBy = "cityByCityId")
    private Collection<Address> addressesByCityId;
    @ManyToOne
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false)
    private Country countryByCountryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city1 = (City) o;
        return Objects.equals(cityId, city1.cityId) &&
                Objects.equals(city, city1.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityId, city);
    }
}
