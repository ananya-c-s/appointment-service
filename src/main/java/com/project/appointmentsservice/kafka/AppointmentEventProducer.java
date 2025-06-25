package com.project.appointmentsservice.kafka;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.project.appointmentsservice.model.Appointment;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AppointmentEventProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
    private static final String APPOINTMENTS_TOPIC = "appointments";

    public void publishAppointmentEvent(AppointmentEvent event) {
        try {
            String eventJson = objectMapper.writeValueAsString(event);
            String key = event.getAppointmentId();

            kafkaTemplate.send(APPOINTMENTS_TOPIC, key, eventJson)
                    .whenComplete((result, ex) -> {
                        if (ex != null) {
                            System.err.println("Error sending event: " + ex.getMessage());
                            ex.printStackTrace();
                        } else if (result != null) {
                            var metadata = result.getRecordMetadata();
                            System.out.println("Sent event to topic: " + metadata.topic() +
                                    ", partition: " + metadata.partition() +
                                    ", offset: " + metadata.offset());
                        }
                    });
        } catch (JsonProcessingException e) {
            System.err.println("Serialization failed: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void publishAppointmentCreated(Appointment appointment) {

        AppointmentEvent event = AppointmentEvent.created(appointment);
        publishAppointmentEvent(event);
    }

}
