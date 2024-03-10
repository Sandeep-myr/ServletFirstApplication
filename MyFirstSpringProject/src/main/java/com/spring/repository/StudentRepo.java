package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.StudentEntity;

@Repository
public interface StudentRepo extends JpaRepository<StudentEntity, Long> {

}
