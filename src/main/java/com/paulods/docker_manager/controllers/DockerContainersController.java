package com.paulods.docker_manager.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.dockerjava.api.model.Container;
import com.paulods.docker_manager.services.DockerService;

@RestController
@RequestMapping("/api/containers")
public class DockerContainersController {
	private final DockerService dockerService;
		
		public DockerContainersController(DockerService dockerService) {
			this.dockerService = dockerService;
		}
		
		@GetMapping("")
		public List<Container> listContainers(@RequestParam(required = false, defaultValue = "true") boolean showAll){
			return dockerService.listContainers(showAll);
		}
		
		@PostMapping("/{id}/start")
		public void startContainer(@PathVariable String id) {
			dockerService.startContainer(id);
		}
		
		@PostMapping("/{id}/start")
		public void stopContainer(@PathVariable String id) {
			dockerService.stopContainer(id);
		}
		
		@PostMapping("/{id}/start")
		public void deleteContainer(@PathVariable String id) {
			dockerService.deleteContainer(id);
		}
		
		@PostMapping("/{id}/start")
		public void createContainer(@RequestParam String imageName) {
			dockerService.createContainer(imageName);
		}
}
