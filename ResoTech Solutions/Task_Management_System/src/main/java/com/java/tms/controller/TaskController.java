package com.java.tms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.tms.dto.TaskDto;
import com.java.tms.service.TaskService;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	private TaskService taskservice;

	public TaskController(TaskService taskservice) {
		this.taskservice = taskservice;
	}
	
	// Build Add Task REST API
	@RequestMapping
	public ResponseEntity<TaskDto> createTask(@RequestBody TaskDto taskdto){
		TaskDto savedTask=taskservice.createTask(taskdto);
		return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
	}
	
	// Build GET Task REST API
	@GetMapping("{id}")
	public ResponseEntity<TaskDto> getTaskById(@PathVariable("id") Long taskId){
		TaskDto taskDto=taskservice.getTaskById(taskId);
		return ResponseEntity.ok(taskDto);
	}
	
	// Build GET all Task Rest API
	@GetMapping
	public ResponseEntity<List<TaskDto>> getAllTasks(){
		List<TaskDto> tasks=taskservice.getallTask();
		return ResponseEntity.ok(tasks);
	}
	
	// build update Task REST API
	@PutMapping("{id}")
	public ResponseEntity<TaskDto> updateTask(@PathVariable("id") Long taskId, @RequestBody TaskDto updatedTask){
		TaskDto taskDto=taskservice.updateTasks(taskId, updatedTask);
		return ResponseEntity.ok(taskDto);
	}
	
	// build Delete Task REST API
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteTask(@PathVariable("id") Long taskId){
		taskservice.deleteTask(taskId);
		return ResponseEntity.ok("Task Deleted Successfully!...");
	}
}
