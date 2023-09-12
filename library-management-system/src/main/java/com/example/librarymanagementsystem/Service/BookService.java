package com.example.librarymanagementsystem.Service;

import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.Exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.Exception.BookNotFoundException;
import com.example.librarymanagementsystem.Model.Author;
import com.example.librarymanagementsystem.Model.Book;
import com.example.librarymanagementsystem.Repository.AuthorRepository;
import com.example.librarymanagementsystem.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public String addBook(Book book) {
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if(authorOptional.isEmpty())
        {
            throw new AuthorNotFoundException("Invalid author id!!");
        }

        Author author = authorOptional.get();
        author.getBooks().add(book);
        authorRepository.save(author);
        return "Successfully added!!";
    }

    public String deleteBook(int id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if(bookOptional.isEmpty())
        {
            throw new BookNotFoundException("Invalid book id!!");
        }

        Book book = bookOptional.get();
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        Author author = authorOptional.get();
        author.getBooks().remove(book);
        bookRepository.deleteById(id);
        return "Successfully deleted!!!";
    }

    public List<Book> getBooksbyGenre(Genre genre) {
        return bookRepository.findByGenre(genre);
    }

    public List<Book> getBooksbyGenreAndCost(Genre genre, double cost) {
        return bookRepository.findByGenreAndCost(genre,cost);
    }
}
