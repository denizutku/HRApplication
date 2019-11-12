package deniz.spring.hrapp.services;

import deniz.spring.hrapp.models.Applicant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicantRepository extends JpaRepository<Applicant, Long> {
}
