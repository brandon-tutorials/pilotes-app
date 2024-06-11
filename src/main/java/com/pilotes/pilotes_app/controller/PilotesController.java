package com.pilotes.pilotes_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pilotes.pilotes_app.dto.UserDTO;
import com.pilotes.pilotes_app.resquest.SaveOrderRequest;
import com.pilotes.pilotes_app.service.PilotesServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/pilotes")
public class PilotesController {
	
	@Autowired
	PilotesServiceImpl pilotesServiceImpl;

	@GetMapping("/getAll")
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		return ResponseEntity.ok(pilotesServiceImpl.getAllUsers());				
	}
		
	@PostMapping("/saveOrder")
	public ResponseEntity<?> saveOrder(@Valid @RequestBody SaveOrderRequest saveOrderRequest){
		pilotesServiceImpl.saveOrder(saveOrderRequest);
		return ResponseEntity.ok(null);
	} 
	
	@GetMapping("/containsName/{name}")
	public ResponseEntity<List<UserDTO>> findByNameContains(@PathVariable String name){
		return ResponseEntity.ok(pilotesServiceImpl.findByNameContains(name));				
	}
	
	@GetMapping("/startsWithName/{name}")
	public ResponseEntity<List<UserDTO>> findByNameStartWith(@PathVariable String name){
		return ResponseEntity.ok(pilotesServiceImpl.findByNameStarsWith(name));				
	}
  

}
