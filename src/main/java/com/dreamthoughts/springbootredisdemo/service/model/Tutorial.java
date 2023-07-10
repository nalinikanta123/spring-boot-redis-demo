package com.dreamthoughts.springbootredisdemo.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tutorial")
public class Tutorial {

	@Id
	private Long id;
	private String description;
	private boolean published;
	private String title;

}
