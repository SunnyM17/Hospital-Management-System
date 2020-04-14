import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;


public class Main {

	private JFrame frame;
	Authorize auth = new Authorize();
	
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		Database.reload();
	} 
	
	/**
	 * Setting the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 639, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		StartPage panel = new StartPage(frame, auth);
		frame.setContentPane(panel);
		frame.setSize(675, 432);
		frame.revalidate();
	}
	
	/**
	 * Launches the application.
	 */
	public static void main (String[] args) { 
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	  }
}
