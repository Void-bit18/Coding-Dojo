package com.java.spring.beltreview.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.spring.beltreview.models.Project;
import com.java.spring.beltreview.repositories.ProjectRepository;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	// find all
	public List<Project> allProjects(){
		return projectRepo.findAll();
	}
	
	// find one
	public Project oneProject(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		}else {
			return null;
		}
	}
	
	// create
	public Project createProject(Project newProject) {
		return projectRepo.save(newProject);
	}
	
	// update
	public Project updateProject(Project oneProject) {
		return projectRepo.save(oneProject);
	}
	
	// delete
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}

}
