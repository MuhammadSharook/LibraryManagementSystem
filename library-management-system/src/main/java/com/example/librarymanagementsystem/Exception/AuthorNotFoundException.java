package com.example.librarymanagementsystem.Exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message)
    {
        super(message);
    }
}
