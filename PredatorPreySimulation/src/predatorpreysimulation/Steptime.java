package predatorpreysimulation;


import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;


public class Steptime {
	static Thread thread = new Thread();
	
	
	public Steptime() throws InterruptedException {
	    for(int i = 1; i > 0; i++) {
	    	thread.sleep(100);
	    	System.out.println(i);
	    }
		
	}
		
}
