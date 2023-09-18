package com.java.spring.beltreview.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.java.spring.beltreview.models.Project;
import com.java.spring.beltreview.services.ProjectService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	
	// import service
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/dash")
	public String dashboard(HttpSession session, Model model) {
		if(session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		List<Project> allProjects = projectService.allProjects();
		model.addAttribute("projectList", allProjects);
		return "dash.jsp";
	}
	
	@GetMapping("/projects/new")
	public String renderCreateProjectForm(@ModelAttribute("newProject")Project newProject) {
		return "createProject.jsp";
	}
	
	@PostMapping("/projects/new")
	public String processCreateProject(@Valid @ModelAttribute("newProject")Project newProject,
			BindingResult result) {
		if(result.hasErrors()) {
			return "createProject.jsp";
		}else {
			projectService.createProject(newProject);
			return "redirect:/dash";
		}
	}
	
	// Details page: get id from path, get details from service, put it in Model model
	@GetMapping("/projects/{id}")
	public String projectDetailsPage(@PathVariable("id") Long id, Model model) {
		Project oneProject = projectService.oneProject(id);
		model.addAttribute("oneProject", oneProject);
		return "projectDetails.jsp";
	}
	
	// Delete
	@DeleteMapping("/projects/{id}")
	public String deleteProjectById(@PathVariable("id") Long id) {
		projectService.deleteProject(id);
		return "redirect:/dash";
	}
	
	// Edit
	@GetMapping("projects/edit/{id}")
	public String renderEditProjectform(@PathVariable("id") Long id, Model model) {
		Project oneProject = projectService.oneProject(id);
		model.addAttribute("oneProject", oneProject);
		return "editProject.jsp";
	}
	
	@PutMapping("projects/edit/{id}")
	public String processEditProject(@Valid @ModelAttribute("oneProject")Project oneProject,
			BindingResult result) {
		if(result.hasErrors()) {
			return "editProject.jsp";
		}
		else {
			projectService.updateProject(oneProject);
			return "redirect:/dash";
		}
	}

}
