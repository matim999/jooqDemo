package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Payment {
    @Id
    @Column(name = "payment_id", nullable = false)
    private Integer paymentId;
    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    private BigDecimal amount;
    @Basic
    @Column(name = "payment_date", nullable = false)
    private Timestamp paymentDate;
    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    private Customer customerByCustomerId;
    @ManyToOne
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = false)
    private Staff staffByStaffId;
    @ManyToOne
    @JoinColumn(name = "rental_id", referencedColumnName = "rental_id", nullable = false)
    private Rental rentalByRentalId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(paymentId, payment.paymentId) &&
                Objects.equals(amount, payment.amount) &&
                Objects.equals(paymentDate, payment.paymentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentId, amount, paymentDate);
    }

}
