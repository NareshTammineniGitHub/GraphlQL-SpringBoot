package com.example.demo.mutation;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.example.demo.request.CreateStudentRequest;
import com.example.demo.response.StudentResponse;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    StudentService studentService;

    public StudentResponse createStudent(CreateStudentRequest createStudentRequest){
        return new StudentResponse((studentService.createStudent(createStudentRequest)));
    }
}

/* Graph Query to insert
* mutation{
  createStudent(createStudentRequest : {
    firstName : "RAMESH"
    lastName : "Tendularkar"
    email : "sachin.k@gmail.com"
    street : "any street"
    city : "houston"
    subjectsLearning : [{
      subjectName : "Java"
      marksObtained : 60.00
    },
    {
      subjectName : "MYSQL"
      marksObtained : 70.00
    }
    ]
  }) {
    id
    firstName
    lastName
    email
    street
    city
    learningSubjects {
      id
      subjectName
      marksObtained
    }
    fullName
  }

}
* */
