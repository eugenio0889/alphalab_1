package by.strigo.alphalab.service;

import by.strigo.alphalab.model.Person;

import java.util.List;

public interface PersonService {

    void printMatching();

    void saveAll(List<Person> persons);
}
