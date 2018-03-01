package com.javen.testquartz;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class QuartzJob implements Job{

	public void execute(JobExecutionContext arg0) throws JobExecutionException {
		Date date=new Date();
		SimpleDateFormat sFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm：ss");
        System.out.println("当前时间："+sFormat.format(date));
        
        System.out.println("quartz");
	}

}
