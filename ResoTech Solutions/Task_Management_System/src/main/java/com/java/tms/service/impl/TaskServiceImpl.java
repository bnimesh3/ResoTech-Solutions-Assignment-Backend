package com.java.tms.service.impl;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.java.tms.dto.TaskDto;
import com.java.tms.entity.Task;
import com.java.tms.exception.ResourceNotFoundException;
import com.java.tms.mapper.TaskMapper;
import com.java.tms.repo.TaskRepo;
import com.java.tms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService{
	
	private TaskRepo taskrepo;
	
	public TaskServiceImpl(TaskRepo taskrepo) {
		this.taskrepo = taskrepo;
	}

	@Override
	public TaskDto createTask(TaskDto taskdto) {

		Task task=TaskMapper.mapToTask(taskdto);
		Task savedTask=taskrepo.save(task);
		return TaskMapper.mapToTaskDto(savedTask);
	}

	@Override
	public TaskDto getTaskById(Long taskId) {
		Task task= taskrepo.findById(taskId)
			.orElseThrow(() -> 
				new ResourceNotFoundException("Task is Not exists with given id "+ taskId));
		return TaskMapper.mapToTaskDto(task);
	}

	@Override
	public List<TaskDto> getallTask() {
		List<Task> tasks = taskrepo.findAll();
		return tasks.stream().map((task) -> TaskMapper.mapToTaskDto(task)).collect(Collectors.toList());
	}

	@Override
	public TaskDto updateTasks(Long taskId, TaskDto updatedTask) {
		Task task = taskrepo.findById(taskId).orElseThrow(
				() -> new ResourceNotFoundException("Task is not exists with given Id " + taskId));
		task.setTitle(updatedTask.getTitle());
		task.setDate(updatedTask.getDate());
		task.setStatus(updatedTask.getStatus());
		
		Task updatedTaskObj=taskrepo.save(task);
		return TaskMapper.mapToTaskDto(updatedTaskObj);
	}

	@Override
	public void deleteTask(Long taskId) {
		Task task = taskrepo.findById(taskId).orElseThrow(
				() -> new ResourceNotFoundException("Task is not exists with given Id " + taskId));
		taskrepo.deleteById(taskId);
	}

}
