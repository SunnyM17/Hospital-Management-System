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
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class UpdateInfo extends JPanel {
	private JTextField firstNameTextField;
	private JTextField lastNameTextField;
	private JTextField emailTextField;
	private JTextField addressTextField;
	private JTextField phoneTextField;
	private JPasswordField pwTextField;

	/**
	 * Panel for patients to update their personal information.
	 * When user enters this panel, textfields are filled in with their current personal info
	 * User can update the textfield and set specific personal info
	 */
	public UpdateInfo(JFrame frame, Patient patientUser) {
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 715, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(617, 134, 0, 0);
		
		JLabel nameLbL = new JLabel("Update your personal information here");
		nameLbL.setBounds(138, 16, 350, 17);
		nameLbL.setHorizontalAlignment(SwingConstants.CENTER);
		nameLbL.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(616, 16, 1, 1);
		
		JButton updateBtn = new JButton("Save and go Back");
		updateBtn.setBounds(389, 268, 202, 25);
		updateBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Update info button pressed");
				/* convert all JTextField into string */
				
				patientUser.setFirstName(firstNameTextField.getText());
				patientUser.setLastName(lastNameTextField.getText());
				patientUser.setEmail(emailTextField.getText());
				patientUser.setAddress(addressTextField.getText());
				patientUser.setPhoneNum(phoneTextField.getText());
				try {
				patientUser.setPassword(new String(pwTextField.getPassword()));
				} catch(Exception pwException) {
					pwException.printStackTrace();
				}
				FileSystem newFile = new FileSystem(""+patientUser.getUserID());
				newFile.writeGeneralInfoFile(newFile.getFile(), patientUser);
				// load into database
				Database.load(newFile.getFile());
				PatientPage updatedPatientPage = new PatientPage(frame, patientUser);
				frame.setContentPane(updatedPatientPage);
				frame.setSize(657, 432);
				frame.revalidate();	
				
			}
		});
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel firstNameLbl = new JLabel("First Name");
		firstNameLbl.setBounds(15, 65, 76, 20);
		
		/* textfield gets and displays current first name */
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(137, 62, 202, 26);
		firstNameTextField.setColumns(10);
		firstNameTextField.setText(patientUser.getFirstName());
		panel2.setLayout(null);
		panel2.add(nameLbL);
		panel2.add(layeredPane);
		panel2.add(lblNewLabel);
		panel2.add(updateBtn);
		panel2.add(firstNameLbl);
		panel2.add(firstNameTextField);
		
		/* textfield gets and displays current last name */
		lastNameTextField = new JTextField();
		lastNameTextField.setText(patientUser.getLastName());
		lastNameTextField.setColumns(10);
		lastNameTextField.setBounds(137, 104, 202, 26);
		panel2.add(lastNameTextField);
		
		JLabel lasatNameLbl = new JLabel("Last Name");
		lasatNameLbl.setBounds(15, 107, 76, 20);
		panel2.add(lasatNameLbl);
		
		/* textfield gets and displays current email */
		emailTextField = new JTextField();
		emailTextField.setText(patientUser.getEmail());
		emailTextField.setColumns(10);
		emailTextField.setBounds(137, 144, 202, 26);
		panel2.add(emailTextField);
		
		JLabel emailLbl = new JLabel("Email");
		emailLbl.setBounds(15, 147, 76, 20);
		panel2.add(emailLbl);
		
		/* textfield gets and displays current address */
		addressTextField = new JTextField();
		addressTextField.setText(patientUser.getAddress());
		addressTextField.setColumns(10);
		addressTextField.setBounds(137, 184, 202, 26);
		panel2.add(addressTextField);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setBounds(15, 187, 76, 20);
		panel2.add(addressLbl);
		
		/* textfield gets and displays current phone number */
		phoneTextField = new JTextField();
		phoneTextField.setText(patientUser.getPhoneNum());
		phoneTextField.setColumns(10);
		phoneTextField.setBounds(137, 225, 202, 26);
		panel2.add(phoneTextField);
		
		JLabel phoneLbl = new JLabel("Phone Number");
		phoneLbl.setBounds(15, 228, 117, 20);
		panel2.add(phoneLbl);
		
		/* textfield gets and displays current password as dots */
		pwTextField = new JPasswordField();
		pwTextField.setText(patientUser.getPassword());
		pwTextField.setColumns(10);
		pwTextField.setBounds(137, 267, 202, 26);
		panel2.add(pwTextField);
		
		JLabel pwLbl = new JLabel("Password");
		pwLbl.setBounds(15, 270, 117, 20);
		panel2.add(pwLbl);
		
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

