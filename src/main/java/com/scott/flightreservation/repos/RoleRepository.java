package com.scott.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.scott.flightreservation.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
