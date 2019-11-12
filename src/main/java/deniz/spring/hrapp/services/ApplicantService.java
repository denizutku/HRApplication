package deniz.spring.hrapp.services;

import deniz.spring.hrapp.models.Applicant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplicantService {

    @Autowired
    private ApplicantRepository applicantRepository;

    public List<Applicant> listApplication() {
        return applicantRepository.findAll();
    }

    public void saveApplication(Applicant applicant){
        applicantRepository.save(applicant);
    }

    public void deleteApplication(Long id) {
        applicantRepository.deleteById(id);
    }

    public Applicant get(Long id) {
        return applicantRepository.findById(id).get();
    }

}
