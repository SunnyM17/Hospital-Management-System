import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.SoftBevelBorder;
import java.awt.SystemColor;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.JPasswordField;

public class Register extends JPanel {
	private JTextField firstName;
	private JTextField lastName;
	private JTextField email;
	private JTextField address;
	private JTextField phoneNum;
	private JPasswordField passField;
	private JPasswordField confirmPassField;

	/**
	 * Create the panel.
	 */
	public Register(JFrame frame, Authorize newUser) {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(SystemColor.text);
		
		firstName = new JTextField();
		firstName.setColumns(10);
		
		JLabel firstNameLbl = new JLabel("First Name");
		JLabel passLbl = new JLabel("Password");
		JLabel lastNameLbl = new JLabel("Last Name");
		
		lastName = new JTextField();
		lastName.setColumns(10);
		
		JList list = new JList();
		list.setBackground(SystemColor.control);
		
		JButton registerBtn = new JButton("Done");
		registerBtn.setForeground(Color.BLACK);
		registerBtn.setBackground(SystemColor.control);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int type = list.getSelectedIndex();
				int id = newUser.register(firstName.getText(), lastName.getText(), email.getText(), phoneNum.getText(), address.getText(), passField.getText(),confirmPassField.getText(), type);
					
				if(id!=-1) {
					DisplayID panel = new DisplayID(frame, newUser, id);
					frame.setContentPane(panel);
					frame.setSize(499, 303);
					frame.revalidate();	
				}
			}
		});
		
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setModel(new AbstractListModel() {
			String[] values = new String[] {"Admin", "Doctor", "Patient", "Assistant"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		
		JLabel emailLbl = new JLabel("Email");
		
		JLabel addressLbl = new JLabel("Address");
		
		email = new JTextField();
		email.setColumns(10);
		
		address = new JTextField();
		address.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Phone Number");
		
		phoneNum = new JTextField();
		phoneNum.setColumns(10);
		
		JLabel confirmPassLbl = new JLabel("Confirm Password");
		
		JLabel titleLbl = new JLabel("Register");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel selectionLbl = new JLabel("Select One");
		
		passField = new JPasswordField();
		
		confirmPassField = new JPasswordField();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(23)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(lastNameLbl)
						.addComponent(firstNameLbl)
						.addComponent(emailLbl)
						.addComponent(addressLbl)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(email, 0, 0, Short.MAX_VALUE)
						.addComponent(phoneNum, 0, 0, Short.MAX_VALUE)
						.addComponent(address, GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lastName, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
								.addComponent(firstName, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(32)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(passLbl, Alignment.TRAILING)
						.addComponent(selectionLbl, Alignment.TRAILING)
						.addComponent(confirmPassLbl, Alignment.TRAILING))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(list, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
						.addComponent(passField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
						.addComponent(confirmPassField, GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE))
					.addContainerGap())
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(265, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(registerBtn)
						.addComponent(titleLbl))
					.addGap(260))
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
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lastNameLbl, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
						.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(confirmPassLbl)
						.addComponent(confirmPassField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(emailLbl)
								.addComponent(email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(addressLbl)
								.addComponent(address, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(lblNewLabel_2))
								.addGroup(groupLayout.createSequentialGroup()
									.addGap(11)
									.addComponent(phoneNum, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(21)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 98, GroupLayout.PREFERRED_SIZE)
								.addComponent(selectionLbl))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(registerBtn)))
					.addGap(20))
		);
		setLayout(groupLayout);
		
		

	}
}
