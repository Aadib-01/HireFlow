package com.hireflow.service;

import com.hireflow.entity.Job;
import com.hireflow.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    @Autowired
    private JobRepository jobRepository;

    // Create Job
    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    // Get All Jobs
    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }

    // Get Job By ID
    public Job getJobById(Long id) {
        return jobRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Job not found with id: " + id));
    }

    // Update Job
    public Job updateJob(Long id, Job updatedJob) {

        Job existingJob = getJobById(id);

        existingJob.setTitle(updatedJob.getTitle());
        existingJob.setCompany(updatedJob.getCompany());
        existingJob.setDescription(updatedJob.getDescription());
        existingJob.setLocation(updatedJob.getLocation());
        existingJob.setJobType(updatedJob.getJobType());

        return jobRepository.save(existingJob);
    }

    // Delete Job
    public void deleteJob(Long id) {
        jobRepository.deleteById(id);
    }

    // Search by Location
    public List<Job> getJobsByLocation(String location) {
        return jobRepository.findByLocation(location);
    }

    // Search by Job Type
    public List<Job> getJobsByJobType(String jobType) {
        return jobRepository.findByJobType(jobType);
    }

    // Search by Company
    public List<Job> getJobsByCompany(String company) {
        return jobRepository.findByCompany(company);
    }
}
