package dev.patika.library.api;

import dev.patika.library.business.abstracts.AuthorService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilies.ResultHelper;
import dev.patika.library.dto.request.author.AuthorSaveRequest;
import dev.patika.library.dto.request.author.AuthorUpdateRequest;
import dev.patika.library.dto.response.AuthorResponse;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.entities.Author;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/authors")
public class AuthorController {
    private final AuthorService authorService;
    private final IModelMapperService modelMapper;

    public AuthorController(AuthorService authorService, IModelMapperService modelMapper) {
        this.authorService = authorService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> get(@PathVariable("id") int id) {
        Author author = this.authorService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(author, AuthorResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<AuthorResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Author> customerPage = this.authorService.cursor(page, pageSize);
        Page<AuthorResponse> authorResponsePage = customerPage.map(author -> this.modelMapper.forResponse().map(author, AuthorResponse.class));
        return ResultHelper.cursor(authorResponsePage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<AuthorResponse> save(@Valid @RequestBody AuthorSaveRequest authorSaveRequest) {
        Author author = this.modelMapper.forRequest().map(authorSaveRequest, Author.class);
        this.authorService.save(author);
        return ResultHelper.created(this.modelMapper.forResponse().map(author, AuthorResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<AuthorResponse> update(@Valid @RequestBody AuthorUpdateRequest authorUpdateRequest) {
        Author author = this.modelMapper.forRequest().map(authorUpdateRequest, Author.class);
        this.authorService.update(author);
        return ResultHelper.success(this.modelMapper.forResponse().map(author, AuthorResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.authorService.delete(id);
        return ResultHelper.ok();
    }
}
