package ma.hrpath.stage2019.authentification.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class TestRestAPIs {
	
	@GetMapping("/api/test/recruteur")
	@PreAuthorize("hasRole('RECRUTEUR') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> Project Management Board Recruteur";
	}

	@GetMapping("/api/test/responsable")
	@PreAuthorize("hasRole('RESPONSABLE') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board Responsable";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Project Management Board Responsable Admin";
	}
}