package by.strigo.alphalab;

import by.strigo.alphalab.service.PersonService;
import by.strigo.alphalab.util.PersonUtil;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Profile("!TEST")
public class CommandLineTaskExecutor implements CommandLineRunner {

    private final PersonService personService;

    @Override
    public void run(String... args) throws Exception {
        personService.saveAll(PersonUtil.generateListWithThreeMatching());
        personService.printMatching();
    }
}
