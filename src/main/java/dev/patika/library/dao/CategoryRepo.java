package dev.patika.library.dao;

import dev.patika.library.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
    @Query("SELECT c FROM Category c WHERE c.id IN :categoryId")
    List<Category> findByCategoryId(@Param("categoryId") List<Integer> categoryId);
}
