package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Staff {
    @Id
    @Column(name = "staff_id", nullable = false)
    private Integer staffId;
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
    @Column(name = "store_id", nullable = false)
    private Short storeId;
    @Basic
    @Column(name = "active", nullable = false)
    private Boolean active;
    @Basic
    @Column(name = "username", nullable = false, length = 16)
    private String username;
    @Basic
    @Column(name = "password", nullable = true, length = 40)
    private String password;
    @Basic
    @Column(name = "picture", nullable = true)
    private byte[] picture;
    @OneToMany(mappedBy = "staffByStaffId")
    private Collection<Payment> paymentsByStaffId;
    @OneToMany(mappedBy = "staffByStaffId")
    private Collection<Rental> rentalsByStaffId;
    @ManyToOne
    @JoinColumn(name = "address_id", referencedColumnName = "address_id", nullable = false)
    private Address addressByAddressId;
    @OneToMany(mappedBy = "staffByManagerStaffId")
    private Collection<Store> storesByStaffId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Staff staff = (Staff) o;
        return Objects.equals(staffId, staff.staffId) &&
                Objects.equals(firstName, staff.firstName) &&
                Objects.equals(lastName, staff.lastName) &&
                Objects.equals(email, staff.email) &&
                Objects.equals(storeId, staff.storeId) &&
                Objects.equals(active, staff.active) &&
                Objects.equals(username, staff.username) &&
                Objects.equals(password, staff.password) &&
                Arrays.equals(picture, staff.picture);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(staffId, firstName, lastName, email, storeId, active, username, password);
        result = 31 * result + Arrays.hashCode(picture);
        return result;
    }

}
