package ua.kpi.library_lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.library_lab2.entity.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
}