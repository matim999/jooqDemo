package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Rental {
    @Id
    @Column(name = "rental_id", nullable = false)
    private Integer rentalId;
    @Basic
    @Column(name = "rental_date", nullable = false)
    private Timestamp rentalDate;
    @Basic
    @Column(name = "return_date", nullable = true)
    private Timestamp returnDate;
    @OneToMany(mappedBy = "rentalByRentalId")
    private Collection<Payment> paymentsByRentalId;
    @ManyToOne
    @JoinColumn(name = "inventory_id", referencedColumnName = "inventory_id", nullable = false)
    private Inventory inventoryByInventoryId;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffByStaffId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(rentalId, rental.rentalId) &&
                Objects.equals(rentalDate, rental.rentalDate) &&
                Objects.equals(returnDate, rental.returnDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rentalId, rentalDate, returnDate);
    }
}
