package com.tournihost.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.tournihost.repository.FootballerRepository;

import common.model.FootBaller;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class FootballerServiceImpl implements FootballerService {

	private FootballerRepository footballerRepository;
	
	@Override
	public FootBaller getFootballerByName(String name) throws EntityNotFoundException{

		FootBaller footBaller=new FootBaller();
		Optional<FootBaller> optionalFootballer=footballerRepository.findByName(name);
		if(optionalFootballer.isPresent()) {
			footBaller=optionalFootballer.get();
		}else {
			throw new EntityNotFoundException(name+" Was Not Found");
		}
		return footBaller;
	}

	@Override
	public FootBaller save(FootBaller footBaller) {
		
		FootBaller savedFootBaller=footballerRepository.save(footBaller);
		return savedFootBaller;
	}

	@Override
	public List<FootBaller> allFootballers() {
		
		return footballerRepository.findAll();
	}

}
