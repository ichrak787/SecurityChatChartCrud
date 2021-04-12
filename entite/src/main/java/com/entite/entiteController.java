package com.entite;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path="/application")
public class entiteController {
	private final entiteRepository repository;
	entiteController(entiteRepository repository){
		this.repository=repository;
	}
	  @PostMapping("/add")
	 entite newEntite(@RequestBody entite newEntite) {
	    return repository.save(newEntite);
	  }
	  
	  @GetMapping("/all")
	  List<entite> all() {
	    return repository.findAll();
	  }
	  
	  
	  
	  @PutMapping("/User/{id}")
	 entite replaceEntite(@RequestBody entite  newEntite, @PathVariable Long id) {
	    
	    return repository.findById(id)
	      .map(entite -> {
	        entite.setName(newEntite.getName());
	        entite.setRole(newEntite.getRole());
	        return repository.save(entite);
	      })
	      .orElseGet(() -> {
	        newEntite.setId(id);
	        return repository.save(newEntite);
	      });
	  }

  
	  
	  
	  @DeleteMapping("/entite/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    repository.deleteById(id);
	  }
	  
	  


}
