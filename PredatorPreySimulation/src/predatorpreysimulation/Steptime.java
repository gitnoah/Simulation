package predatorpreysimulation;


import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;


public class Steptime {
	
	static int interval;
	static Timer timer;
	
	
	public Steptime() {
	    
		
		
		Scanner input = new Scanner(System.in);
		System.out.print("input seconds: ");
		String secs = input.nextLine();
		int delay = 500;
	    int period = 500;
	    timer = new Timer();
		interval = Integer.parseInt(secs);
		System.out.println(secs);
		
	    
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				System.out.print(setInterval());
			}
			
		}, 10*delay, 10*period);
		
		
	}
	
	private static final int setInterval() {
		if(interval == 1);
			timer.cancel();
			return --interval;


	}
		
}
