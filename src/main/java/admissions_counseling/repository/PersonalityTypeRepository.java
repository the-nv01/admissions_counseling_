package admissions_counseling.repository;

import admissions_counseling.model.PersonalityType;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonalityTypeRepository extends JpaRepository<PersonalityType, Integer> {
    List<PersonalityType> findAllBy();
}
