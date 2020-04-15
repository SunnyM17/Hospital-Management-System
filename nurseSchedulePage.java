import java.awt.Color;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class nurseSchedulePage extends JPanel {

	/**
	 * JPanel to display GUI that the nurse will see when they click view Schedule in their 
	 * login display.
	 */
	public nurseSchedulePage(JFrame frame, Nurse nurseUser, Users user) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 435, Short.MAX_VALUE))
					.addContainerGap(227, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(5)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 345, Short.MAX_VALUE)
					.addGap(11))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Here is your schedule for the week");
		lblNewLabel_1.setFont(new Font("Cambria", Font.PLAIN, 16));
		
		JLabel lblNewLabel_2 = new JLabel("Monday: ");
		lblNewLabel_2.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_1 = new JLabel("Tuesday: ");
		lblNewLabel_2_1.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_2 = new JLabel("Wednesday: ");
		lblNewLabel_2_2.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_3 = new JLabel("Thursday: ");
		lblNewLabel_2_3.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		JLabel lblNewLabel_2_4 = new JLabel("Friday: ");
		lblNewLabel_2_4.setFont(new Font("Cambria", Font.PLAIN, 15));
		
		
		FileInputStream fs;
		try {
			fs = new FileInputStream(Database.LOCATION + "\\" +String.valueOf(nurseUser.getUserID()) + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 0; i < 6; i++)
			{
				br.readLine();
			}
			
			JLabel mondayLabel = new JLabel(br.readLine());
			mondayLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
			JLabel tuesdayLabel = new JLabel(br.readLine());
			tuesdayLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
			
			JLabel wednesdayLabel = new JLabel(br.readLine());
			wednesdayLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
			
			JLabel thursdayLabel = new JLabel(br.readLine());
			thursdayLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
			
			JLabel fridayLabel = new JLabel(br.readLine());
			fridayLabel.setFont(new Font("Cambria", Font.PLAIN, 15));
			
			JButton btnNewButton = new JButton("Done");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent arg0) {
					if(user.getUserID() == nurseUser.getUserID()) {
						NursePage panel = new NursePage(frame, nurseUser);
						frame.setContentPane(panel);
						frame.revalidate();
					}
					AdminPage panel = new AdminPage(frame, Database.getAdmin(user.getUserID()));
					frame.setContentPane(panel);
					frame.setSize(675, 435);
					frame.revalidate();
				}
					
			});
			GroupLayout gl_panel_1 = new GroupLayout(panel_1);
			gl_panel_1.setHorizontalGroup(
				gl_panel_1.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(99)
								.addComponent(lblNewLabel_1))
							.addGroup(gl_panel_1.createSequentialGroup()
								.addGap(46)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
									.addComponent(lblNewLabel_2)
									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE))
								.addGap(12)
								.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
									.addComponent(mondayLabel, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
									.addComponent(tuesdayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(wednesdayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(thursdayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(fridayLabel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
						.addContainerGap(63, Short.MAX_VALUE))
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap(209, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addGap(165))
			);
			gl_panel_1.setVerticalGroup(
				gl_panel_1.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel_1.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblNewLabel_1)
						.addGap(52)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2)
							.addComponent(mondayLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(tuesdayLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(wednesdayLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_3, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(thursdayLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblNewLabel_2_4, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
							.addComponent(fridayLabel, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
						.addComponent(btnNewButton)
						.addContainerGap())
			);
			panel_1.setLayout(gl_panel_1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		JLabel lblNewLabel = new JLabel("Welcome " + nurseUser.getFirstName() + " " + nurseUser.getLastName());
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 20));
		panel.add(lblNewLabel);
		setLayout(groupLayout);

	}
}
