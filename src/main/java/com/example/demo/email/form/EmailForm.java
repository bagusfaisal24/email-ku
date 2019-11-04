package com.example.demo.email.form;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties
public class EmailForm {
    private String emailFrom;
    private String target;
}
