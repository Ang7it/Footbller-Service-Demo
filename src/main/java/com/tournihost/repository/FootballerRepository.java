package com.tournihost.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import common.model.FootBaller;

@Repository
public interface FootballerRepository extends JpaRepository<FootBaller,Long> {
	
	Optional<FootBaller> findByName(String name);
}
