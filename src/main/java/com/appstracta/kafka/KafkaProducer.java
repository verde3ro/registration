package com.appstracta.kafka;

import com.appstracta.registration.Registration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducer {

	private final KafkaTemplate<String, Registration> kafkaTemplate;

	public void sendMessage(Registration registration) {
		log.info("Enviando venta realizada desde Registration {}", registration.toString());
		String kafkaTopic = "tbank";

		this.kafkaTemplate.send(kafkaTopic, registration);
	}

}
