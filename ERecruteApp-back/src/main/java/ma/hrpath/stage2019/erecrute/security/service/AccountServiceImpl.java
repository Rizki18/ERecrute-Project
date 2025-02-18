package ma.hrpath.stage2019.erecrute.security.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ma.hrpath.stage2019.erecrute.message.response.ResponseMessage;
import ma.hrpath.stage2019.erecrute.model.Role;
import ma.hrpath.stage2019.erecrute.model.RoleName;
import ma.hrpath.stage2019.erecrute.model.User;
import ma.hrpath.stage2019.erecrute.repository.RoleRepository;
import ma.hrpath.stage2019.erecrute.repository.UserRepository;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	PasswordEncoder encoder;
	
	@Override
	public User saveUser(User user) {
		user.setPassword(encoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	
	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Role saveRole(Role role) {
		return roleRepository.save(role);
	}

	@Override
	public Boolean existsByUsername(String userName) {
		if(userRepository.findByUsername(userName) != null)
			return true;
		return false;
	}
	
	@Override
	public Boolean existsByEmail(String email) {
		if(userRepository.findByEmail(email) != null)
			return true;
		return false;
	}

	@Override
	public void addRoleToUser(String userName, Set<String> strRoles) {
		User user = userRepository.findByUsername(userName);
		
		Set<Role> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "admin":
				Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN);
				roles.add(adminRole);

				break;
			case "responsable":
				Role respRole = roleRepository.findByName(RoleName.ROLE_RESPONSABLE);
				roles.add(respRole);

				break;
			default:
				Role recRole = roleRepository.findByName(RoleName.ROLE_RECRUTEUR);
				roles.add(recRole);
			}
		});

		user.setRoles(roles);

	}

	@Override
	public User findUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Optional<User> findUserById(Long id) {
		return userRepository.findById(id);
	}

	@Override
	public List<User> retreiveUsers() {
		return userRepository.findAll();
	}

	@Override
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
