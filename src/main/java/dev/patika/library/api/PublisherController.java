package dev.patika.library.api;

import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import dev.patika.library.core.result.Result;
import dev.patika.library.core.result.ResultData;
import dev.patika.library.core.utilies.ResultHelper;
import dev.patika.library.dto.request.publisher.PublisherSaveRequest;
import dev.patika.library.dto.request.publisher.PublisherUpdateRequest;
import dev.patika.library.dto.response.CursorResponse;
import dev.patika.library.dto.response.PublisherResponse;
import dev.patika.library.entities.Publisher;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;
    private final IModelMapperService modelMapper;

    public PublisherController(PublisherService publisherService, IModelMapperService modelMapper) {
        this.publisherService = publisherService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> get(@PathVariable("id") int id) {
        Publisher publisher = this.publisherService.get(id);
        return ResultHelper.success(this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<CursorResponse<PublisherResponse>> cursor(
            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
            @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize
    ) {
        Page<Publisher> publisherPage = this.publisherService.cursor(page, pageSize);
        Page<PublisherResponse> publisherResponsePage = publisherPage.map(publisher -> this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
        return ResultHelper.cursor(publisherResponsePage);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResultData<PublisherResponse> save(@Valid @RequestBody PublisherSaveRequest publisherSaveRequest) {
        Publisher publisher = this.modelMapper.forRequest().map(publisherSaveRequest, Publisher.class);
        this.publisherService.save(publisher);
        return ResultHelper.created(this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public ResultData<PublisherResponse> update(@Valid @RequestBody PublisherUpdateRequest publisherUpdateRequest) {
        Publisher publisher = this.modelMapper.forRequest().map(publisherUpdateRequest, Publisher.class);
        this.publisherService.update(publisher);
        return ResultHelper.success(this.modelMapper.forResponse().map(publisher, PublisherResponse.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Result delete(@PathVariable("id") int id) {
        this.publisherService.delete(id);
        return ResultHelper.ok();
    }
}
