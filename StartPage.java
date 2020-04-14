import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartPage extends JPanel {

	/**
	 * Create the panel.
	 */
	public StartPage(JFrame frame, Authorize auth) {
		setBackground(Color.WHITE);
		
		JLabel label = new JLabel("Welcome to the AHS Hospital Management System");
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel label_1 = new JLabel("To begin, select from one of the options below");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton button = new JButton("Login");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Login panel = new Login(frame, auth);
				frame.setContentPane(panel);
				//frame.setSize(639, 309);
				frame.revalidate();
			}
		});
		button.setBackground(Color.WHITE);
		
		JButton button_1 = new JButton("Register");
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Register panel = new Register(frame, auth);
				frame.setContentPane(panel);
				frame.setSize(675, 432);
				frame.revalidate();
			}
		});
		button_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(100)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(label)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(62)
							.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 332, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(193)
							.addComponent(button, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(184)
							.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 89, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(101, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(128)
					.addComponent(label)
					.addGap(29)
					.addComponent(label_1)
					.addGap(18)
					.addComponent(button)
					.addGap(18)
					.addComponent(button_1)
					.addContainerGap(139, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
