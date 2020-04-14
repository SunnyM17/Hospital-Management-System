import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ReviewSchedule extends JPanel {

	/**
	 * Create the panel.
	 * @param user used to be able to read any Schedule 
	 * from any user, not excluding any kind of user
	 */
	public ReviewSchedule(JFrame frame ,Doctor user) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		/**
		 * Button that, when clicked, takes user to logout frame and logs him/her
		 * out of the system
		 */
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogoutPage panel = new LogoutPage(frame);
				frame.setContentPane(panel);
				frame.revalidate();	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		/**
		 * Button that, when clicked, takes back to the main user page
		 * regardless of what user that is 
		 */
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoctorPage panel = new DoctorPage(frame, user);
				frame.setContentPane(panel);
				frame.setSize(602, 330);
				frame.revalidate();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
	
		/**
		 * This TextArea displays the Schedule, things that must be done for the
		 * user that are currently in his user File
		 */
		
		JTextArea textArea = new JTextArea();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(textArea, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(18)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		int userID = user.getUserID();
		String stringID = String.valueOf(userID);
		
		/**
		 * We need to use the try-catch statement as we use 
		 * File.io to read from the users file, which is what we use the
		 * userID for. Everything that starts with Schedule: is related 
		 * to the schedule and must be printed
		 *
		 */
		try {
			BufferedReader bf = new BufferedReader(new FileReader(Database.LOCATION+"\\" + stringID+ ".txt"));
			String line = bf.readLine();
			while(line != null) {
				if(line.contains("Schedule: ")) {
					textArea.append(line + "\n");
				}
				line = bf.readLine();
			}
			bf.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Your Schedule");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(lblNewLabel);
		setLayout(groupLayout);
		
		JLabel statsLbl = new JLabel("Your Schedule for the Week");
		statsLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		
	}
}
