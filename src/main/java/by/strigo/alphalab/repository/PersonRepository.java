package by.strigo.alphalab.repository;

import by.strigo.alphalab.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    @Query("SELECT DISTINCT p FROM Person p JOIN FETCH p.documents d WHERE d.number LIKE %:stringToMatch% ")
    List<Person> findAllWhereDocumentNumberLikeAndActiveTrue(@Param("stringToMatch") String stringToMatch);

}
