package ma.hrpath.stage2019.authentification.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.authentification.model.Role;
import ma.hrpath.stage2019.authentification.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(RoleName roleName);
}
