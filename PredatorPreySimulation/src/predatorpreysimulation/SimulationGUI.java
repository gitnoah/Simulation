package predatorpreysimulation;


import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;



public class SimulationGUI {
	JFrame frame;
	JPanel panel;
	JLabel[][] mainlabel;
	
	
	public SimulationGUI() {
		
		
		frame = new JFrame("Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 640);
		frame.setLocationRelativeTo(null);
		
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel(new GridBagLayout());
		
		mainlabel = new JLabel[8][8];
		
		for(int i = 0; i <=7; i ++) {
			for(int k = 0; k <=7; k ++) {
				
				mainlabel[i][k].setSize(10, 10);
				mainlabel[i][k].setIcon(arg0);
				c.gridy = i;
				c.gridx = k;
				
				panel.add(mainlabel[i][k], c);
				
			}
		}
		
		frame.setContentPane(panel);
		frame.setVisible(true);
	}
}
