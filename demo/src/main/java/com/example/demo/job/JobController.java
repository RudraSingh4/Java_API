package com.example.demo.job;
import datadog.trace.api.DDTags;
import datadog.trace.api.Trace;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpRequest;
import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;


    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    @Trace(operationName = "jobs.request")
    public ResponseEntity <List<Job>> findAll(){
        return ResponseEntity.ok (jobService.findAll());
        
    }

    @PostMapping
    public ResponseEntity<String> createJob (@RequestBody Job job){
        jobService.createJob(job);
        return new ResponseEntity<>( "Job added successfully",HttpStatus.OK);
    }
@GetMapping("/{id}")
public ResponseEntity<Job> getJobById(@PathVariable Long id) {
    Job job = jobService.getJobById(id);
    if (job != null) {
        return new ResponseEntity<> (job, HttpStatus.CREATED );
    }
//    for id where id is not mentioned
//    return new Job(1L, "TestJob", "TestJob", "2000", "3000", "loc");

//    for status

    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}

    @DeleteMapping("/jobs/{id}")
    public ResponseEntity <String> deleteJob(@PathVariable Long id){
        boolean deleted = jobService.deleteById(id);
        if (deleted)
            return new ResponseEntity<>("job deleted Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

//    @PutMapping("/jobs/{id}")
    //Use this method for all URL
    @RequestMapping(value = "/jobs/{id}",  method = RequestMethod.PUT)  // I can use this method for post,get,delete etc.
    public ResponseEntity <String> updateJob(@PathVariable Long id,
                                             @RequestBody Job updatedJob){
        boolean updated = jobService.updateJob(id, updatedJob);
        if(updated)
            return new ResponseEntity<>("job Updated Successfully",HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

}




/*
GET /jobs: Get all jobs
GET /jobs/{id}: Get a specific job by ID
POST /jobs: Create a new job (request body should contain the job details)
DELETE /jobs: Delete a specific job by ID
PUT /jobs/{id}: Update a specific job by ID (request body should contain the updated)
GET /jobs{id}/company: Get the company associated with a specific job  by id

Example API URLs:
GET {base_url}/jobs
GET {base_url}/jobs/1
POST {base_url}/jobs
DELETE {base_url}/jobs/1
PUT {base_url}/jobs/1
GET {base_url}/jobs/1/company
 */
