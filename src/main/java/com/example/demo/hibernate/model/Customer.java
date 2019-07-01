package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Customer {
    @Id
    @Column(name = "customer_id", nullable = false)
    private Integer customerId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private Short storeId;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "email", nullable = true, length = 50)
    private String email;
    @Basic
    @Column(name = "activebool", nullable = false)
    private Boolean activebool;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "active", nullable = true)
    private Integer active;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private Address addressByAddressId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Payment> paymentsByCustomerId;
    @OneToMany(mappedBy = "customerByCustomerId")
    private Collection<Rental> rentalsByCustomerId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(storeId, customer.storeId) &&
                Objects.equals(firstName, customer.firstName) &&
                Objects.equals(lastName, customer.lastName) &&
                Objects.equals(email, customer.email) &&
                Objects.equals(activebool, customer.activebool) &&
                Objects.equals(createDate, customer.createDate) &&
                Objects.equals(active, customer.active);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, storeId, firstName, lastName, email, activebool, createDate, active);
    }

}
