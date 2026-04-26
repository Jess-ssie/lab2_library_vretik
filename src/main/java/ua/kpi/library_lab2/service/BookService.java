package ua.kpi.library_lab2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.kpi.library_lab2.entity.Book;
import ua.kpi.library_lab2.repository.BookRepository;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public void saveBook(Book book) {
        bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }
}