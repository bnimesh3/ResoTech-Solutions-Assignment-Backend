package com.java.tms.mapper;

import com.java.tms.dto.TaskDto;
import com.java.tms.entity.Task;

public class TaskMapper {

	public static TaskDto mapToTaskDto(Task task) {
		return new TaskDto(task.getId(), task.getTitle(), task.getDate(), task.getStatus());
	}
	
	public static Task mapToTask(TaskDto taskdto) {
		return new Task(taskdto.getId(), taskdto.getTitle(), taskdto.getDate(), taskdto.getStatus());
	}
}
