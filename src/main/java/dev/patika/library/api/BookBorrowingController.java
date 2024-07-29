package dev.patika.library.api;

import dev.patika.library.business.abstracts.BookBorrowingService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/borrowings")
public class BookBorrowingController {
    private final BookBorrowingService borrowingService;
    private final IModelMapperService modelMapperService;

    public BookBorrowingController(BookBorrowingService borrowingService, IModelMapperService modelMapperService) {
        this.borrowingService = borrowingService;
        this.modelMapperService = modelMapperService;
    }
}
