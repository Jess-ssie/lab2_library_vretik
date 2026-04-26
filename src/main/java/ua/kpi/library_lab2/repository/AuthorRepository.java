package ua.kpi.library_lab2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.kpi.library_lab2.entity.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}