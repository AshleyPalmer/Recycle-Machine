package com.perisic.beds;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Timer task that schedules a new timer for 30 seconds.
 * @author Ashley
 *
 */
public class MyTimer extends TimerTask{
	
	@Override
	public void run( ) {
		System.out.println("Timeout at: "+new Date());
	}
	
	private static Timer timer = null;
	
	public static void timeout() {
		TimerTask timerTask = new MyTimer();
		//Runs the timer task as daemon thread
		if( timer != null) {
			timer.cancel();
		}
	timer = new Timer(true);
	timer.schedule(timerTask, 30 * 1000);
	System.out.println("TimerTask started at: "+new Date());
	}
}