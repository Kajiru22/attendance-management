package attendance.management.tracker.runner;

import attendance.management.tracker.presistance.domain.Person;
import attendance.management.tracker.presistance.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ConfigurationProperties("admin")
public class DefaultUserRunner {
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }

    @Bean
    ApplicationRunner prepareUsers(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (!personRepository.existsByUsername(person.getUsername())) {
                person.setPassword(passwordEncoder.encode(person.getPassword()));
                person.setAuthorities(person.getAuthorities());
                personRepository.save(person);
            }
        };
    }
}