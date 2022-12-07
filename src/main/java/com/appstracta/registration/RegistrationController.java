package com.appstracta.registration;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class RegistrationController {

	private final IRegistrationService service;

	@PostMapping
	public ResponseEntity<Registration> save(@RequestBody Registration Registration, HttpServletRequest httpServletRequest) {
		Registration registrationSave = service.save(Registration);
		URI location = ServletUriComponentsBuilder.fromServletMapping(httpServletRequest).path("/{id}").build().expand(registrationSave.getId()).toUri();

		return ResponseEntity.created(location).body(registrationSave);
	}

}
