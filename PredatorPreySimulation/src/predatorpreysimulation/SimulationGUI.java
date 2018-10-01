package predatorpreysimulation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class SimulationGUI {
	JFrame frame;
	JPanel panel;
	
	public SimulationGUI() {
		frame = new JFrame("Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 640);
		frame.setLocationRelativeTo(null);
		
		panel = new JPanel();
		
		
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
