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
	 * Launch the application.
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

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
		Database.reload();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 639, 309);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JButton loginBtn = new JButton("Login");
		loginBtn.setBackground(Color.WHITE);
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login panel = new Login(frame, auth);
				frame.setContentPane(panel);
				frame.setSize(639, 309);
				frame.revalidate();
				
			}
		});
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setBackground(Color.WHITE);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Register panel2 = new Register(frame, auth);
				frame.setContentPane(panel2);
				frame.setSize(629, 329);
				frame.revalidate();
			}
		});
		
		JLabel welcomeLabel = new JLabel("Welcome to the AHS Hospital Management System");
		welcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel welcomeDescriptionLabel = new JLabel("To begin, select from one of the options below");
		welcomeDescriptionLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(273)
							.addComponent(loginBtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(264)
							.addComponent(registerBtn))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(80)
							.addComponent(welcomeLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(142)
							.addComponent(welcomeDescriptionLabel)))
					.addContainerGap(81, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(26)
					.addComponent(welcomeLabel)
					.addGap(33)
					.addComponent(welcomeDescriptionLabel)
					.addGap(29)
					.addComponent(loginBtn)
					.addGap(16)
					.addComponent(registerBtn)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
