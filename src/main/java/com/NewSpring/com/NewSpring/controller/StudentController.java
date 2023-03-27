package com.NewSpring.com.NewSpring.controller;

import com.NewSpring.com.NewSpring.Service.StudentService;
import com.NewSpring.com.NewSpring.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;




@Controller
public class StudentController {
    @Autowired // For dependency injection(StudentService is passed in StudentController);
    final StudentService studentService;
    private int id;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping("/ViewTable")
    public String getStudentTable(Model model) {
        model.addAttribute("StudentList", studentService.getAllStudents());
        return "StudentTable";
    }
    @GetMapping("/Home/NewFrom")
    public String NewForm( @ModelAttribute("student") Student student){//Student is class name
       student.addAttribute("StudentList", studentService.getAllStudents());
        return "RegistrationForm";
    }
  @PostMapping("/form/save")
    public String SaveInForm(Student student, RedirectAttributes ra){
       studentService.save(student);
       ra.addFlashAttribute("message","Saved successfully" );
      return "redirect:/ViewTable";
  }
//Codes are not working
  @GetMapping("/student/Update/{Id}")
  public String UpdateForm(@PathVariable("Id") int Id,Model model,RedirectAttributes ra){
      try {
            Student student = studentService.get(Id);
            model.addAttribute("student", student);
            return "RegistrationForm";
      } catch (Exception e) {
          ra.addFlashAttribute("Status","Updated successfully" );
          return "redirect:/ViewTable";
      }
  }

}



