package com.appstracta.registration;

import com.appstracta.kafka.KafkaProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService implements IRegistrationService {

	private final IRegistrationRepository repository;

	private final KafkaProducer producer;

	@Override
	public Registration save(Registration registration) {
		// Programación para comunicarse con los otros Web Service y realizar las validaciones solicitadas

		Registration registrationSave = repository.save(registration);
		// Enviar a kafka
		producer.sendMessage(registrationSave);

		return registrationSave;
	}


}
