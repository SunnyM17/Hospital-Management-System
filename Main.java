import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.LayoutStyle.ComponentPlacement;

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
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(266, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(loginBtn)
							.addGap(272))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(registerBtn)
							.addGap(262))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(73)
					.addComponent(loginBtn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(registerBtn)
					.addContainerGap(106, Short.MAX_VALUE))
		);
		frame.getContentPane().setLayout(groupLayout);
	}
}
