package com.milkiyti.property_management.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "properties")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String title;
    private String description;
    private Double price;
    private String address;
    @ManyToOne//(fetch = FetchType.LAZY) //ignore the user data while fetching the property entity
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity userEntity;
}
