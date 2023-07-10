package com.dreamthoughts.springbootredisdemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dreamthoughts.springbootredisdemo.service.TutorialService;
import com.dreamthoughts.springbootredisdemo.service.model.Tutorial;
import com.dreamthoughts.springbootredisdemo.service.repository.TutorialRepository;

@RestController
public class TutorialController {

	@Autowired
	private TutorialRepository tutorialRepository;

	@Autowired
	private TutorialService tutorialService;

	@PostMapping("creattutorial")
	public ResponseEntity<String> createTutorial(@RequestBody Tutorial turorial) {
		tutorialRepository.save(turorial);

		return new ResponseEntity<String>("tutorial created", HttpStatus.CREATED);
	}

	@GetMapping("tutorialById/{tutorialById}")
	public ResponseEntity<Tutorial> retrieveTutorialById(@PathVariable Long tutorialId) {
		Optional<Tutorial> tutorialList = tutorialRepository.findById(tutorialId);

		return new ResponseEntity<Tutorial>(tutorialList.get(), HttpStatus.OK);
	}
	
	@GetMapping("tutorialByTitle/{tutorialByTitle}")
	public ResponseEntity<Tutorial> retrieveTutorialByTitle(@PathVariable Long tutorialId) {
		Optional<Tutorial> tutorialList = tutorialRepository.findById(tutorialId);

		return new ResponseEntity<Tutorial>(tutorialList.get(), HttpStatus.OK);
	}

	@GetMapping("tutorials")
	public ResponseEntity<List<Tutorial>> retrieveTutorialById() {
		List<Tutorial> tutorialList = tutorialService.findAll();

		return new ResponseEntity<List<Tutorial>>(tutorialList, HttpStatus.OK);
	}
}
