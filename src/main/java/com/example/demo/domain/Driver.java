package com.example.demo.domain;

import com.example.demo.domain.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Setter
@Getter
public class Driver extends BaseEntity {

    @NotBlank(message = "Not.Blank.Name")
    private String firstName;

    @NotBlank(message = "Not.Blank.Name")
    private String lastName;

    @NotBlank(message = "Not.Blank.Name")
    @Column(unique = true)
    private String email;

    @NotBlank(message = "Not.Blank.Name")
    @Column(unique = true)
    private String phoneNumber;

    @NotBlank(message = "Not.Blank.Name")
    @Pattern(regexp="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$")
    private String password;

    private Boolean status;

}
