package admissions_counseling.service;

import admissions_counseling.model.University;

import java.util.List;

public interface UniversityService {
    List<University> getAllUniversity();

    public List<University> getUniversityByCareerId(Integer careerId);
}
