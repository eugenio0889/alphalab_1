package by.strigo.alphalab;

import by.strigo.alphalab.model.Person;
import by.strigo.alphalab.repository.PersonRepository;
import by.strigo.alphalab.util.PersonUtil;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@Transactional
@ActiveProfiles("TEST")
class PersonRepositoryTest {

    @Autowired
    private PersonRepository personRepository;

    private static final String IMAGE_VERSION =
            "postgres@sha256:c06405f9394f2be49ba284304758c50a26770c1fe3d4bcce5ed877e617a3b137";

    @Container
    public static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer(IMAGE_VERSION)
            .withDatabaseName("alphalab")
            .withUsername("postgres")
            .withPassword("postgres");

    @DynamicPropertySource
    static void registerPgProperties(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",
                () -> String.format("jdbc:postgresql://localhost:%d/alphalab", postgreSQLContainer.getFirstMappedPort()));
        registry.add("spring.datasource.username", () -> "postgres");
        registry.add("spring.datasource.password", () -> "postgres");
    }

    @BeforeAll
    public static void start() {
        postgreSQLContainer.start();
    }

    @AfterAll
    public static void stop() {
        postgreSQLContainer.stop();
    }

    @BeforeEach
    public void initData() {
        personRepository.saveAll(PersonUtil.generateListWithThreeMatching());
    }

    @Test
    public void Verify_if_there_is_only_three_matching_person() {
//        when:
        System.out.println("CIAO" + personRepository.findAll().size());
        List<Person> persons = personRepository.findAllWhereDocumentNumberLikeAndActiveTrue("777");

//        then:
        Assertions.assertEquals(3, persons.size());
    }

}
