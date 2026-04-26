package ua.kpi.library_lab2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.kpi.library_lab2.entity.Book;
import ua.kpi.library_lab2.service.AuthorService;
import ua.kpi.library_lab2.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @GetMapping("/books")
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "mainPage";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "bookForm";
    }

    @PostMapping("/save")
    public String saveBook(@ModelAttribute("book") Book book, Model model) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (org.springframework.dao.DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", "Помилка: Книга з таким ISBN вже існує.");
            model.addAttribute("authors", authorService.getAllAuthors());
            return "bookForm";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "bookForm";
    }
}