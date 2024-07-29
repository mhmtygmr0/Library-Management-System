package dev.patika.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "authors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id", unique = true)
    private int id;

    @Column(name = "author_name")
    private String name;

    @Column(name = "author_birthDate")
    private int birthDate;

    @Column(name = "author_country")
    private String country;

    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE)
    private List<Book> books;
}
