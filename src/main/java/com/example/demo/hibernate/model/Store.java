package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store {
    @Id
    @Column(name = "store_id", nullable = false)
    private Integer storeId;
    @Basic
    @Column(name = "manager_staff_id", nullable = false)
    private Short managerStaffId;
    @ManyToOne
    @JoinColumn(/*name = "manager_staff_id", */referencedColumnName = "staff_id", nullable = false)
    private Staff staffByManagerStaffId;
    @ManyToOne
    @JoinColumn(/*name = "address_id", */referencedColumnName = "address_id", nullable = false)
    private Address addressByAddressId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(storeId, store.storeId) &&
                Objects.equals(managerStaffId, store.managerStaffId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeId, managerStaffId);
    }

}
