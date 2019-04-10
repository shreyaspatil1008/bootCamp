package com.industriallogic.example;

import java.util.EnumSet;

/**
 * Created by idnsrp on 6/7/2018.
 */
public class Employee {

    private int jobsCompleted;
    private int jobsSkipped;
    private final EnumSet<Job> jobs;

    public int jobsCompletedCount() {
        return jobsCompleted;
    }

    public Employee(final EnumSet<Job> jobs){
        this.jobs = jobs;
    }

    public int jobsSkippedCount() {
        return jobsSkipped;
    }

    public void performJob(final Job job) {
        if (jobs.contains(job))
            jobsCompleted++;
        else
            jobsSkipped++;
    }
}
