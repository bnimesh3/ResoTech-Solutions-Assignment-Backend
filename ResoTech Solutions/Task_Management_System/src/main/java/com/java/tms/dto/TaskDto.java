package com.java.tms.dto;

import java.util.Date;

public class TaskDto {
	
	private Long id;
	private String title;
	private Date date;
	private String status;
	
	public TaskDto() {
		
	}

	public TaskDto(Long id, String title, Date date, String status) {
		this.id = id;
		this.title = title;
		this.date = date;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
