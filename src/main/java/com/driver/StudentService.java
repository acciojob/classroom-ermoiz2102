package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

@Service

public class StudentService {
@Autowired
    private StudentRepository studentRepositoryobj;
public  void addStudent(String name,Student student){
    studentRepositoryobj.studentList.put(name,student);
}
    public  void addTeacher(String name,Teacher teacher){
        studentRepositoryobj.TeacherList.put(name,teacher);
    }
    public void addPair(String name1,String name2){
    studentRepositoryobj.pair.put(name1, name2);
    if(studentRepositoryobj.TeachingList.containsKey(name2)){
        studentRepositoryobj.TeachingList.get(name2).add(studentRepositoryobj.studentList.get(name1));
    }
    else{
        List<Student>list= new ArrayList<>();
        list.add(studentRepositoryobj.studentList.get(name1));
        studentRepositoryobj.TeachingList.put(name2,list);
    }
    studentRepositoryobj.TeacherList.get(name2).setNumberOfStudents(studentRepositoryobj.TeachingList.get(name2).size());
    }
    public Student getStudent(String name){
    return studentRepositoryobj.studentList.get(name);
    }
    public Teacher getTeacher(String name){
        return studentRepositoryobj.TeacherList.get(name);
    }
    public List<String> getStudentsByTeacher(String name){
    return studentRepositoryobj.TeachingList.get(name).stream().map(Student::getName).collect(Collectors.toList());
    }
    public List<String>getAllStudents(){
    return studentRepositoryobj.getAllStudents();
    }
    public List<String>getAllTeachers(){
        return studentRepositoryobj.getAllTeachers();
    }
    public void deleteTeacher(String name){
    studentRepositoryobj.deleteTeacher(name);
    }
    public void deleteAll(){
    studentRepositoryobj.deleteAll();
    }


}
