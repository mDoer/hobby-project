package mdoe.hobbyproject.configuration;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class BeanConfig {

    @Bean
    public StrongPasswordEncryptor strongEncryptor() {
        StrongPasswordEncryptor encryptor;
        encryptor = new StrongPasswordEncryptor();
        return encryptor;
    }
}
