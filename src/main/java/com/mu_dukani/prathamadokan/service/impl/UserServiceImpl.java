package com.mu_dukani.prathamadokan.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mu_dukani.prathamadokan.exception.ResourceNotFoundException;
import com.mu_dukani.prathamadokan.model.User;
import com.mu_dukani.prathamadokan.repository.UserRepository;
import com.mu_dukani.prathamadokan.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userrepository;

	public UserServiceImpl(UserRepository userrepository) {
		super();
		this.userrepository = userrepository;
	}

	@Override
	public User saveUser(User user) {

		return userrepository.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return userrepository.findAll();
	}

	@Override
	public User getUserById(Long id) {
//		Optional<User> user = userrepository.findById(id);
//		if (user.isPresent()) {
//			return user.get();
//		} else {
//			throw new ResourceNotFoundException("user", "id", id);
//		}
		return userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
	}

	@Override
	public User updateUser(User user, Long id) {
		User existinguser = userrepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", id));
		existinguser.setName(user.getName());
		existinguser.setMobileNumber(user.getMobileNumber());
		existinguser.setEmailId(user.getEmailId());
		userrepository.save(existinguser);
		return existinguser;
	}

	@Override
	public void deleteUserById(Long id) {
		userrepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("name", "id", id));
		userrepository.deleteById(id);

	}

}
