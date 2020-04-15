import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * This panel displays the user ID assigned to the user after they  
 * have register into the system.
 */
public class DisplayID extends JPanel {

	public DisplayID(JFrame frame, Authorize newUser, int id) {
		
		JLabel titleLbl = new JLabel("User ID ");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		JLabel idLbl = new JLabel(id+"");
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 17));
		
		JButton loginPageLbl = new JButton("Login Page");
		loginPageLbl.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Displays the login page
				Login panel = new Login(frame, newUser);
				frame.setContentPane(panel);
				frame.setSize(675, 432);
				frame.revalidate();
			}
		});
		
		JLabel noteLbl = new JLabel("Please note down the following User ID as you will need this to login.");
		noteLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(38)
					.addComponent(noteLbl)
					.addContainerGap(51, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(200)
					.addComponent(idLbl)
					.addContainerGap(287, Short.MAX_VALUE))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(181)
					.addComponent(loginPageLbl, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(197, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(223, Short.MAX_VALUE)
					.addComponent(titleLbl)
					.addGap(192))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(67)
					.addComponent(titleLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(noteLbl)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idLbl)
					.addGap(26)
					.addComponent(loginPageLbl)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
	}
}
