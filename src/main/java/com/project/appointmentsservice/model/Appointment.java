package com.project.appointmentsservice.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Appointment {
    private String id;
    private String patientId;
    private LocalDateTime appointmentTime;
    private String status; // SCHEDULED, CONFIRMED, CANCELLED
    private String appointmentType;
    private String notes;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Custom constructor for creating new appointments

    public Appointment(String id, String patientId, LocalDateTime appointmentTime,
                       String appointmentType) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentTime = appointmentTime;
        this.appointmentType = appointmentType;
    }


}