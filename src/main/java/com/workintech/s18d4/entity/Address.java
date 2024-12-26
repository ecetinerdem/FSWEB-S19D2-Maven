package com.workintech.s18d4.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "address", schema = "fsweb")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "city")
    private String city;

    @Column(name = "street")
    private String street;

    @Column(name = "no")
    private Integer no;

    @Column(name = "country")
    private String country;

    @Column(name = "description")
    private String description;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH,CascadeType.PERSIST, CascadeType.REFRESH})
    private Customer customer;

}
