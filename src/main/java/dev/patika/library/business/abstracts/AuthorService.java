package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Author;
import org.springframework.data.domain.Page;

public interface AuthorService {
    Author get(int id);

    Page<Author> cursor(int page, int pageSize);

    Author save(Author author);

    Author update(Author author);

    boolean delete(int id);
}
