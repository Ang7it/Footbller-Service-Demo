package com.tournihost.controller;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tournihost.service.FootballerService;

import common.model.FootBaller;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "api/v1/footballer")
public class FootballerController {

	private final FootballerService footballerService;
	
	@GetMapping("/findByName")
	public ResponseEntity<FootBaller> getFootballerByName(@RequestParam(value = "name") String footballerName) {
		
		try{
			return new ResponseEntity<FootBaller>(footballerService.getFootballerByName(footballerName), HttpStatus.OK); 
		}catch (Exception e) {
			throw new EntityNotFoundException(e.getMessage());
		}
		
	}
	
	@PostMapping("/save")
	public ResponseEntity<FootBaller> saveFootballer(@RequestBody FootBaller footBaller){
		
		return new ResponseEntity<FootBaller>(footballerService.save(footBaller), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<FootBaller>> getAllFootballers(){
		
		return new ResponseEntity<List<FootBaller>>(footballerService.allFootballers(),HttpStatus.OK);
	}
}
