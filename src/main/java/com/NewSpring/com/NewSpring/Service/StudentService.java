package com.NewSpring.com.NewSpring.Service;

import com.NewSpring.com.NewSpring.Repository.StudentRepo;
import com.NewSpring.com.NewSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    // You may use private StudentRepo;
    final StudentRepo studentRepo;

    // StudentRepo Constructor was generated;
    public StudentService(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student>getAllStudents(){
        return studentRepo.findAll();
    }

    //Create methode save() and save by(studentRepo.save(student))
 public  void save(Student student){
        studentRepo.save(student);
  }

  //Optional<Student> result (used to check if Student Id is present or not)
    public Student get(int Id) throws Exception {
        Optional<Student> result= studentRepo.findById(Id);
        if (result.isPresent()){
            return result.get();
        }
       throw new Exception(String.format("Could not find user with Id %d", Id));
    }
}



