package com.example.KR_sem4.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    public String name;
    public String password;
}
