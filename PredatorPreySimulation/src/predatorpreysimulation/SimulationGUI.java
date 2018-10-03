package predatorpreysimulation;


import java.util.Random;

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
	JPanel panel;

	JLabel animals;
	JLabel[][] mainlabel;
	


	int[][] positions;

	int[] fishx;
	int[] fishy;
	int[] eaaglex;
	int[] eagley;
	int rannum;

	
	public SimulationGUI() {

		
		 
		 
		 /////////////////////////////Makes The Frame///////////////////////////////////

		frame = new JFrame("Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 640);
		frame.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel(new GridBagLayout());
		
		
		//creates vgrid
		
		mainlabel = new JLabel[64][64];
		
		for(int i = 0; i <=63; i ++) {
			for(int k = 0; k <=63; k ++) {
				mainlabel[i][k] = new JLabel();
				mainlabel[i][k].setIcon(new ImageIcon("green.jpg"));
				mainlabel[i][k].setBorder(new LineBorder(Color.BLACK));
				c.gridy = i;
				c.gridx = k;
				
				panel.add(mainlabel[i][k], c);
				
			}
		}

		/////////////////////////////Get spawn coordinates of animals//////////////////////////
		Random r = new Random();
		

		
		fishx = new int[30];
		for(int i = 0; i < fishx.length; i++) {
			rannum = r.nextInt(64 - 0 + 1) + 0;
			fishx[i] = rannum;
		}
		
		//
		
		positions = new int[64][64];
		for(int i = 0; i <=63; i ++) {
			for(int j = 0; j <=63; j ++) {
				positions[i][j] = 0;
			}
		}
		
		
	
		
		
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
	
	
	
	public static void Search(){
		
	}
}
