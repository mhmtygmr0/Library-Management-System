package dev.patika.library.api;

import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    private final CategoryService categoryService;
    private final IModelMapperService modelMapperService;

    public CategoryController(CategoryService categoryService, IModelMapperService modelMapperService) {
        this.categoryService = categoryService;
        this.modelMapperService = modelMapperService;
    }
}
