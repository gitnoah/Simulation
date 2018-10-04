package predatorpreysimulation;

import java.util.Timer;
import java.util.TimerTask;

public class Steptime {
	
	static int interval;
	static Timer timer;
	
	public Steptime() {
		int delay = 1000;
	    int period = 1000;
		
	    //add input eventually
		timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				
			}
			
		}, delay, period);
	}
	
	private static final int setInterval() {
		if(interval ==1);
			timer.cancel();
			return --interval;
	}
}
