package admissions_counseling.repository;

import admissions_counseling.model.Career;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Question, Integer> {
    List<Career> findAllBy();
}
