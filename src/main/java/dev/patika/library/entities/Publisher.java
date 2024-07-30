package dev.patika.library.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "publishers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "publisher_id", unique = true)
    private int id;

    @Column(name = "publisher_name", unique = true)
    private String name;

    @Column(name = "publisher_establishment_year")
    private LocalDate establishmentYear;

    @Column(name = "publisher_address")
    private String address;

    @JsonManagedReference
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.REMOVE)
    private List<Book> bookList;
}
