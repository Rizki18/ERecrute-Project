package ma.hrpath.stage2019.erecrute.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.model.CV;
import ma.hrpath.stage2019.erecrute.security.service.CVThequeService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class CVThequeRestAPIs {
	@Autowired
	private CVThequeService cvThequeService;
	
	@RequestMapping(value="/admin/saveCv",method = RequestMethod.POST)
	@PreAuthorize("hasRole('RECRUTEUR')")
	public CV saveCv(@RequestBody CV cv) {
	
		return cvThequeService.saveCV(cv);
	}
}
