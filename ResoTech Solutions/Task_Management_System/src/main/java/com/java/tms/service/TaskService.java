package com.java.tms.service;

import java.util.List;

import com.java.tms.dto.TaskDto;

public interface TaskService {
	
	TaskDto createTask(TaskDto taskdto);
	TaskDto getTaskById(Long taskId);
	List<TaskDto> getallTask();
	TaskDto updateTasks(Long taskId, TaskDto updatedTask);
	void deleteTask(Long taskId);
}
