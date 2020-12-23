package com.tournihost.service;

import java.util.List;

import common.model.FootBaller;

public interface FootballerService {

	FootBaller getFootballerByName(String name);
	
	FootBaller save(final FootBaller footBaller);
	
	List<FootBaller> allFootballers();
}
