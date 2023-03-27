package com.NewSpring.com.NewSpring.Repository;

import com.NewSpring.com.NewSpring.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //for interface
public interface StudentRepo extends JpaRepository<Student,Integer> {

}
