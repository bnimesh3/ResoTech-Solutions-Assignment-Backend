package com.java.tms.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.tms.entity.Task;

public interface TaskRepo extends JpaRepository<Task, Long>{

}
