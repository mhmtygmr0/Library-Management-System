package dev.patika.library.core.config.modelMapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for configuring and providing ModelMapper instances for
 * mapping objects in the application. It implements the IModelMapperService
 * interface and provides different configurations for request and response mappings.
 */
@Service
public class ModelManagerService implements IModelMapperService {

    private final ModelMapper modelMapper;

    /**
     * Constructs a ModelManagerService with the provided ModelMapper instance.
     *
     * @param modelMapper the ModelMapper instance to be used for object mappings
     */
    @Autowired
    public ModelManagerService(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public ModelMapper forRequest() {
        ModelMapper requestMapper = new ModelMapper();
        requestMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.STANDARD);
        return requestMapper;
    }

    @Override
    public ModelMapper forResponse() {
        ModelMapper responseMapper = new ModelMapper();
        responseMapper.getConfiguration()
                .setAmbiguityIgnored(true)
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        return responseMapper;
    }
}
