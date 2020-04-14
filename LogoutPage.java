import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class LogoutPage extends JPanel {

	/**
	 * Create the panel.
	 */
	public LogoutPage(JFrame frame) {
		setBackground(Color.WHITE);
		
		JLabel lblNewLabel = new JLabel("You have successfully logged out!");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton backBtn = new JButton("Back to Main Menu");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Authorize auth = new Authorize();
				StartPage mainMenu = new StartPage(frame,auth);
				frame.setContentPane(mainMenu);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(176)
							.addComponent(lblNewLabel))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(246)
							.addComponent(backBtn)))
					.addContainerGap(177, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(180)
					.addComponent(lblNewLabel)
					.addGap(18)
					.addComponent(backBtn)
					.addContainerGap(84, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
