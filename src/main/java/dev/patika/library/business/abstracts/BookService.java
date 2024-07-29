package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Book;
import org.springframework.data.domain.Page;

public interface BookService {
    Book get(int id);

    Page<Book> cursor(int page, int pageSize);

    Book save(Book book);

    Book update(Book book);

    boolean delete(int id);
}
