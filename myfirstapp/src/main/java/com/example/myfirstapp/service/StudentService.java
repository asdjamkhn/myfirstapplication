package com.example.myfirstapp.service;


import com.example.myfirstapp.dto.StudentDto;
import com.example.myfirstapp.repository.StudentInterface;
import com.example.myfirstapp.model.Student;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


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

    public boolean updateStudent(int id, StudentDto studentDto) {

        Optional<Student> student = studentInterface.findById(id);

        if (student.isPresent()) {

            Student oldStudent = student.get();
            oldStudent.setName(studentDto.getName());
            oldStudent.setEmail(studentDto.getEmail());
            oldStudent.setAge(studentDto.getAge());
            oldStudent.setDob(studentDto.getDob());
            studentInterface.save(oldStudent);

            return true;
        }else{
            return false;

        }
    }

    public Student addStudent(StudentDto studentDto) {     //return type int and use ytry catch

        if (!studentDto.getEmail().contains("@gmail.com")) {
            return null;
        }

        Student newStudent = new Student();
        newStudent.setName(studentDto.getName());
        newStudent.setAge(studentDto.getAge());
        newStudent.setDob(studentDto.getDob());
        newStudent.setEmail(studentDto.getEmail());

        return studentInterface.save(newStudent);

    }
}
