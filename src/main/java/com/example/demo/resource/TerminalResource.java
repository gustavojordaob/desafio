package com.example.demo.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.domain.Terminal;
import com.example.demo.services.TerminalService;
import com.sun.istack.NotNull;

@RestController
@RequestMapping("v1/terminal")
public class TerminalResource {

	@Autowired
	private TerminalService service;
	
	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<Terminal>> findAll()
	{
		List<Terminal> terminals =  service.findAll();
		return ResponseEntity.ok(terminals); 
	}
	
	@GetMapping(value = {"/{logic}"}, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Terminal> findByLogic(@PathVariable("logic") Integer logic){
		Terminal terminal = service.findByLogic(logic);
		return ResponseEntity.ok(terminal);
	}
	
	@PostMapping(produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> insert(@RequestBody @NotNull Terminal terminal){
		
		terminal = service.insert(terminal) ;
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{URI}").buildAndExpand(terminal.getLogic()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = { "v1/terminal/{logic}" }, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> update(@PathVariable("logic") Integer logic, @RequestBody @NotNull Terminal terminal){
		terminal.setLogic(logic);
		service.update(terminal);
		return ResponseEntity.noContent().build();
	}
}
