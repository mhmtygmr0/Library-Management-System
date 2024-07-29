package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Category;
import org.springframework.data.domain.Page;

public interface CategoryService {
    Category get(int id);

    Page<Category> cursor(int page, int pageSize);

    Category save(Category category);

    Category update(Category category);

    boolean delete(int id);
}
