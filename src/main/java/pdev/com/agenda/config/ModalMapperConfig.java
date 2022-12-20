package pdev.com.agenda.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModalMapperConfig {
    // com o bean o spring ja sabe como trabalhar com essa config e fazer a injecao de dependencias
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
