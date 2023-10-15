package com.example.datajpa.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Table(name = "order_table")
@Entity(name = "Order")
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_sequence",
            sequenceName = "order_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_sequence"
    )
    @Column
    private Long id;

    @Column(nullable = false)
    private int totalPrice;

    @OneToOne
    @JoinColumn(
            name = "customer_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "customer_id_fk"
            )
    )
    private Customer customer;
}
