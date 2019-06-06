package ma.hrpath.stage2019.erecrute.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ma.hrpath.stage2019.erecrute.model.MotCles;
import ma.hrpath.stage2019.erecrute.security.service.MotCleService;

@CrossOrigin("*")
@RestController
public class MotclesRestAPIs {

	@Autowired
	private MotCleService MotCleservice;
	
	@RequestMapping(value="/admin/saveMotcles",method = RequestMethod.POST)
	@PreAuthorize("hasRole('ADMIN')")
	public MotCles saveMotCles(@RequestBody MotCles p) {
		return MotCleservice.saveMotCles(p);
	}
	@RequestMapping(value="/admin/deleteMotcles/{codeMotCles}",method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('ADMIN')")
	public void deleteMotCles(@PathVariable("codeMotCles") Long codeMotCles) {
		MotCleservice.deleteMotCles(codeMotCles);
	}
	@RequestMapping(value="/Motcles")
	public List<MotCles> listMotCles(){
		return MotCleservice.retreiveMotCles();
	}
	@RequestMapping(value="/MotclesName")
	public List<String> listMotClesName(){
		return MotCleservice.retreiveMotClesName();
	}

	@RequestMapping(value="/MotclesByName")
	public MotCles MotClesName(@PathVariable("MotCles") String name){
		return MotCleservice.findMotClesByNAme(name);
	}
}
