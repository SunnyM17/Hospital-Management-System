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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGap(172)
					.addComponent(lblNewLabel)
					.addContainerGap(180, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(180)
					.addComponent(lblNewLabel)
					.addContainerGap(231, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
	}
}
