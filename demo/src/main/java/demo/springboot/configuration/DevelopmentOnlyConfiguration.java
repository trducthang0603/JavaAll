package demo.springboot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
@Profile("dev")
 class DevelopmentOnlyConfiguration {
    @Bean
    public String dummy() {
        return "something";
    }
}
