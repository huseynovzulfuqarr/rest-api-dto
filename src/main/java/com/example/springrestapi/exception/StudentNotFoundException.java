package com.example.springrestapi.exception;

public class StudentNotFoundException extends RuntimeException{

    private static final String MESSAGE="STUDENT nOT FOUND";

    public StudentNotFoundException(){
        super(MESSAGE);
    }
}
