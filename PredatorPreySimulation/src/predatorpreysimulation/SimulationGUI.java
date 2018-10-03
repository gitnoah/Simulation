package predatorpreysimulation;

import java.util.Random;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.synth.Region;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.plaf.synth.SynthStyle;
import javax.swing.plaf.synth.SynthStyleFactory;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;



public class SimulationGUI {
	JFrame frame;
	JPanel panel;
	JLabel animals;
	JLabel[][] mainlabel;
	BufferedImage fishimg, eagleimg;

	int[][] positions;
	int[] fishx;
	int[] fishy;
	int[] eaaglex;
	int[] eagley;
	int rannum;
	
	public SimulationGUI() {
		 LoadImage("/img/fish.jpg", "/img/eagle.jpg");
		 
		 
		 /////////////////////////////Makes The Frame///////////////////////////////////
		frame = new JFrame("Simulation");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(640, 640);
		frame.setLocationRelativeTo(null);
		
		/////////////////////////////Creates The Grid///////////////////////////////////
		GridBagConstraints c = new GridBagConstraints();
		
		panel = new JPanel(new GridBagLayout());
		
		
		//creates grid
		
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
	
	public void LoadImage(String eag, String fis){
		try{
			fishimg = ImageIO.read(SimulationGUI.class.getResource(fis));
			eagleimg = ImageIO.read(SimulationGUI.class.getResource(eag));
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
	
	}
	
}
