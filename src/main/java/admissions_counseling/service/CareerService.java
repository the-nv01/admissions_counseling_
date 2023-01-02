package admissions_counseling.service;

import admissions_counseling.model.Career;

import java.util.List;

public interface CareerService {
    List<Career> getAllCareer();

    List<Career> getCareerByTypeId(Integer typeId);

    Career getCareerById(Integer careerId);
}
