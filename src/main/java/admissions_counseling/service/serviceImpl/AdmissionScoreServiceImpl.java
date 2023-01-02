package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.AdmissionScore;
import admissions_counseling.repository.AdmissionScoreRepository;
import admissions_counseling.service.AdmissionScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmissionScoreServiceImpl implements AdmissionScoreService {

    @Autowired
    AdmissionScoreRepository admissionScoreRepository;

    @Override
    public List<AdmissionScore> getAllAdmissionScore() {
        return admissionScoreRepository.findAllBy();
    }
}
