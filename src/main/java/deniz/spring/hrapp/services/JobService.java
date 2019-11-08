package deniz.spring.hrapp.services;

import deniz.spring.hrapp.models.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    public List<Job> listJobs() {
        return jobRepository.findAll();
    }

    public void saveJob(Job job){
        jobRepository.save(job);
    }

    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    public Job get(Long id) {
        return jobRepository.findById(id).get();
    }
}
