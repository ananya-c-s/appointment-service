package com.project.appointmentsservice.dto;

import lombok.Data;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDateTime;

@Data
public class CreateAppointmentRequest {

    @NotNull
    private String patientId;

    @NotNull
    private LocalDateTime appointmentTime;

    @NotNull
    @Pattern(regexp = "Initial|Follow-up", message = "Appointment type must be either 'Initial' or 'Follow-up'")
    private String appointmentType;

    @NotNull
    private String notes;
}
