package admissions_counseling.repository;

import admissions_counseling.model.Question;
import admissions_counseling.model.University;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UniversityRepository extends JpaRepository<University, Integer> {
    List<University> findAllBy();

    List<University> findAllByCareerId(Integer careerId);
}