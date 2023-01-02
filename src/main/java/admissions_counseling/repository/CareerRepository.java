package admissions_counseling.repository;

import admissions_counseling.model.Career;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CareerRepository extends JpaRepository<Career, Integer> {
    List<Career> findAllBy();

    List<Career> findByTypeIdOrderByTypeIdAsc(Integer typeId);

    Career findByCareerId(Integer careerId);
}
