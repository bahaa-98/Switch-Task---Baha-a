package com.example.demo.domain;

import com.example.demo.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
@Setter
@Getter
public class Manufacturer extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Column(unique = true)
    @NotBlank(message = "Not.Blank.Name")
    private String name;

    public Manufacturer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Manufacturer() {
    }
}
