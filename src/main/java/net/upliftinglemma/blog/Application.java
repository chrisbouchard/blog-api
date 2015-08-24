package net.upliftinglemma.blog;

import net.upliftinglemma.blog.config.SpringConfig;
import net.upliftinglemma.blog.config.ValidatingRepositoryRestMvcConfiguration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({SpringConfig.class, ValidatingRepositoryRestMvcConfiguration.class})
public class Application extends SpringBootServletInitializer {

    public static void main(final String... args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }

}
