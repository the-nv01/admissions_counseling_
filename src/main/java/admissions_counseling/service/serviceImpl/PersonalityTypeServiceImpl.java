package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.PersonalityType;
import admissions_counseling.repository.PersonalityTypeRepository;
import admissions_counseling.service.PersonalityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalityTypeServiceImpl implements PersonalityTypeService {

    @Autowired
    PersonalityTypeRepository personalityTypeRepository;

    @Override
    public List<PersonalityType> getAllPersonalityType() {
        return personalityTypeRepository.findAllBy();
    }
}
