package com.example.demo.model.response;

import com.example.demo.model.base.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DriverResSignUpModel extends BaseModel {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String password;

    public DriverResSignUpModel(Long id, String firstName, String lastName, String email, String phoneNumber, String password) {
        super(id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }
}
