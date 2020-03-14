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

public class Register extends JPanel {
	private JTextField firstName;
	private JTextField lastName;
	private JTextField password;

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
		
		JLabel titleLbl = new JLabel("Register");
		titleLbl.setForeground(Color.BLACK);
		titleLbl.setFont(new Font("Serif", Font.BOLD, 20));
		
		password = new JTextField();
		password.setColumns(10);
		
		JList list = new JList();
		list.setBackground(SystemColor.control);
		
		JButton registerBtn = new JButton("Register");
		registerBtn.setForeground(Color.BLACK);
		registerBtn.setBackground(SystemColor.control);
		registerBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String name1 = firstName.getText();
				String name2 = lastName.getText();
				String pass = password.getText();
				int type = list.getSelectedIndex();
				int id = newUser.register(name1, name2, pass, type);
				
				if(id!=-1) {
					DisplayID panel = new DisplayID(frame, newUser, id);
					frame.setContentPane(panel);
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
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(93)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(firstNameLbl)
								.addComponent(lastNameLbl)
								.addComponent(passLbl))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(registerBtn)
								.addGroup(groupLayout.createSequentialGroup()
									.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
										.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
									.addGap(18)
									.addComponent(list, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE))))
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(201)
							.addComponent(titleLbl)))
					.addContainerGap(74, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(90)
							.addComponent(list, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(titleLbl)
							.addGap(34)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(firstName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(firstNameLbl))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lastName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lastNameLbl))
							.addGap(18)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(password, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(passLbl))))
					.addGap(28)
					.addComponent(registerBtn)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		setLayout(groupLayout);
		
		

	}
}
