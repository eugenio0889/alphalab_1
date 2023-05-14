package by.strigo.alphalab.service.impl;

import by.strigo.alphalab.model.Person;
import by.strigo.alphalab.repository.PersonRepository;
import by.strigo.alphalab.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Override
    @Transactional(readOnly = true)
    public void printMatching() {
        personRepository.findAllWhereDocumentNumberLikeAndActiveTrue("777")
                .forEach(System.out::println);
    }

    @Override
    @Transactional
    public void saveAll(List<Person> persons) {
        personRepository.saveAll(persons);
    }
}
