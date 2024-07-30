package dev.patika.library.business.concretes;

import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.utilies.Msg;
import dev.patika.library.dao.CategoryRepo;
import dev.patika.library.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager implements CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryManager(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category get(Integer id) {
        return this.categoryRepo.findById(id).orElseThrow(() -> new NotFoundException(Msg.NOT_FOUND));
    }

    @Override
    public Page<Category> cursor(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize);
        return this.categoryRepo.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category update(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public boolean delete(int id) {
        Category category = this.get(id);
        this.categoryRepo.delete(category);
        return true;
    }

    @Override
    public List<Category> get(List<Integer> categoryId) {
        return this.categoryRepo.findAllById(categoryId);
    }
}
