package com.mu_dukani.prathamadokan.controller;

import java.util.List;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mu_dukani.prathamadokan.model.User;
import com.mu_dukani.prathamadokan.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserConrtroller implements ErrorController {

	private UserService userservice;

	public UserConrtroller(UserService userservice) {
		super();
		this.userservice = userservice;
	}

//	@GetMapping("/hello")
//	public String hello() {
//		return "Hello World";
//	}

	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return new ResponseEntity<User>(userservice.saveUser(user), HttpStatus.CREATED);

	}

	// Build get all users
	@GetMapping()
	public List<User> getUser() {
		return userservice.getAllUsers();
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUserId(@PathVariable Long id) {
		return new ResponseEntity<User>(userservice.getUserById(id), HttpStatus.OK);
	}

	@PutMapping("{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user) {
		return new ResponseEntity<User>(userservice.updateUser(user, id), HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long id) {
		userservice.deleteUserById(id);
		return new ResponseEntity<String>(id + " : User deleted successfully.", HttpStatus.OK);

	}

//	@GetMapping("/myuser")
//	public MyUser getMyUser() {
//		return new MyUser("Manoranjan", "9348367258");
//	}
//
//	@GetMapping("/allusers")
//	public List<MyUser> getMyUsers() {
//		List<MyUser> list = new ArrayList<>();
//		list.add(new MyUser("Soumyaranjan", "9837465682"));
//		list.add(new MyUser("Viswanath", "8008965682"));
//		list.add(new MyUser("Sudhakar", "98374647349"));
//		list.add(new MyUser("Sagar", "9837460957935"));
//		list.add(new MyUser("Mohan Manipal", "5456465682"));
//		list.add(new MyUser("Rohit", "3456465682"));
//		list.add(new MyUser("Bipin", "353465682"));
//		return list;
//	}
//
//	@GetMapping("/user/{name}/{mobileNumber}")
//	public MyUser userPathVariable(@PathVariable("name") String name,
//			@PathVariable("mobileNumber") String mobileNumber) {
//		return new MyUser(name, mobileNumber);
//	}
//
//	@GetMapping("/myusers")
//	public MyUser userpathparam(@RequestParam(name = "name") String name,
//			@RequestParam(name = "mobileNumber") String mobileNumber) {
//		return new MyUser(name, mobileNumber);
//	}

}
