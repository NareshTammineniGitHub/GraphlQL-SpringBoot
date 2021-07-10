package com.example.demo.Query;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.example.demo.request.SampleRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Query implements GraphQLQueryResolver {

    @Autowired
    StudentService studentService;

    public String firstQuery(){
        return "first query";
    }

    public String secondQuery(String name){
        return "Second Query: Hello "+name;
    }

    public String fullName(SampleRequest sampleRequest){
        return sampleRequest.getFirstName() +" "+ sampleRequest.getLastName();
    }
    public StudentResponse getStudent(long id){
        return new StudentResponse(studentService.getStudentById(id));
    }
}

/* Graph Query to get students
* query{
  student(id : 4) {
    id
    firstName
    lastName
    email
    street
    city
    learningSubjects(subjectNameFilter : ALL) {
      id
      subjectName
      marksObtained
    }
    fullName
  }
}
* */
