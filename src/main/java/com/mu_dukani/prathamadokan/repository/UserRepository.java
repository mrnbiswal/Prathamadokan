package com.mu_dukani.prathamadokan.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mu_dukani.prathamadokan.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
