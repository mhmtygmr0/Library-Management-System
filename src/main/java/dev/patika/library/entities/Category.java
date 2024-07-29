package dev.patika.library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id", unique = true)
    private int id;

    @Column(name = "category_name")
    private String name;

    @Column(name = "category_description")
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Book> books;
}
