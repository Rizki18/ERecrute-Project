package ma.hrpath.stage2019.authentification.security.service;

import java.util.Set;

import ma.hrpath.stage2019.authentification.model.Role;
import ma.hrpath.stage2019.authentification.model.User;

public interface AccountService {
	public User saveUser(User user);
	public Role saveRole(Role role);
	public Boolean existsByUsername(String userName);
	public Boolean existsByEmail(String email);
	public void addRoleToUser(String userName,Set<String> strRoles);
	public User findUserByUsername(String username);
}
