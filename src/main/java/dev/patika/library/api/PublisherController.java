package dev.patika.library.api;

import dev.patika.library.business.abstracts.PublisherService;
import dev.patika.library.core.config.modelMapper.IModelMapperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/publishers")
public class PublisherController {
    private final PublisherService publisherService;
    private final IModelMapperService modelMapperService;

    public PublisherController(PublisherService publisherService, IModelMapperService modelMapperService) {
        this.publisherService = publisherService;
        this.modelMapperService = modelMapperService;
    }
}
