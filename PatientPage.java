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

public class PatientPage extends JPanel {

	/**
	 * JPanel to display GUI that patient will see when they log in to the system.
	 * Gives options for patient to book appointment, upload recommendation
	 */
	public PatientPage(JFrame frame, Patient patientUser) {
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
		
		JButton scheduleAppointmentBtn = new JButton("Schedule Appointment");
		scheduleAppointmentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("button pressed");
				
			}
		});
		scheduleAppointmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton cancelAppointmentBtn = new JButton("Cancel Appointment");
		cancelAppointmentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("Cancel Appointment button pressed");
			}
		});
		cancelAppointmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		/* Text shows up if you successfully upload a file */
		JLabel uploadLbl = new JLabel("File Successfully Uploaded");
		uploadLbl.setHorizontalAlignment(SwingConstants.CENTER);
		uploadLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		uploadLbl.setVisible(false);
		
		/* button for patient to upload referral letter by doctor or physician.
		 * doctor's assistant should be able to access and view file once uploaded
		 */
		JButton uploadRefBtn = new JButton("Upload Referral Letter");
		uploadRefBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Upload Referral button pressed");
				File pdfFile = new File("");
				String startingDir = "C:\\";
				/* File chooser will open dialog with user's C drive as default */
				final JFileChooser uploadFileChooser;
				uploadFileChooser = new JFileChooser(startingDir);
				
				int returnValue = uploadFileChooser.showOpenDialog(null);
				
				/* if file chosen */
				if(returnValue == JFileChooser.APPROVE_OPTION) {
					try {
						/* popup JFileChooser, gets the PDF and its destintation */
						pdfFile = uploadFileChooser.getSelectedFile();
						System.out.println(pdfFile);
						/* Set the destination path of where the referral letter should be stored 
						 * CHANGE destinationPath TO SAVE REFERRAL TO SPECIFIC DIRECTORY*/
						String destinationPath = "C:\\Users\\carme\\Desktop\\dest\\";
						File dest = new File(destinationPath+String.valueOf(patientUser.getUserID())+"_ref.pdf");
						Files.copy(pdfFile.toPath(), dest.toPath());
						uploadLbl.setVisible(true);
						
					} catch(Exception ioe){
						ioe.printStackTrace();
						uploadLbl.setText("Error uploading file");
					}
				} else {
					System.out.println("No file chosen");
				}
				
			}
		});
		uploadRefBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(scheduleAppointmentBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 202, Short.MAX_VALUE)
						.addComponent(cancelAppointmentBtn, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(uploadRefBtn, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE)
						.addComponent(uploadLbl, GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(25)
					.addComponent(scheduleAppointmentBtn)
					.addGap(29)
					.addComponent(cancelAppointmentBtn)
					.addGap(27)
					.addComponent(uploadRefBtn)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(uploadLbl)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel nameLbL = new JLabel("New label");
		nameLbL.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		nameLbL.setText("Welcome " + patientUser.getFirstName() + " " + patientUser.getLastName() + " !");
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JButton updateInfoBtn = new JButton("Update My Information");
		updateInfoBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Update info button pressed");
				UpdateInfo updateInfoPatient = new UpdateInfo(frame, patientUser);
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
