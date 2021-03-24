package com.netflixfilms.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflixfilms.exception.ResourceNotFoundException;
import com.netflixfilms.model.Films;
import com.netflixfilms.service.FilmsService;

@RestController
@RequestMapping("/api/v1")
public class FilmsController {

	@Resource
	FilmsService filmsService;

	@GetMapping("allfilms")
	public List<Films> getAllFilms() {
		return this.filmsService.findAll();

	}

	@GetMapping("films/{title}")
	public ResponseEntity<List<Films>> findByTitleName(@PathVariable(value = "title") String title)
			throws ResourceNotFoundException {
		List<Films> films = filmsService.findByTitleName(title);
		return ResponseEntity.ok(films);
	}

	@PostMapping("films")
	public Films addFilms(@RequestBody Films films) {
		return this.filmsService.addFilms(films);

	}

}
