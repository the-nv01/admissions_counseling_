package admissions_counseling.service.serviceImpl;

import admissions_counseling.model.PersionalityType;
import admissions_counseling.repository.PersionalityTypeRepository;
import admissions_counseling.service.PersionalityTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersionalityTypeServiceImpl implements PersionalityTypeService {

    @Autowired
    PersionalityTypeRepository persionalityTypeRepository;

    @Override
    public List<PersionalityType> getAllPersionalityType() {
        return persionalityTypeRepository.findAllBy();
    }
}
