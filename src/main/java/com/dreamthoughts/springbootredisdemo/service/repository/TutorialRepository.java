package com.dreamthoughts.springbootredisdemo.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dreamthoughts.springbootredisdemo.service.model.Tutorial;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {

	List<Tutorial> findByTitleContaining(String title);

	List<Tutorial> findByPublished(boolean isPublished);

}
