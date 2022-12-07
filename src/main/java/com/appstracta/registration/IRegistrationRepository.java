package com.appstracta.registration;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IRegistrationRepository extends JpaRepository<Registration, Long> {
}