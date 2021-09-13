package com.example.demo.domain;

import com.example.demo.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
public class Car extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @NotBlank(message = "Not.Blank.Name")
    @Column(unique = true)
    private String licensePlate;

    @NotBlank(message = "Not.Blank.Name")
    private int seatCount;

    private Boolean convertible;

    private int rating;

    private EngineType engineType;


    @ManyToOne(fetch = FetchType.LAZY)
    private Manufacturer manufacturer;

    @ManyToOne(fetch = FetchType.LAZY)
    private Driver driver;

}
