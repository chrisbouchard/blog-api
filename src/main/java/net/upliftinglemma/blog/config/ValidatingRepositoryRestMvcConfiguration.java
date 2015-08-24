package net.upliftinglemma.blog.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.rest.SpringBootRepositoryRestMvcConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.event.ValidatingRepositoryEventListener;
import org.springframework.validation.Validator;

@Configuration
public class ValidatingRepositoryRestMvcConfiguration extends SpringBootRepositoryRestMvcConfiguration {
    
    private final Validator validator;
    
    @Autowired
    public ValidatingRepositoryRestMvcConfiguration(final Validator validator) {
        this.validator = validator;
    }
    
    @Override
    protected void configureValidatingRepositoryEventListener(final ValidatingRepositoryEventListener listener) {
        super.configureValidatingRepositoryEventListener(listener);

        listener.addValidator("beforeCreate", validator);
        listener.addValidator("beforeSave", validator);
    }

}
