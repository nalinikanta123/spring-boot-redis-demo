package com.dreamthoughts.springbootredisdemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import com.dreamthoughts.springbootredisdemo.service.model.Tutorial;
import com.dreamthoughts.springbootredisdemo.service.repository.TutorialRepository;

@Service
@EnableCaching
public class TutorialService {
	@Autowired
	TutorialRepository tutorialRepository;

	@Cacheable("tutorials")
	public List<Tutorial> findAll() {
		doLongRunningTask();

		return tutorialRepository.findAll();
	}

	@Cacheable("tutorials")
	public List<Tutorial> findByTitleContaining(String title) {
		doLongRunningTask();

		return tutorialRepository.findByTitleContaining(title);
	}

	@Cacheable("tutorial")
	public Optional<Tutorial> findById(long id) {
		doLongRunningTask();

		return tutorialRepository.findById(id);
	}

	@Cacheable("published_tutorials")
	public List<Tutorial> findByPublished(boolean isPublished) {
		doLongRunningTask();

		return tutorialRepository.findByPublished(isPublished);
	}

	private void doLongRunningTask() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
