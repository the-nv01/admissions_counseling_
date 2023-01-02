package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.Career;
import admissions_counseling.repository.CareerRepository;
import admissions_counseling.service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CareerServiceImpl implements CareerService {
    @Autowired
    CareerRepository careerRepository;

    @Override
    public List<Career> getAllCareer() {
        return careerRepository.findAllBy();
    }
}
