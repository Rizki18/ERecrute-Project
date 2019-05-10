package ma.hrpath.stage2019.erecrute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.Role;
import ma.hrpath.stage2019.erecrute.model.RoleName;

public interface RoleRepository extends JpaRepository<Role, Long>{
	Role findByName(RoleName roleName);
}
