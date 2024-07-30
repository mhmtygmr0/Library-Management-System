package dev.patika.library.api;

import dev.patika.library.business.abstracts.AuthorService;
import dev.patika.library.business.abstracts.BookService;
import dev.patika.library.business.abstracts.CategoryService;
import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import dev.patika.library.core.exception.NotFoundException;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilies.Msg;
import dev.patika.library.core.utilies.ResultHelper;
import dev.patika.library.dto.request.book.BookSaveRequest;
import dev.patika.library.dto.request.book.BookUpdateRequest;
import dev.patika.library.dto.response.BookResponse;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.entities.Author;
import dev.patika.library.entities.Book;
import dev.patika.library.entities.Category;
import dev.patika.library.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/v1/books")
public class BookController {
    private final BookService bookService;
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final IModelMapperService modelMapper;

    public BookController(BookService bookService, CategoryService categoryService, AuthorService authorService, PublisherService publisherService, IModelMapperService modelMapper) {
        this.bookService = bookService;
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> get(@PathVariable("id") int id) {
        Book book = this.bookService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(book, BookResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<BookResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Book> bookPage = this.bookService.cursor(page, pageSize);
        Page<BookResponse> bookResponsePage = bookPage.map(book -> this.modelMapper.forResponse().map(book, BookResponse.class));
        return ResultHelper.cursor(bookResponsePage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<BookResponse> save(@Valid @RequestBody BookSaveRequest bookSaveRequest) {
        Book book = this.modelMapper.forRequest().map(bookSaveRequest, Book.class);

        List<Category> categories = this.categoryService.get(bookSaveRequest.getCategoryId());
        if (categories.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setCategories(categories);

        Author author = this.authorService.get(bookSaveRequest.getAuthorId());
        if (author == null) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookSaveRequest.getPublisherId());
        if (publisher == null) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setPublisher(publisher);

        Book savedBook = this.bookService.save(book);

        return ResultHelper.created(this.modelMapper.forResponse().map(savedBook, BookResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<BookResponse> update(@Valid @RequestBody BookUpdateRequest bookUpdateRequest) {
        Book book = this.modelMapper.forRequest().map(bookUpdateRequest, Book.class);
        List<Category> categories = this.categoryService.get(bookUpdateRequest.getCategoryId());
        if (categories.isEmpty()) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setCategories(categories);

        Author author = this.authorService.get(bookUpdateRequest.getAuthorId());
        if (author == null) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setAuthor(author);

        Publisher publisher = this.publisherService.get(bookUpdateRequest.getPublisherId());
        if (publisher == null) {
            throw new NotFoundException(Msg.NOT_FOUND);
        }
        book.setPublisher(publisher);
        this.bookService.update(book);
        return ResultHelper.success(this.modelMapper.forResponse().map(book, BookResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.bookService.delete(id);
        return ResultHelper.ok();
    }
}
