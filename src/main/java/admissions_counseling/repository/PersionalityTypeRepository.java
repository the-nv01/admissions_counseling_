package admissions_counseling.repository;

import admissions_counseling.model.PersionalityType;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersionalityTypeRepository extends JpaRepository<Question, Integer> {
    List<PersionalityType> findAllBy();
}
