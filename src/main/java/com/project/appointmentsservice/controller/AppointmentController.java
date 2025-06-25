package com.project.appointmentsservice.controller;


import com.project.appointmentsservice.dto.CreateAppointmentRequest;
import com.project.appointmentsservice.dto.UpdateStatusRequest;
import com.project.appointmentsservice.model.Appointment;
import com.project.appointmentsservice.service.AppointmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/appointments")
@CrossOrigin(origins = "*")
@Slf4j
@Validated
public class AppointmentController {

    private final AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    @PostMapping("/request")
    public ResponseEntity<String> requestAppointment(@RequestBody @Valid CreateAppointmentRequest request) {
        appointmentService.createAppointment(request);
        return ResponseEntity.ok("Appointment request sent to Kafka");
    }
}
