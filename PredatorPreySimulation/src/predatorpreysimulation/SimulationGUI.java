package predatorpreysimulation;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class SimulationGUI {
	JFrame frame;
	JFrame frame2;
	
	JPanel panel;
	JPanel panel2;
	
	JLabel animals;
	JLabel[][] mainlabel;
	
	Timer timer;

	JButton button;

	JButton morefish;
	JButton lessfish;
	JButton moreeagles;
	JButton lesseagles;
	
	int eagleamount = 100;
	int fishamount = 130;
	
	int[][] positions;
	int[][] fish;

	int[] fishx;
	int[] fishy;
	int[] eaglex;
	int[] eagley;
	int rannum;

	public SimulationGUI() throws InterruptedException{
		
		 /////////////////////////////Makes The Frame///////////////////////////////////

		frame = new JFrame("Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(790, 835);
		frame.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel(new GridBagLayout());
		
		
		//creates grid
		
		mainlabel = new JLabel[66][66];
		
		for(int i = 1; i <=64; i ++) {
			for(int k = 1; k <=64; k ++) {
				mainlabel[i][k] = new JLabel();
				mainlabel[i][k].setIcon(new ImageIcon("green.jpg"));
				mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
				c.gridy = i;
				c.gridx = k;
				
				panel.add(mainlabel[i][k], c);
				
			}
		}
		frame2 = new JFrame("Simulation");
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.setSize(640, 640);
		frame2.setLocationRelativeTo(null);
		
		GridBagConstraints c2 = new GridBagConstraints();
		
		panel2 = new JPanel(new GridBagLayout());
		button = new JButton("press");
		
		morefish = new JButton("Increase fish by 30");
		lessfish = new JButton("Decrease fish by 30");
		moreeagles = new JButton("Increase eagles by 10");
		lesseagles = new JButton("Decrease eagles by 10");
		
		morefish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fishamount += 30;  
			}
			
		});
		
		lessfish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				fishamount -= 30;
			}
			
		});
		
		moreeagles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				eagleamount += 10;  
			}
			
		});
		
		lesseagles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				eagleamount -= 10; 
			}
			
		});
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
		///////////////something///////////////////
				
		positions = new int[66][66];
			for(int i = 1; i <=64; i ++) {
				for(int k = 1; k <=64; k ++) {
					positions[i][k] = 0;
				}
			}
				int q = 0;
				for(int k = 0; k <= 65; k ++) {
					positions[q][k] = 3;
				}
				int e = 65;
				for(int k = 0; k <= 65; k ++) {
					positions[e][k] = 3;
				}
				int p = 0;
				for(int k = 0; k <= 65; k ++) {
					positions[k][p] = 3;
				}
				int l = 65;
				for(int k = 0; k <= 65; k ++) {
					positions[k][l] = 3;
				}
				
		/////////////////////////////Get spawn coordinates of animals//////////////////////////
		Random r = new Random();


		//////////////fish coordinates
		fishx = new int[fishamount];
		for(int i = 0; i < fishx.length; i++) {
			rannum = r.nextInt(64 - 1 + 1) + 1;
			fishx[i] = rannum;
		}

		fishy = new int[fishamount];
			for(int j = 0; j < fishy.length; j++) {
				rannum = r.nextInt(64 - 1 + 1) + 1;
				fishy[j] = rannum;
			}
				
		for(int j = 0; j < fishamount; j ++) {
			int x, y;
			x = fishx[j];
			y = fishy[j];
			mainlabel[x][y].setIcon(new ImageIcon("whitefish.jpg"));
			mainlabel[x][y].setBorder(new LineBorder(Color.BLACK));
			positions[x][y] = 1;
		}


		///////////////eagle coordinates
		eaglex = new int[eagleamount];
		for(int i = 0; i < eagleamount; i++) {
			rannum = r.nextInt(64 - 1 + 1) + 1;
			eaglex[i] = rannum;
		}

		eagley = new int[eagleamount];
		//
		for(int j = 0; j < eagleamount; j++) {
			rannum = r.nextInt(64 - 1 + 1) + 1;
			eagley[j] = rannum; 
		}
				
		for(int j = 0; j < eagleamount; j ++) {
			int u, h;
			u = eaglex[j];
			h = eagley[j];
			mainlabel[u][h].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[u][h].setBorder(new LineBorder(Color.BLACK));
			positions[u][h] = 2;
		}
///////////searches through positions array/////////////////////
		
		TimerTask repeat = new TimerTask() {
			public void run() {
				for(int i = 1; i <= 64; i ++) {
					for(int k = 1; k <=64; k ++) {
						if(positions[i][k] == 1) {
							Searchfish(i, k);
						}else if(positions[i][k] == 2) {
							Searcheagle(i, k);
						}
					}
				}
			}
		};
		Timer timer = new Timer("timer");
		
		long delay = 2000L;
		long period = 1000L;
		timer.scheduleAtFixedRate(repeat, delay, period);
		
////////////////////////////////////////////////////////////
		frame2.dispose();
		frame.setContentPane(panel);      
		frame.setVisible(true);  
		

			
	}
			
	});
		
		panel2.add(button);
		panel2.add(morefish);
		panel2.add(lessfish);
		panel2.add(moreeagles);
		panel2.add(lesseagles);
		frame2.setContentPane(panel2);
		frame2.setVisible(true);
		

		
}
	/*
	 * Method Searcheagle takes coordinates and searches all the positions around them to see if there are eagle or other fish.  If there are eagle it kills the fish and 
	 * replaces it with an eagle.  If there are lease than 4 fish and more than 0 it spawns a new fish around the first one.
	 */
	
	
	public void Searchfish(int i, int k){
		if(positions[i+1][k] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i-1][k] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i+1][k+1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i+1][k-1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i-1][k+1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i-1][k-1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		
		if(positions[i][k+1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		if(positions[i][k-1] == 2) {
			mainlabel[i][k].setIcon(new ImageIcon("blackeagle.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 2;
		}
		
		int friends=0;
		
		if(positions[i][k] == 1 && positions[i+1][k] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i-1][k] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i][k+1] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i][k-1] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i+1][k+1] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i+1][k-1] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i-1][k+1] == 1) {
			friends+=1;
		}
		
		if(positions[i][k] == 1 && positions[i-1][k-1] == 1) {
			friends+=1;
		}
		
		///////////
		
		if(friends < 4  && friends > 1) {
			if(positions[i+1][k] == 0) {
				mainlabel[i+1][k].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i+1][k].setBorder(new LineBorder(Color.BLACK));
				positions[i+1][k] = 1;
			}else if(positions[i-1][k] == 0) {
				mainlabel[i-1][k].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i-1][k].setBorder(new LineBorder(Color.BLACK));
				positions[i-1][k] = 1;
			}else if(positions[i][k+1] == 0) {
				mainlabel[i][k+1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i][k+1].setBorder(new LineBorder(Color.BLACK));
				positions[i][k+1] = 1;
			}else if(positions[i][k-1] == 0) {
				mainlabel[i][k-1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i][k-1].setBorder(new LineBorder(Color.BLACK));
				positions[i][k-1] = 1;
			}else if(positions[i+1][k+1] == 0) {
				mainlabel[i+1][k+1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i+1][k+1].setBorder(new LineBorder(Color.BLACK));
				positions[i+1][k+1] = 1;
			}else if(positions[i+1][k-1] == 0) {
				mainlabel[i+1][k-1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i+1][k-1].setBorder(new LineBorder(Color.BLACK));
				positions[i+1][k-1] = 1;
			}else if(positions[i-1][k+1] == 0) {
				mainlabel[i-1][k+1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i-1][k+1].setBorder(new LineBorder(Color.BLACK));
				positions[i-1][k+1] = 1;
			}else if(positions[i-1][k-1] == 0) {
				mainlabel[i-1][k-1].setIcon(new ImageIcon("whitefish.jpg"));
				mainlabel[i-1][k-1].setBorder(new LineBorder(Color.BLACK));
				positions[i-1][k-1] = 1;
			}
		}else if(friends == 0 || friends > 5) {
			mainlabel[i][k].setIcon(new ImageIcon("green.jpg"));
			mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
			positions[i][k] = 0;
		}
		
	}
	
	/*
	 * Method Searcheagle takes the coordinates of an eagle and looks to see if it has any friends around it.  If it does it lives.  IF not it dies.
	 */
	public void Searcheagle(int i, int k)  {
			
			int friends=0;
		
			if(positions[i+1][k] == 2) {
				friends+=1;
			}
		
			if(positions[i-1][k] == 2) {
				friends+=1;
			}
		
			if(positions[i][k+1] == 2) {
				friends+=1;
			}
		
			if(positions[i][k-1] == 2) {
				friends+=1;
			}
		
			if(positions[i+1][k+1] == 2) {
				friends+=1;
			}
		
			if(positions[i+1][k-1] == 2) {
				friends+=1;
			}
		
			if(positions[i-1][k+1] == 2) {
				friends+=1;
			}
		
			if(positions[i-1][k-1] == 2) {
				friends+=1;
			}
			
			if(friends >= 1 && friends < 5) {
				if(positions[i+1][k] == 0) {
					mainlabel[i+1][k].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i+1][k].setBorder(new LineBorder(Color.BLACK));
					positions[i+1][k] = 2;
				}else if(positions[i][k+1] == 0) {
					mainlabel[i][k+1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i][k+1].setBorder(new LineBorder(Color.BLACK));
					positions[i][k+1] = 2;
				}else if(positions[i][k-1] == 0) {
					mainlabel[i][k-1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i][k-1].setBorder(new LineBorder(Color.BLACK));
					positions[i][k-1] = 2;
				}else if(positions[i-1][k] == 0) {
					mainlabel[i-1][k].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i-1][k].setBorder(new LineBorder(Color.BLACK));
					positions[i-1][k] = 2;
				
				}else if(positions[i+1][k+1] == 0) {
					mainlabel[i+1][k+1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i+1][k+1].setBorder(new LineBorder(Color.BLACK));
					positions[i+1][k+1] = 2;
				}else if(positions[i+1][k-1] == 0) {
					mainlabel[i+1][k-1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i+1][k-1].setBorder(new LineBorder(Color.BLACK));
					positions[i+1][k-1] = 2;
				}else if(positions[i-1][k+1] == 0) {
					mainlabel[i-1][k+1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i-1][k+1].setBorder(new LineBorder(Color.BLACK));
					positions[i-1][k+1] = 2;
				}else if(positions[i-1][k-1] == 0) {
					mainlabel[i-1][k-1].setIcon(new ImageIcon("blackeagle.jpg"));
					mainlabel[i-1][k-1].setBorder(new LineBorder(Color.BLACK));
					positions[i-1][k-1] = 2;
				}
			}else if(friends == 0 || friends > 5) {
				mainlabel[i][k].setIcon(new ImageIcon("green.jpg"));
				mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
				positions[i][k] = 0;
			}
		
		
	}
}
