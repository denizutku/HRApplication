package deniz.spring.hrapp.controllers;

import deniz.spring.hrapp.models.Applicant;
import deniz.spring.hrapp.models.Job;
import deniz.spring.hrapp.services.ApplicantService;
import deniz.spring.hrapp.services.FileService;
import deniz.spring.hrapp.services.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Controller
class JobController {

    private final JobService jobService;

    private final ApplicantService applicantService;

    private final FileService fileService;

    JobController(JobService jobService, ApplicantService applicantService, FileService fileService) {
        this.jobService = jobService;
        this.applicantService = applicantService;
        this.fileService = fileService;
    }

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
    String deleteJob(@PathVariable(name = "id") Long id) {
        jobService.deleteJob(id);
        return "redirect:/jobs";
    }

    @GetMapping("/job/{id}")
    String detailsJob(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("jobDetail",jobService.get(id));
        Applicant newApplication = new Applicant();
        model.addAttribute("newApplication", newApplication);
        return "job";
    }

    @GetMapping("/applications")
    String listApplications(Model model) {
        List<Applicant> listApplications = applicantService.listApplication();
        model.addAttribute("listApplications", listApplications);
        return "applications";
    }

    @PostMapping(value = "/saveapplication")
    String saveJob(Applicant applicant, @RequestPart("cv") MultipartFile multipartFile) {
        applicantService.saveApplication(applicant);
        fileService.uploadFile(multipartFile);
        return "redirect:/jobs";
    }


}
