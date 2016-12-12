/**
 * 
 */
package com.pris.task.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.DateUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.pris.task.dao.MonitorDao;
import com.pris.task.dao.TaskDao;
import com.pris.task.model.Monitor;

/**
 * @author LO
 *
 */
@RestController
public class BaseController {
	private Logger logger = Logger.getLogger(BaseController.class);
	@Autowired
	private TaskDao dao;
	@Autowired
	private MonitorDao monitorDao;
	@GetMapping("/task/{id}")
	public String remove(@PathVariable String id){
		dao.deleteById(id);
		return "is gone";
	}
	
	@GetMapping("/task")
	public String test() throws ParseException{
		Monitor monitor = new Monitor();
		monitor.setChannel("aa");
		monitor.setCode("edc");
		monitor.setConsumer("44");
		monitor.setDistrict("tt");
		monitor.setVersion("1");
		monitor.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		Monitor monitor1 = new Monitor();
		monitor1.setChannel("aa");
		monitor1.setCode("edc");
		monitor1.setConsumer("44");
		monitor1.setDistrict("tt");
		monitor1.setVersion("2");
		monitor1.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor1.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		Monitor monitor2 = new Monitor();
		monitor2.setChannel("aa");
		monitor2.setCode("edc");
		monitor2.setConsumer("44");
		monitor2.setDistrict("tt");
		monitor2.setVersion("3");
		monitor2.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor2.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		Monitor monitor3 = new Monitor();
		monitor3.setChannel("aa");
		monitor3.setCode("edc");
		monitor3.setConsumer("44");
		monitor3.setDistrict("yy");
		monitor3.setVersion("1");
		monitor3.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor3.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		Monitor monitor4 = new Monitor();
		monitor4.setChannel("aa");
		monitor4.setCode("edc");
		monitor4.setConsumer("44");
		monitor4.setDistrict("ee");
		monitor4.setVersion("2");
		monitor4.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor4.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		Monitor monitor5 = new Monitor();
		monitor5.setChannel("aa");
		monitor5.setCode("edc");
		monitor5.setConsumer("44");
		monitor5.setDistrict("qq");
		monitor5.setVersion("3");
		monitor5.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor5.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		ConcurrentLinkedQueue<Monitor> l = new ConcurrentLinkedQueue<>();
		l.offer(monitor);
		l.offer(monitor5);
		l.offer(monitor4);
		l.offer(monitor3);
		l.offer(monitor2);
		l.offer(monitor1);
		ExecutorService  e = Executors.newFixedThreadPool(1);
		System.out.println(new Date().getTime()+"----------"+Thread.currentThread().getName()+"----------");
		for(int i=0;i<6;i++){
//			e.execute(new Runnable() {
//				@Override
//				public void run() {
//					System.out.println(new Date().getTime()+"--------"+Thread.currentThread().getName()+"----------------------------");
//					Monitor monitor = l.poll();
//					System.out.println(monitor+"-------------"+Thread.currentThread().getName()+"-----------");
//					long start = System.nanoTime();
//					List<Monitor> list = monitorDao.findById(monitor);
//					long end = System.nanoTime();
//					System.out.println(new Date().getTime()+"-------------"+Thread.currentThread().getName()+"------------------------------");
//					System.out.println((end-start)/1000000+"------------"+list.size()+"-----------------");
//				}
//			});
			System.out.println(new Date().getTime()+"--------"+Thread.currentThread().getName()+"----------------------------");
			Monitor monitorT = l.poll();
			System.out.println(monitorT+"-------------"+Thread.currentThread().getName()+"-----------");
			long start = System.nanoTime();
			List<Monitor> list = monitorDao.findById(monitorT);
			long end = System.nanoTime();
			System.out.println(new Date().getTime()+"-------------"+Thread.currentThread().getName()+"------------------------------");
			System.out.println((end-start)/1000000+"------------"+list.size()+"-----------------");
		}
		return "is gone";
	}
}
