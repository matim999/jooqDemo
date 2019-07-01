package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Address {
    @Id
    @Column(name = "address_id", nullable = false)
    private Integer addressId;
    @Basic
    @Column(name = "address", nullable = false, length = 50)
    private String address;
    @Basic
    @Column(name = "address2", nullable = true, length = 50)
    private String address2;
    @Basic
    @Column(name = "district", nullable = false, length = 20)
    private String district;
    @Basic
    @Column(name = "postal_code", nullable = true, length = 10)
    private String postalCode;
    @Basic
    @Column(name = "phone", nullable = false, length = 20)
    private String phone;
    @ManyToOne
    @JoinColumn(name = "city_id", referencedColumnName = "city_id", nullable = false)
    private City cityByCityId;
    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<Customer> customersByAddressId;
    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<Staff> staffByAddressId;
    @OneToMany(mappedBy = "addressByAddressId")
    private Collection<Store> storesByAddressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address1 = (Address) o;
        return Objects.equals(addressId, address1.addressId) &&
                Objects.equals(address, address1.address) &&
                Objects.equals(address2, address1.address2) &&
                Objects.equals(district, address1.district) &&
                Objects.equals(postalCode, address1.postalCode) &&
                Objects.equals(phone, address1.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addressId, address, address2, district, postalCode, phone);
    }
}
