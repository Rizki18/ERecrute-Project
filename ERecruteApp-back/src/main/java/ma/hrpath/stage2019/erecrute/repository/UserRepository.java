package ma.hrpath.stage2019.erecrute.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ma.hrpath.stage2019.erecrute.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	User findByEmail(String email);
}
