package ua.kpi.library_lab2.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(unique = true)
    private String isbn;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

    private String ageCategory;

    public Book() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public Author getAuthor() { return author; }
    public void setAuthor(Author author) { this.author = author; }
    public String getAgeCategory() {return ageCategory;}
    public void setAgeCategory(String ageCategory) {this.ageCategory = ageCategory;}
}