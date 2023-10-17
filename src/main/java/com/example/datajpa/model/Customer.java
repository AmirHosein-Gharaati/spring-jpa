package com.example.datajpa.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "Customer")
@Table(name = "customer")
@Getter
@NoArgsConstructor
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_sequence",
            sequenceName = "customer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String email;

    private String address;

    @OneToMany(
            orphanRemoval = true,
            mappedBy = "customer",
            cascade = {CascadeType.PERSIST, CascadeType.REMOVE}
    )
    private List<Order> orders;
}
