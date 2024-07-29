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
@Table(name = "publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", unique = true)
    private int id;

    @Column(name = "publisher_name")
    private String name;

    @Column(name = "establishment_year")
    private int establishmentYear;

    @Column(name = "publisher_address")
    private String address;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> books;
}
