package deniz.spring.hrapp.controllers;

import deniz.spring.hrapp.models.Applicant;
import deniz.spring.hrapp.models.Job;
import deniz.spring.hrapp.services.ApplicantService;
import deniz.spring.hrapp.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private ApplicantService applicantService;


    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/jobs")
    public String listJobs(Model model) {
        List<Job> listJobs = jobService.listJobs();
        model.addAttribute("listJobs", listJobs);
        return "jobs";
    }

    @RequestMapping(value = "/savejob", method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("Job") Job Job) {
        jobService.saveJob(Job);
        return "redirect:/jobs";
    }

    @RequestMapping("/createjob")
    public String createJob(Model model){
        Job newJob = new Job();
        model.addAttribute("newJob", newJob);
        return "createjob";
    }

    @RequestMapping("/delete/{id}")
    public String deleteJob(@PathVariable(name = "id") Long id) {
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }

    @RequestMapping("/job/{id}")
    public String detailsJob(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("jobDetail",jobService.get(id));
        Applicant newApplication = new Applicant();
        model.addAttribute("newApplication", newApplication);
        return "job";
    }

    @RequestMapping("/applications")
    public String listApplications(Model model) {
        List<Applicant> listApplications = applicantService.listApplication();
        model.addAttribute("listApplications", listApplications);
        return "applications";
    }

    @RequestMapping(value = "/saveapplication", method = RequestMethod.POST)
    public String saveJob(@ModelAttribute("Applicant") Applicant Applicant) {
        applicantService.saveApplication(Applicant);
        return "redirect:/applications";
    }

}
