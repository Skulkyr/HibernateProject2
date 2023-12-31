package entity.payment;

import entity.persons.Staff;
import jakarta.persistence.*;

@Entity
public class Store {
    @Id
    @Column(name = "store_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte id;

    @Column
    private Staff staff;
}
