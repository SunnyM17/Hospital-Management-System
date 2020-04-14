import java.awt.Color;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DoctorPage extends JPanel {

	/**
	 * JPanel to display GUI that Doctors will see when they log in to the system.
	 * Gives options for the doctor to set his schedule availability for the week 
	 * as well as check his schedule for the week. This also gives the option to
	 * update the doctor's information, as well as check patient information for 
	 * understanding of the patient situation, and can add referrals for tests to the 
	 * patients file, provided the patient shares his user ID. 
	 * @param frame allows for sub-frames of other necessary frames to use the same JFrame
	 * @param doctorUser makes sure that the frame is being user for the correct User only
	 * 
	 */
	public DoctorPage (JFrame frame, Doctor doctorUser) {
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		/**
		 * This button, if pressed, allows the doctorUser to go to his
		 * a frame where he can check which times of the week is available
		 * This is then updated in his userFile
		 */
		
		JButton scheduleAppointmentBtn = new JButton("Set Week Availability");
		scheduleAppointmentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GenerateDoctorSchedule drSched = new GenerateDoctorSchedule(frame, doctorUser.getUserID(), doctorUser);
				frame.setContentPane(drSched);
				frame.setSize(750, 432);
				frame.revalidate();
				System.out.println("button pressed");
				
			}
		});
		scheduleAppointmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		/**
		 * This button is used for the userDoctor to go to the frame
		 * where he can see the times he set as "Available" for patients to book
		 * showing his schedule
		 */
		JButton cancelAppointmentBtn = new JButton("See My Schedule");
		cancelAppointmentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				ReviewSchedule RS = new ReviewSchedule(frame, doctorUser);
				frame.setContentPane(RS);
				frame.setSize(750, 432);
				frame.revalidate();
				
			}
		});
		cancelAppointmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		/**
		 * This button works as, if clicked, takes the 
		 * userDoctor to a frame where he can right a test referal for a patient
		 * on his file so he can refer to that
		 */
		JButton btnSeeCoworkers = new JButton("Give Patient Referral\r\n");
		btnSeeCoworkers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientReferral referral = new PatientReferral(frame, doctorUser);
				frame.setContentPane(referral);
				frame.setSize(750, 432);
				frame.revalidate();
			}
		});
		btnSeeCoworkers.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		/**
		 * This button, if clicked, takes the userDoctor to a frame where he must
		 * enter the patient ID, and subsequentially is able to see the patients record
		 * and any other referals made
		 */
		JButton btnSeePatientsRecord = new JButton("See Patients Record");
		btnSeePatientsRecord.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PatientIDInput input = new PatientIDInput(frame, doctorUser);
				frame.setContentPane(input);
				frame.setSize(750, 432);
				frame.revalidate();
			}
		});
		btnSeePatientsRecord.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(scheduleAppointmentBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
						.addComponent(cancelAppointmentBtn, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(btnSeeCoworkers, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnSeePatientsRecord, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(25)
					.addComponent(scheduleAppointmentBtn)
					.addGap(18)
					.addComponent(cancelAppointmentBtn)
					.addGap(18)
					.addComponent(btnSeeCoworkers, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnSeePatientsRecord, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(49, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel nameLbL = new JLabel("New label");
		nameLbL.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		nameLbL.setText("Welcome " + doctorUser.getFirstName() + " " + doctorUser.getLastName() + " !");
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		/**
		 * This button, if clicked, takes the userDoctor to a frame
		 * in which he can update and change his own info on record
		 */
		JButton updateInfoBtn = new JButton("Update My Information");
		updateInfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Update info button pressed");
				UpdateInfo updateInfoPatient = new UpdateInfo(frame, Database.getUser(doctorUser.getUserID()), Database.getUser(doctorUser.getUserID()));
				frame.setContentPane(updateInfoPatient);
				frame.setSize(657, 432);
				frame.revalidate();	
			}
		});
		updateInfoBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, Alignment.TRAILING))
					.addGap(98))
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
					.addGap(111)
					.addComponent(updateInfoBtn, GroupLayout.PREFERRED_SIZE, 202, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(111, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_panel2.createSequentialGroup()
					.addGap(93)
					.addComponent(nameLbL)
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(nameLbL)
					.addGap(81)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(updateInfoBtn, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(53, Short.MAX_VALUE))
		);
		panel2.setLayout(gl_panel2);
		
		JLabel hospitalNameLbl = new JLabel("Welcome to AHS Hospital Management System");
		hospitalNameLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		/**
		 * Allos the userDoctor to logout from the system when he clicks this button
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
		logoutBtn.setBackground(Color.LIGHT_GRAY);
		logoutBtn.setForeground(Color.BLACK);
		logoutBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(112, Short.MAX_VALUE)
					.addComponent(hospitalNameLbl)
					.addGap(30)
					.addComponent(logoutBtn))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(logoutBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(17, Short.MAX_VALUE)
					.addComponent(hospitalNameLbl)
					.addGap(4))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
	}
}
