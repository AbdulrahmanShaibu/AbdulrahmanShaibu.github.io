package com.NewSpring.com.NewSpring.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table // for mapping with table from database
@Entity //for mapping class Student with database
@AllArgsConstructor
//@NoArgsConstructor
public class Student {
     @Id //here id is primary key
     @GeneratedValue(strategy = GenerationType.IDENTITY)// default generated value

    private Integer Id;
    private String FirstName;
    private String LastName;
    private String Location;

    //generate setter and getter methods

    public void setId(Integer id) {
        this.Id = id;
    }

    public Integer getId() {
        return Id;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLocation(String location) {
        this.Location = location;
    }

    public String getLocation() {
        return Location;
    }

    // The codes below  @Override were generated automatically
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Student student = (Student) o;
        return Id != null && Objects.equals(Id, student.Id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    public void addAttribute(String studentList, List<Student> allStudents) {
    }
}
