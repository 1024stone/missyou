package com.example.missyou.dto;

import com.example.missyou.validators.PasswordEqual;
import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;

@Data
@PasswordEqual(min = 1,message = "hello")
public class PersonDTO {
    @Length(min = 2,max = 10,message = "name在2-10之间")
    private String name;
    private Integer age;

    private String password1;
    private String password2;

    @Valid
    private SchoolDTO schoolDTO;
}
