package admissions_counseling.repository;

import admissions_counseling.model.AdmissionScore;
import admissions_counseling.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdmissionScoreRepository extends JpaRepository<AdmissionScore, Integer> {
    List<AdmissionScore> findAllBy();

    List<AdmissionScore> findAllByUniversityIdAndBlockId(Integer universityId, Integer blockId);
}
