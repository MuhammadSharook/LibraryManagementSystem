package com.example.librarymanagementsystem.Service;

import com.example.librarymanagementsystem.Model.Author;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;
    public String addAuthor(Author author) {
        Author responseAuthor  = authorRepository.save(author);
        return "Successfully added!!!";
    }
}
