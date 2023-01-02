package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.University;
import admissions_counseling.repository.UniversityRepository;
import admissions_counseling.service.UniversityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;

    @Override
    public List<University> getAllUniversity() {
        return universityRepository.findAllBy();
    }

    @Override
    public List<University> getUniversityByCareerId(Integer careerId) {
        return universityRepository.findAllByCareerId(careerId);
    }
}
