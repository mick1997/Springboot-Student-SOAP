//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.0 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.04.05 at 01:00:50 AM EDT 
//


package com.snva.ex.soap.xml.student;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.snva.ex.soap.xml.student package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.snva.ex.soap.xml.student
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetStudentByIdRequest }
     * 
     */
    public GetStudentByIdRequest createGetStudentByIdRequest() {
        return new GetStudentByIdRequest();
    }

    /**
     * Create an instance of {@link GetStudentByIdResponse }
     * 
     */
    public GetStudentByIdResponse createGetStudentByIdResponse() {
        return new GetStudentByIdResponse();
    }

    /**
     * Create an instance of {@link Student }
     * 
     */
    public Student createStudent() {
        return new Student();
    }

    /**
     * Create an instance of {@link AddStudentRequest }
     * 
     */
    public AddStudentRequest createAddStudentRequest() {
        return new AddStudentRequest();
    }

    /**
     * Create an instance of {@link AddStudentResponse }
     * 
     */
    public AddStudentResponse createAddStudentResponse() {
        return new AddStudentResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link GetAllStudentRequest }
     * 
     */
    public GetAllStudentRequest createGetAllStudentRequest() {
        return new GetAllStudentRequest();
    }

    /**
     * Create an instance of {@link GetAllStudentResponse }
     * 
     */
    public GetAllStudentResponse createGetAllStudentResponse() {
        return new GetAllStudentResponse();
    }

    /**
     * Create an instance of {@link UpdateStudentRequest }
     * 
     */
    public UpdateStudentRequest createUpdateStudentRequest() {
        return new UpdateStudentRequest();
    }

    /**
     * Create an instance of {@link UpdateStudentResponse }
     * 
     */
    public UpdateStudentResponse createUpdateStudentResponse() {
        return new UpdateStudentResponse();
    }

    /**
     * Create an instance of {@link DeleteStudentRequest }
     * 
     */
    public DeleteStudentRequest createDeleteStudentRequest() {
        return new DeleteStudentRequest();
    }

    /**
     * Create an instance of {@link DeleteStudentResponse }
     * 
     */
    public DeleteStudentResponse createDeleteStudentResponse() {
        return new DeleteStudentResponse();
    }

}
