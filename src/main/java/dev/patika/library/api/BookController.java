package dev.patika.library.api;

import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;
    private final IModelMapperService modelMapperService;

    public BookController(BookService bookService, IModelMapperService modelMapperService) {
        this.bookService = bookService;
        this.modelMapperService = modelMapperService;
    }
}
