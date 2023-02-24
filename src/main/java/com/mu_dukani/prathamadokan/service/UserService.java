package com.mu_dukani.prathamadokan.service;

import java.util.List;

import com.mu_dukani.prathamadokan.model.User;

public interface UserService {
	User saveUser(User user);

	List<User> getAllUsers();

	User getUserById(Long id);

	User updateUser(User user, Long id);

	void deleteUserById(Long id);

}
