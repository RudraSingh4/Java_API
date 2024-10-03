package com.example.demo.job.impl;

import com.example.demo.job.Job;
import com.example.demo.job.JobService;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

@Service
public class JobServiceImpl implements JobService {

    private List<Job> jobs = new ArrayList<>();
    private Long nextId = 1L;

    @Override
    public List<Job> findAll(){

        return jobs;
    }

    @Override
    public void createJob(Job job){
        job.setId(nextId++);
        jobs.add(job);

    }

    @Override
    public Job getJobById(Long id) {
        for (Job job :
        jobs){
            if (job.getId().equals(id)){
               return job;
            }
        }
        return null;
    }

    @Override
    public boolean deleteById(Long id) {
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updateJob(Long id, Job updatedJob) {
        for (Job job : jobs) {
            if (job.getId().equals(id)){
                job.setTitle(updatedJob.getTitle());
                job.setDescription(updatedJob.getDescription());
                job.setMinSallary(updatedJob.getMinSallary());
                job.setMaxSallary(updatedJob.getMaxSallary());
                job.setLocation(updatedJob.getLocation());
                return true;
            }
        }
        return false;
    }

}
