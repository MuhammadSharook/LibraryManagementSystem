package com.example.librarymanagementsystem.Controller;

import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.Model.Book;
import com.example.librarymanagementsystem.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add-book")
    public String addBook(@RequestBody Book book)
    {
        try {
            String response = bookService.addBook(book);
            return response;
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") int id)
    {
        try {
            String response = bookService.deleteBook(id);
            return response;
        }
        catch (Exception e)
        {
            return e.getMessage();
        }
    }

    @GetMapping("/bookbygenre")
    public List<Book> getBooksbyGenre(@RequestParam("genre") Genre genre)
    {
        List<Book> ans = bookService.getBooksbyGenre(genre);
        return ans;
    }

    @GetMapping("/booksbygenreandcost")
    public List<Book> getBooksbyGenreAndCost(@RequestParam("genre") Genre genre,@RequestParam("cost") double cost)
    {
        List<Book> ans = bookService.getBooksbyGenreAndCost(genre,cost);
        return ans;
    }
}
