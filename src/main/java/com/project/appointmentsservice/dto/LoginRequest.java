package com.project.appointmentsservice.dto;

import lombok.Data;

import java.time.LocalDateTime;


@Data
public class LoginRequest {
    private String email;
    private String password;

}