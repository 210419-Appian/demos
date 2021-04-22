package com.revature;

public class MyMagicThread extends Thread{
	
	@Override
	public void run() {
		for(int i =0; i<10; ++i) {
			StringBuffer sb = new StringBuffer(Thread.currentThread().getName());
			sb.append(" is working..."); 
			
			System.out.println(sb);
			
			
			
			//This is only so we can see it
			try {
				Thread.sleep(2000);
			}catch (InterruptedException e) {
				e.printStackTrace();
				break;
			}
		}
	}

}
