package com.javen.testquartz;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Quartz {
	public static void main(String[] args) throws SchedulerException {
		JobDetail jobDetail = JobBuilder.newJob(QuartzJob.class).withIdentity("myjob", "group1").build();
		System.out.println("jobDetail-name:"+jobDetail.getKey().getName());
		System.out.println("jobDetail-group:"+jobDetail.getKey().getGroup());
		System.out.println("jobDetail-jobClass:"+jobDetail.getJobClass().getName());
		
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity("mytrigger", "group1").startNow()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
		SchedulerFactory sf=new StdSchedulerFactory();
		Scheduler scheduler=sf.getScheduler();
		scheduler.start();
		scheduler.scheduleJob(jobDetail, trigger);
	}
} 