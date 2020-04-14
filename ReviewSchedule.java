import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class ReviewSchedule extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReviewSchedule(JFrame frame, Users selectedUser, Users currentUser) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		
		/**
		 * Button that, when clicked, takes back to the previous page
		 * regardless of what user that is 
		 */
		JButton backBtn = new JButton("Back");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				/* finds first digit of ID number of current user */
				int firstDigit = Integer.parseInt(Integer.toString(currentUser.getUserID()).substring(0, 1));
				/* if current user is doctor, return to doctor's page */
				if (firstDigit == 2) {
					DoctorPage panel = new DoctorPage(frame, Database.getDoctor(currentUser.getUserID()));
					frame.setContentPane(panel);
					frame.revalidate();
				}
				/* if current user is an assistant, return to assistant's page */
				else if (firstDigit == 4) {
					SelectSchedule Panel = new SelectSchedule(frame, currentUser, Database.getAllDoctors());
					frame.setContentPane(panel);
					frame.revalidate();
				}
				/* if current user is a nurse, return of nurse's page*/
				else if (firstDigit == 5) {
					NursePage nursePanel = new NursePage(frame, Database.getNurse(currentUser.getUserID()));
					frame.setContentPane(nursePanel);
					frame.revalidate();
				}
			}
		});
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 574, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap(271, Short.MAX_VALUE)
					.addComponent(backBtn)
					.addGap(269))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 57, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 208, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(backBtn)
					.addContainerGap())
		);
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 545, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		/**
		 * This TextArea displays the Schedule, things that must be done for the
		 * user that are currently in his user File
		 */
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		panel_1.setLayout(gl_panel_1);
		
		/**
		 * Button that, when clicked, takes user to logout frame and logs him/her
		 * out of the system
		 */
		JButton logoutBtn = new JButton("Logout");
		logoutBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				LogoutPage panel = new LogoutPage(frame);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		
		JLabel nameLbl = new JLabel(selectedUser.getFirstName() + " " + selectedUser.getLastName()+ "'s Schedule");
		nameLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(38)
					.addComponent(nameLbl)
					.addPreferredGap(ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
					.addComponent(logoutBtn))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addComponent(nameLbl)
					.addContainerGap())
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addComponent(logoutBtn)
					.addContainerGap(28, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		int userID = selectedUser.getUserID();
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
					textArea.append(line.substring(9) + "\n");
				}
				line = bf.readLine();
			}
			bf.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}

		


	}
	
	
	
}
