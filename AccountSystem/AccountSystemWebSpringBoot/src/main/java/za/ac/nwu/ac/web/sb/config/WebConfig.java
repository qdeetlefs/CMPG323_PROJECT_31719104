package za.ac.nwu.ac.web.sb.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import za.ac.nwu.ac.logic.config.LogicConfig;

@Import({LogicConfig.class})
@Configuration
@ComponentScan(basePackages = {
        "za.ac.nwu.ac.web.sb.controller"
})
public class WebConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);


}
