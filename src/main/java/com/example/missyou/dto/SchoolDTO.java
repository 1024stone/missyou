package com.example.missyou.dto;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;

@Data
public class SchoolDTO {
    @Length(min = 2)
    private String schoolName;
}
