package dev.patika.library.business.abstracts;

import dev.patika.library.entities.Category;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CategoryService {
    Category get(Integer id);

    Page<Category> cursor(int page, int pageSize);

    Category save(Category category);

    Category update(Category category);

    boolean delete(int id);

    List<Category> get(List<Integer> categoryId);
}
