package com.snva.soap.student.endpoints;

import com.snva.ex.soap.xml.student.*;
import com.snva.soap.student.model.StudentEntity;
import com.snva.soap.student.service.IStudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.ArrayList;
import java.util.List;

@Endpoint
public class StudentEndpoint {

    public static final String STUDENT_NAMESPACE_URI = "http://snva.com/ex/soap/xml/student";
    @Autowired
    private IStudentService studentService;
    @Autowired
    private HttpServletRequest httpServletRequest;

    @PayloadRoot(namespace = STUDENT_NAMESPACE_URI, localPart = "getStudentByIdRequest")
    @ResponsePayload
    public GetStudentByIdResponse getStudentById(@RequestPayload GetStudentByIdRequest request) {
        GetStudentByIdResponse response = new GetStudentByIdResponse();
        StudentEntity studentEntity =  studentService.getStudentById(request.getStudentId());
        Student student = new Student();
        BeanUtils.copyProperties(studentEntity, student);
        response.setStudent(student);
        return response;
    }

    @PayloadRoot(namespace = STUDENT_NAMESPACE_URI, localPart = "getAllStudentRequest")
    @ResponsePayload
    public GetAllStudentResponse getAllStudents(@RequestPayload GetAllStudentRequest request) {
        GetAllStudentResponse response = new GetAllStudentResponse();
        List<Student> studentList = new ArrayList<>();
        List<StudentEntity> studentEntityList =  studentService.getAllStudents();
        for (StudentEntity stu : studentEntityList) {
            Student student = new Student();
            BeanUtils.copyProperties(stu, student);
            studentList.add(student);
        }
        response.getStudent().addAll(studentList);
        return response;
    }

    @PayloadRoot(namespace = STUDENT_NAMESPACE_URI, localPart = "addStudentRequest")
    @ResponsePayload
    public AddStudentResponse addStudent(@RequestPayload AddStudentRequest request) {
        AddStudentResponse response = new AddStudentResponse();
        Student newStudent = new Student();
        ServiceStatus serviceStatus = new ServiceStatus();

        StudentEntity newStudentEntity = new StudentEntity();
        newStudentEntity.setName(request.getName());
        newStudentEntity.setDob(request.getDob());
        newStudentEntity.setEmail(request.getEmail());
        newStudentEntity.setAddress(request.getAddress());
        newStudentEntity.setCourse(request.getCourse());
        newStudentEntity.setIp(request.getIp());
        newStudentEntity.setContact(request.getContact());
        StudentEntity savedStudentEntity = studentService.addStudent(newStudentEntity);

        if (savedStudentEntity == null) {
            serviceStatus.setStatusCode("CONFLICT");
            serviceStatus.setMessage("Exception while adding Entity");
        }
        else {
            BeanUtils.copyProperties(savedStudentEntity, newStudent);
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("New Student added Successfully!!!");
        }
        response.setStudent(newStudent);
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = STUDENT_NAMESPACE_URI, localPart = "updateStudentRequest")
    @ResponsePayload
    public UpdateStudentResponse updateStudent(@RequestPayload UpdateStudentRequest request) {
        UpdateStudentResponse response = new UpdateStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();
        StudentEntity studentDB = studentService.getStudentByName(request.getName());

        if (studentDB == null) {
            serviceStatus.setStatusCode("NOT FOUND");
            serviceStatus.setMessage("Student with named: " + request.getName() + " not found!!!");
        }
        else {
            studentDB.setName(request.getName());
            studentDB.setDob(request.getDob());
            studentDB.setEmail(request.getEmail());
            studentDB.setAddress(request.getAddress());
            studentDB.setCourse(request.getCourse());
            studentDB.setIp(request.getIp());
            studentDB.setContact(request.getContact());

            boolean flag = studentService.updateStudent(studentDB);

            if (!flag) {
                serviceStatus.setStatusCode("CONFLICT");
                serviceStatus.setMessage("Exception while adding Entity" + request.getName());
            }
            else {
                serviceStatus.setStatusCode("SUCCESS");
                serviceStatus.setMessage("Student updated Successfully!!!");
            }
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }

    @PayloadRoot(namespace = STUDENT_NAMESPACE_URI, localPart = "deleteStudentRequest")
    @ResponsePayload
    public DeleteStudentResponse deleteMovie(@RequestPayload DeleteStudentRequest request) {
        DeleteStudentResponse response = new DeleteStudentResponse();
        ServiceStatus serviceStatus = new ServiceStatus();

        boolean flag = studentService.deleteStudentById(request.getStudentId());

        if (!flag) {
            serviceStatus.setStatusCode("FAIL");
            serviceStatus.setMessage("Exception while delete Entity id= " + request.getStudentId());
        } else {
            serviceStatus.setStatusCode("SUCCESS");
            serviceStatus.setMessage("Student Deleted Successfully");
        }
        response.setServiceStatus(serviceStatus);
        return response;
    }

    protected String getIpAddress() {
        String ipAddress = httpServletRequest.getHeader("X-FORWARDED-FOR");
        if (ipAddress == null) {
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        return ipAddress;
    }

}
