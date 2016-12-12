package com.pris.task.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import com.pris.TaskApplicationTests;
import com.pris.task.model.Monitor;
@Transactional
public class MonitorDaoTest extends TaskApplicationTests{
	@Autowired
	private MonitorDao dao;
	@Test
//	@Commit
	public void testAdd() {
		int total = 4000;
		Random r = new Random(System.nanoTime());
		String[] channel = {"aa","ss","dd","ff","gg","hh","jj","kk","ll","zz"};
		String[] district = {"qq","ww","ee","rr","tt","yy","uu","ii","oo","pp"};
		String[] consumer = {"44","55"};
		String[] code = {"qaz","wsx","edc","rfv"};
		String[] version = {"1","2","3"};
		for(int i=0;i<total;i++){
			Monitor monitor = new Monitor();
			monitor.setChannel(channel[r.nextInt(channel.length)]);
			monitor.setCode(code[r.nextInt(code.length)]);
			monitor.setConsumer(consumer[r.nextInt(consumer.length)]);
			monitor.setCount(1);
			monitor.setDistrict(district[r.nextInt(district.length)]);
			monitor.setEnd(DateUtils.addMilliseconds(new Date(), r.nextInt(1000)));
			monitor.setVersion(version[r.nextInt(version.length)]);
			try {
				dao.add(monitor);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Test
	public void testFindById() throws ParseException {
		
		Monitor monitor = new Monitor();
		monitor.setChannel("aa");
		monitor.setCode("edc");
		monitor.setConsumer("44");
		monitor.setDistrict("tt");
		monitor.setVersion("3");
		monitor.setStart(DateUtils.parseDate("2016-12-07", "yyyy-MM-dd"));
		monitor.setEnd(DateUtils.parseDate("2016-12-08", "yyyy-MM-dd"));
		ExecutorService  e = Executors.newFixedThreadPool(3);
		for(int i=0;i<3;i++){
			System.out.println(2525254353453l);
			e.execute(new Runnable() {
				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
					long start = System.nanoTime();
					List<Monitor> list = dao.findById(monitor);
					long end = System.nanoTime();
					System.out.println(new Date().getTime()+"--------------------------"+Thread.currentThread().getName()+"--------------------------------");
					System.out.println((end-start)/1000000+"-------------------------------------------------------------");
				}
			});
		}
	}

}
