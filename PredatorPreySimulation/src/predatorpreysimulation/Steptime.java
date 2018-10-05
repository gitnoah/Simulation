package predatorpreysimulation;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;


public class Steptime {
	
	static int interval;
	static Timer timer;
	JTextField text;
	JFrame frame;
	JLabel label;
	JPanel panel;
	
	public Steptime() {
		int delay = 1000;
	    int period = 1000;
	    String input;
		
	    frame = new JFrame();
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(150, 100);
		frame.setLocationRelativeTo(null);
	    
	    //add input eventually
		text = new JTextField(20);
		text.addActionListener(null);
		input = text.getText();
		timer = new Timer();
		interval = Integer.parseInt(input);
	    
		
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				
				
			}
			
		}, delay, period);
		
		label.add(text);
		panel.add(label);
		frame.setContentPane(panel);
		frame.setVisible(true);
		
	}
	
	private static final int setInterval() {
		if(interval == 1);
			timer.cancel();
			return --interval;
	}
}
