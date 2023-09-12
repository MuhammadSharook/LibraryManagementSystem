package com.example.librarymanagementsystem.Repository;

import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findByGenre(Genre genre);
    List<Book> findByGenreAndCost(Genre genre,double cost);
}
