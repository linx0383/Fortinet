package com.fortinet.question2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.fortinet.question2.DBManager;

import org.junit.Assert;
import org.junit.Test;


public class TestConnection {
	int NUMBER_OF_DATABASE_QUERY = 100;
	
	@Test
	public void testBuildDatabaseConnection(){
		ExecutorService executor = Executors.newCachedThreadPool();
		for(int i=0; i<NUMBER_OF_DATABASE_QUERY; i++){
			executor.submit(new Runnable(){
				public void run(){
					DBManager.getInstance().connect();
				}
			});
		}
		Assert.assertEquals(DBManager.getInstance().connections, 10);
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
