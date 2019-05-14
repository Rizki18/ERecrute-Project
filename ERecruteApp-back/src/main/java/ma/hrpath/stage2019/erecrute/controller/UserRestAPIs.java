package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.message.request.SignUpForm;
import ma.hrpath.stage2019.erecrute.message.response.ResponseMessage;
import ma.hrpath.stage2019.erecrute.model.User;
import ma.hrpath.stage2019.erecrute.security.service.AccountService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserRestAPIs {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value="/utilisateurs")
	public List<User> listutilisateurs(){
		return accountService.retreiveUsers();
	}
	
	@RequestMapping(value="/admin/saveUser",method = RequestMethod.POST)
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		String userName = signUpRequest.getUsername();
		
		if (accountService.existsByUsername(userName)) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Username is already taken!"),
					HttpStatus.BAD_REQUEST);
		}

		if (accountService.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<>(new ResponseMessage("Fail -> Email is already in use!"),
					HttpStatus.BAD_REQUEST);
		}
		
		accountService.saveUser(new User(signUpRequest.getName(),userName,
				signUpRequest.getEmail(),signUpRequest.getPassword()));
		System.out.println("*****ROLES: "+signUpRequest.getRole());
		accountService.addRoleToUser(userName, signUpRequest.getRole());
		
		return new ResponseEntity<>(new ResponseMessage("User registered successfully!"), HttpStatus.OK);
	}
	
	@RequestMapping(value="/admin/updateUser/{id}",method = RequestMethod.PUT)
	public ResponseEntity<Object> updateStudent(@RequestBody SignUpForm signUpRequest, @PathVariable long id) {
    
		Optional<User> userOptional = accountService.findUserById(id);
    
		if (!userOptional.isPresent())
			return ResponseEntity.notFound().build();
    
		User user = new User(signUpRequest.getName(),signUpRequest.getUsername(),
				signUpRequest.getEmail(),signUpRequest.getPassword());
		
		user.setId(id);
		
		accountService.updateUser(user);
		System.out.println("*****ROLES: "+signUpRequest.getRole());
		accountService.addRoleToUser(signUpRequest.getUsername(), signUpRequest.getRole());
    
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/admin/deleteUser/{id}",method = RequestMethod.DELETE)
	public void delete(@PathVariable("id") Long id) {
		accountService.deleteUser(id);
	}
}
