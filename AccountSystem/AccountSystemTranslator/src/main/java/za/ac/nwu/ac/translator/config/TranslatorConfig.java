package za.ac.nwu.ac.translator.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.repo.config.RepositoryConfig;

@Import({RepositoryConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.translator"
})
public class TranslatorConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(TranslatorConfig.class);
}
