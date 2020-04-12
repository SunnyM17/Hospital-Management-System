import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.MatteBorder;
import javax.swing.SwingConstants;

/**
 * A user is able to edit/change it's personal information.
 *
 */
public class EditUserPage extends JPanel {

	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField address;
	private JTextField phoneNum;
	private JPasswordField passField;
	private JPasswordField confirmPassField;
	
	/**
	 * Class Constructor
	 * 
	 * @param frame			JFrame that the panel should be displayed on.
	 * @param currentUser	The user that is editing
	 * @param editedUser	The user that needs to be edited
	 */
	public EditUserPage(JFrame frame, Users currentUser, Users editedUser) {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(SystemColor.text);
		
		firstName = new JTextField(editedUser.getFirstName());
		firstName.setColumns(10);
		
		JLabel firstNameLbl = new JLabel("First Name");
		JLabel passLbl = new JLabel("Password");
		JLabel lastNameLbl = new JLabel("Last Name");
		
		lastName = new JTextField(editedUser.getLastName());
		lastName.setColumns(10);
		
		JLabel errorLbl = new JLabel("There was an error. Try Again!");
		JButton doneBtn = new JButton("Done");
		doneBtn.setForeground(Color.BLACK);
		doneBtn.setBackground(SystemColor.control);
		doneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				Users tempUser = new Users(firstName.getText(), lastName.getText(), editedUser.getUserID(),  passField.getText(), email.getText(), address.getText(), phoneNum.getText());
				boolean check= Authorize.updateInformation(tempUser, confirmPassField.getText());
					
				if(check) {	
					errorLbl.setVisible(false);
						
					// gets the type of user
					int value = currentUser.getUserID()/1000000;
					if(value == 1) {
						ManageUsersPage panel = new ManageUsersPage(frame, Database.getAdmin(currentUser.getUserID()));
						frame.setContentPane(panel);
						frame.setSize(700, 450);
						frame.revalidate();
					}
					
				} else {
					errorLbl.setVisible(true);
				}
				
			}
		});
		
		JLabel emailLbl = new JLabel("Email");
		
		JLabel addressLbl = new JLabel("Address");
		
		email = new JTextField(editedUser.getEmail());
		email.setColumns(10);
		
		address = new JTextField(editedUser.getAddress());
		address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		
		phoneNum = new JTextField(editedUser.getPhoneNum());
		phoneNum.setColumns(10);
		
		JLabel confirmPassLbl = new JLabel("Confirm Password");
		
		JLabel titleLbl = new JLabel("Register");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		passField = new JPasswordField(editedUser.getPassword());
		
		confirmPassField = new JPasswordField(editedUser.getPassword());
		
		errorLbl.setVisible(false);
		
		errorLbl.setFont(new Font("Tahoma", Font.BOLD, 16));
		errorLbl.setHorizontalAlignment(SwingConstants.CENTER);
		errorLbl.setForeground(Color.RED);
		
		JLabel instructionPassLabel = new JLabel("*At least 8 characters");
		instructionPassLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		instructionPassLabel.setForeground(Color.GRAY);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(26)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(firstNameLbl)
								.addComponent(lastNameLbl)
								.addComponent(emailLbl)
								.addComponent(addressLbl))
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(lastName, Alignment.TRAILING, 0, 0, Short.MAX_VALUE)
						.addComponent(firstName, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
						.addComponent(email, 0, 0, Short.MAX_VALUE)
						.addComponent(address, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
						.addComponent(phoneNum, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(passLbl)
						.addComponent(confirmPassLbl))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(confirmPassField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(passField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
						.addComponent(instructionPassLabel)
						.addComponent(doneBtn))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(278, Short.MAX_VALUE)
					.addComponent(titleLbl)
					.addGap(268))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(164)
					.addComponent(errorLbl, GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
					.addGap(137))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(titleLbl)
					.addGap(24)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(firstNameLbl)
						.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passLbl)
						.addComponent(passField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(lastNameLbl, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
									.addComponent(emailLbl)
									.addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(confirmPassLbl))
								.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addComponent(instructionPassLabel))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(addressLbl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(phoneNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2)))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(30)
							.addComponent(doneBtn)))
					.addGap(25)
					.addComponent(errorLbl)
					.addContainerGap())
		);
		setLayout(groupLayout);
		
	}
}