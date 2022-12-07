package com.appstracta.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegistrationService implements IRegistrationService {

	private final IRegistrationRepository repository;

	@Override
	public Registration save(Registration registration) {
		return repository.save(registration);
	}


}
