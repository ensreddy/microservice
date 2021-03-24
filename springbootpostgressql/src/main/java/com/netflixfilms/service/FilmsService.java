package com.netflixfilms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflixfilms.model.Films;
import com.netflixfilms.repository.FilmsRepository;



@Service
public class FilmsService {
	
	@Autowired
	private FilmsRepository filmsRepository;
	
	public Films addFilms(Films films) {
		return filmsRepository.save(films);
	}

	public List<Films> findAll() {
		return filmsRepository.findAll();
	}
	
	public List<Films> findByTitleName(String title){
		return filmsRepository.findByTitleName(title);
	}

}
