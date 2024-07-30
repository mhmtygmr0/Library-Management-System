package dev.patika.library.api;

import dev.patika.library.business.abstracts.BookBorrowingService;
import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilies.ResultHelper;
import dev.patika.library.dto.request.borrowing.BorrowingSaveRequest;
import dev.patika.library.dto.request.borrowing.BorrowingUpdateRequest;
import dev.patika.library.dto.response.BookBorrowingResponse;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.BookBorrowing;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/borrowings")
public class BookBorrowingController {
    private final BookBorrowingService borrowingService;
    private final BookService bookService;
    private final IModelMapperService modelMapper;

    public BookBorrowingController(BookBorrowingService borrowingService, BookService bookService, IModelMapperService modelMapper) {
        this.borrowingService = borrowingService;
        this.bookService = bookService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> get(@PathVariable("id") int id) {
        BookBorrowing borrowing = this.borrowingService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(borrowing, BookBorrowingResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookBorrowingResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<BookBorrowing> borrowingPage = this.borrowingService.cursor(page, pageSize);
        Page<BookBorrowingResponse> borrowingResponsePage = borrowingPage.map(borrowing -> this.modelMapper.forResponse().map(borrowing, BookBorrowingResponse.class));
        return ResultHelper.cursor(borrowingResponsePage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookBorrowingResponse> save(@Valid @RequestBody BorrowingSaveRequest borrowingSaveRequest) {
        BookBorrowing borrowing = this.modelMapper.forRequest().map(borrowingSaveRequest, BookBorrowing.class);
        Book book = this.bookService.get(borrowingSaveRequest.getBookId());
        borrowing.setBook(book);
        this.borrowingService.save(borrowing);
        return ResultHelper.created(this.modelMapper.forResponse().map(borrowing, BookBorrowingResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookBorrowingResponse> update(@Valid @RequestBody BorrowingUpdateRequest borrowingUpdateRequest) {
        BookBorrowing borrowing = this.modelMapper.forRequest().map(borrowingUpdateRequest, BookBorrowing.class);
        Book book = this.bookService.get(borrowingUpdateRequest.getBookId());
        borrowing.setBook(book);
        this.borrowingService.update(borrowing);
        return ResultHelper.success(this.modelMapper.forResponse().map(borrowing, BookBorrowingResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.borrowingService.delete(id);
        return ResultHelper.ok();
    }
}
