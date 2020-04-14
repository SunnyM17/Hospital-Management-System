import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class PatientIDInput extends JPanel {
	private JTextField textField;

	/**
	 * Creates the panel
	 */
	public PatientIDInput(JFrame frame, Doctor user) {
		
		JLabel lblNewLabel = new JLabel("Enter Patient ID to fetch Record: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		
		/**
		 * The textField will be used to hold the Doctor-inputed patient user ID
		 * He does this so he can view the patient's record in the following frame
		 * All this has to be with patient permission, else the Dr. would not have the ID
		 */
		textField = new JTextField();
		textField.setColumns(10);
		
		
		JLabel errorLbl = new JLabel("Try again. Patient number does not exist");
		errorLbl.setForeground(Color.RED);
		errorLbl.setVisible(false);
		
		/**
		 * When this button is clicked, because of the MouseListener, 
		 * The Doctor is taken to the next frame where he can see the patient's file
		 * If the value entered is not a number, a NumberFormatException is thrown
		 */
		
		JButton btnNewButton = new JButton("See Record");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					int userID = Integer.parseInt(textField.getText());
					if (Database.getAllPatients().containsKey(userID)) {
						PatientRecordPeak patientRec = new PatientRecordPeak(userID, frame, user);
						frame.setContentPane(patientRec);
						frame.revalidate();
					} else {
						errorLbl.setVisible(true);
						System.out.println("Patient does not exist");
					}
				} catch (NumberFormatException nfe) {
					errorLbl.setText("Please enter  number");
					errorLbl.setVisible(true);
					System.out.println("Number format exception");
					nfe.printStackTrace();
				}
				
			}
		});
		
		/* Returns back to doctor's home page */
		JButton backBtn = new JButton("Back to Home");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				DoctorPage drPanel = new DoctorPage(frame, user);
				frame.setContentPane(drPanel);
				frame.revalidate();	
			}
		});
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(81)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel)
						.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 155, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(btnNewButton)
						.addComponent(errorLbl)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(111, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(126, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(27)
					.addComponent(errorLbl)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(backBtn))
					.addGap(86))
		);
		setLayout(groupLayout);

	}
}
