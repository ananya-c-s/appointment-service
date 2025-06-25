package com.project.appointmentsservice.service;


import com.project.appointmentsservice.dto.CreateAppointmentRequest;
import com.project.appointmentsservice.kafka.AppointmentEventProducer;
import com.project.appointmentsservice.model.Appointment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AppointmentService {

    private final AppointmentEventProducer eventProducer;

    public AppointmentService(AppointmentEventProducer eventProducer) {
        this.eventProducer = eventProducer;
    }

    public void createAppointment(CreateAppointmentRequest request) {
        String appointmentId = UUID.randomUUID().toString();

        Appointment appointment = Appointment.builder()
                .id(appointmentId)
                .patientId(request.getPatientId())
                .appointmentTime(request.getAppointmentTime())
                .appointmentType(request.getAppointmentType())
                .notes(request.getNotes())
                .status("SCHEDULED")
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        eventProducer.publishAppointmentCreated(appointment);
    }
}
