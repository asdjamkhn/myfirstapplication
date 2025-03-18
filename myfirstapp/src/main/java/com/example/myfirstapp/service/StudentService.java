package com.example.myfirstapp.service;


import com.example.myfirstapp.apiresponse.ApiResponse;
import com.example.myfirstapp.repository.StudentInterface;
import com.example.myfirstapp.student.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentInterface studentInterface;

    @Autowired
    public StudentService(StudentInterface studentInterface) {
        this.studentInterface = studentInterface;
    }

    public List<Student> getStudent(){
        return studentInterface.findAll();

    }


    public Optional<Student> getStudentById(int id) {
        return studentInterface.findById(id);
    }


    public boolean deleteStudentById(int id) {

        Optional<Student> student = studentInterface.findById(id);

        if (student.isPresent()) {
            studentInterface.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public boolean updateStudent(int id, Student newstudent) {

        Optional<Student> student = studentInterface.findById(id);

        if (student.isPresent()) {

            Student oldStudent = studentInterface.findById(id).get();
            oldStudent.setName(newstudent.getName());
            oldStudent.setEmail(newstudent.getEmail());
            oldStudent.setAge(newstudent.getAge());
            oldStudent.setDob(newstudent.getDob());
            studentInterface.save(oldStudent);

            return true;
        }else{
            return false;

        }
    }

    public Student addStudent(Student student) {     //return type int and use ytry catch

        if (!student.getEmail().contains("@gmail.com")) {
            return null;
        }

        Student student1 = studentInterface.save(student);

        return student1;

    }
}
