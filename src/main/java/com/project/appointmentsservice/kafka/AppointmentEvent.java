package com.project.appointmentsservice.kafka;

import com.project.appointmentsservice.model.Appointment;
import lombok.*;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AppointmentEvent {
    private String appointmentId;
    private String eventType;
    private LocalDateTime appointmentTime;
    private String patientId;
    private String appointmentType;
    private String notes;
    private LocalDateTime eventTimestamp;

    public static AppointmentEvent created(Appointment appointment) {
        return new AppointmentEvent(
                appointment.getId(),
                "CREATED",
                appointment.getAppointmentTime(),
                appointment.getPatientId(),
                appointment.getAppointmentType(),
                appointment.getNotes(),
                LocalDateTime.now()
        );
    }
}
