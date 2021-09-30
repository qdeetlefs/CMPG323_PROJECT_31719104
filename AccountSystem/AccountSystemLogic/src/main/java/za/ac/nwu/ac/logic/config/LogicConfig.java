package za.ac.nwu.ac.logic.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.translator.config.TranslatorConfig;

@Import({TranslatorConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.logic.flow"
})
public class LogicConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogicConfig.class);
}
