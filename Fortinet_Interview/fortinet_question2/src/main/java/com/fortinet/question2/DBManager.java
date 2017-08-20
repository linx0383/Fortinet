package com.fortinet.question2;

import java.util.concurrent.Semaphore;

//Singleton Pattern
public class DBManager {
		//fair true if this semaphore will guarantee first-in first-out granting of permits under contention, else false
		private Semaphore sem = new Semaphore(10, true);

	   //create an object of Singleton Connection
	   private static DBManager connection = new DBManager();
		
	   int connections = 0;//the number of connections that we made in a given moment

	   //make the constructor private so that this class cannot be
	   //instantiated
	   private DBManager(){}

	   //Get the only object available
	   public static DBManager getInstance(){
	      return connection;
	   }
	   
		public void doConnect(){
			
			synchronized(this){
				connections++;
					System.out.println("Current connnections: " + connections);
			}
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			synchronized(this){
				connections--;
			}
		}
		
		public void connect(){
			
			try {
				sem.acquire();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				doConnect();
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				sem.release();
			}
		}
}
