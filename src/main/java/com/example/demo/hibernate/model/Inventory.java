package com.example.demo.hibernate.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Inventory {
    @Id
    @Column(name = "inventory_id", nullable = false)
    private Integer inventoryId;
    @Basic
    @Column(name = "store_id", nullable = false)
    private Short storeId;
    @ManyToOne
    @JoinColumn(name = "film_id", referencedColumnName = "film_id", nullable = false)
    private Film filmByFilmId;
    @OneToMany(mappedBy = "inventoryByInventoryId")
    private Collection<Rental> rentalsByInventoryId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Inventory inventory = (Inventory) o;
        return Objects.equals(inventoryId, inventory.inventoryId) &&
                Objects.equals(storeId, inventory.storeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(inventoryId, storeId);
    }

}
