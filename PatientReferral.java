import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientReferral extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the panel.
	 * @param frame utilized to pass frame back to go back to main
	 * page GUI class
	 */
	public PatientReferral(JFrame frame, Doctor user) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Patient's ID:");
		
		//This textfield takes in the userID for the Patient to write the referral on
		textField = new JTextField();
		textField.setColumns(10);
		
		//This label is beside the textfield that takes in the name of the doctor writing this referral
		JLabel lblNewLabel_2 = new JLabel("Doctor's Name: ");
		
		//This label is beside the textfield that takes in the possible conditions the doctor things the patient has
		JLabel lblNewLabel_2_1 = new JLabel("Pressumed Condition(s):");
		
		//This label is beside the textfield that takes in the first test the doctor things the patient needs to get done
		JLabel lblNewLabel_2_1_1 = new JLabel("Test 1:");
		
		//This label is beside the textfield that takes in the second potentially necessary test
		JLabel lblNewLabel_2_1_1_1 = new JLabel("Test 2:");
		
		//This label is beside the textfield that takes in the third potentially necessary textField
		JLabel lblNewLabel_2_1_1_1_1 = new JLabel("Test 3:");
		
		//This label is beside the textfield that takes in a short description of what the doctor thinks of the patients medical condition
		JLabel lblNewLabel_2_1_1_1_1_1 = new JLabel("Medical Opinion:");
		
		//TextField for doctors name
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		//Textfield for pressumed conditions
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		//Textfield to take in the presumed conditions
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		//Textfield to take in first test
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		//Textfield to take in the second test
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		
		//Textfield to take in the third test
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		
		//This button is pressed for the information of the referral in the textfields
		//to be written onto the Patiet's file
		JButton btnNewButton = new JButton("Done (Press to Save)");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String patientFileName = textField.getText();
				
				/**
				 * The following lines of code regarding FileIO are used to append all the information 
				 * on the patient file and is where the referral is added
				 */
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					//Using location and patient file to find pathname to file
					fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println(textField_1.getText());
					pw.println(textField_2.getText());
					pw.println(textField_3.getText());
					pw.println(textField_4.getText());
					pw.println(textField_5.getText());
					pw.println(textField_6.getText());
					pw.close();bw.close();fw.close();
					
				}catch(IOException error) {
					error.printStackTrace();
				}
			}
		});
		
		/**
		 *Button that, when clicked, goes back to the normal Doctor's page
		 */
		JButton btnNewButton_1 = new JButton("Go Back (After Save)");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoctorPage panel = new DoctorPage(frame, user);
				frame.setContentPane(panel);
				frame.revalidate();
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		/**
		 * Button that, when clicked, goes to logout page and logs doctor out of the system
		 */
		
		JButton btnNewButton_2 = new JButton("Logout");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				LogoutPage panel = new LogoutPage(frame);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addGap(10)
							.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2_1_1_1_1_1, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE))
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_1)
								.addComponent(lblNewLabel_2)
								.addComponent(lblNewLabel_2_1))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(btnNewButton))
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 121, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton_1)
										.addComponent(btnNewButton_2))))
							.addGap(141)))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(31)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNewLabel_2)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1)
							.addGap(1)
							.addComponent(btnNewButton_2)))
					.addGap(11)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2_1_1_1))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1_1_1)
						.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2_1_1_1_1_1)
						.addComponent(textField_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Write Referral and Review onto Patient's File");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel.add(lblNewLabel);
		setLayout(groupLayout);
		

	}
}
