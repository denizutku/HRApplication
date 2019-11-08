package deniz.spring.hrapp.controllers;

import deniz.spring.hrapp.models.Job;
import deniz.spring.hrapp.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;


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
}
