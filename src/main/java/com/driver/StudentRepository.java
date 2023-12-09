package com.driver;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    Map<String, Student>studentList=new HashMap<>();
    Map<String,Teacher>TeacherList=new HashMap<>();
    Map<String,String>pair=new HashMap<>();
    Map<String,List<Student>>TeachingList= new HashMap<>();
    public List<String>getAllStudents(){
        return studentList.values().stream().map(Student::getName).collect(Collectors.toList());
    }
    public List<String>getAllTeachers(){
        return TeacherList.values().stream().map(Teacher::getName).collect(Collectors.toList());
    }
    public void deleteTeacher(String name){
    List<Student>list=TeachingList.get(name);
    for(Student student:list){
        studentList.remove(student.getName());
        pair.remove(student.getName());

    }
    TeachingList.remove(name);
    TeacherList.remove(name);
    }
    public void deleteAll(){
        studentList.clear();
        TeacherList.clear();
        pair.clear();
        TeachingList.clear();
    }

}
