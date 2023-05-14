package by.strigo.alphalab.util;

import by.strigo.alphalab.model.Document;
import by.strigo.alphalab.model.Person;
import by.strigo.alphalab.model.constant.Sex;
import lombok.experimental.UtilityClass;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static by.strigo.alphalab.util.DocumentUtil.*;

@UtilityClass
public class PersonUtil {

    public void addDocument(Person person, Document document) {
        person.getDocuments().add(document);
        document.setPerson(person);
    }

    public void addDocuments(Person person, List<Document> documents) {
        documents
                .forEach(doc -> {
                    person.getDocuments().add(doc);
                    doc.setPerson(person);
                });
    }

    public static List<Person> generateListWithThreeMatching() {
        List<Person> persons = new ArrayList<>();

        persons.add(generateMatchingPerson());

        persons.add(generateNonMatchingPerson());
        persons.add(generateNonMatchingPerson());
        persons.add(generateNonMatchingPerson());

        persons.add(generateMatchingPerson());

        persons.add(generateNonMatchingPerson());
        persons.add(generateNonMatchingPerson());
        persons.add(generateNonMatchingPerson());

        persons.add(generateMatchingPerson());

        return persons;
    }

    private static Person generateMatchingPerson() {
        Person person = generatePersonWithoutDocuments();
        PersonUtil.addDocuments(person, generateSomeRandomDocsWhereOneHasMatchingNumberAndActiveStatus());

        return person;
    }

    private static Person generateNonMatchingPerson() {
        Person person = generatePersonWithoutDocuments();
        PersonUtil.addDocuments(person, generateSomeRandomDocsWithoutMatching());

        return person;
    }

    private static Person generatePersonWithoutDocuments() {
        Person person = new Person();

        person.setIin(RandomUtil.generateRandomLong());
        person.setFirstName(RandomUtil.generateRandomString());
        person.setLastName(RandomUtil.generateRandomString());
        person.setDateOfBirth(new Date(1_000_000));
        person.setSex(Sex.MALE);

        return person;
    }

}
