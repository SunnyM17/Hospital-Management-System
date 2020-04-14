import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JPasswordField;

public class Login extends JPanel {
	private JTextField idTxtField;
	private JPasswordField passwordField;

	/**
	 * Create the panel.
	 */
	public Login(JFrame frame, Authorize returningUser) {
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setBackground(Color.WHITE);
		
		idTxtField = new JTextField();
		idTxtField.setColumns(10);
		
		JLabel idLbl = new JLabel("ID");
		
		JLabel passLbl = new JLabel("Password");
		
		JLabel errorLbl = new JLabel("ID or password incorrect");
		errorLbl.setForeground(Color.RED);
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		errorLbl.setVisible(false);
		
		JButton doneBtn = new JButton("Enter");
		doneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					int id = Integer.parseInt(idTxtField.getText());
					String pass = passwordField.getText();
					
					boolean temp = returningUser.login(id, pass);
					System.out.println(temp);
					/* print error if username is incorrect (username must be numbers) */
					if(temp == false) {
							errorLbl.setVisible(true);
					}
					
					int value = id/1000000;
					/* ID starts with 1, go to admin GUI */
					if(value == 1 && temp) {
						AdminPage panel = new AdminPage(frame, Database.getAdmin(id));
						frame.setContentPane(panel);
						frame.setSize(657, 432);
						frame.revalidate();	
					}
					/* ID starts with 2, go to doctor GUI */
					else if(value == 2 && temp) {
						System.out.println("doctor login");
						DoctorPage drPanel = new DoctorPage(frame, Database.getDoctor(id));
						frame.setContentPane(drPanel);
						frame.setSize(657, 432);
						frame.revalidate();	
					}
					/* ID starts with 3, go to patient GUI */
					else if(value == 3 && temp) {
						System.out.println("patient login");
						PatientPage patientPanel = new PatientPage(frame, Database.getPatient(id));
						frame.setContentPane(patientPanel);
						frame.setSize(657, 432);
						frame.revalidate();	
					}
					/* ID starts with 4, go to assistant GUI */
					else if(value == 4 && temp) {
						System.out.println("assistant login");
						AssistantPage patientPanel = new AssistantPage(frame, Database.getAssistant(id));
						frame.setContentPane(patientPanel);
						frame.setSize(657, 432);
						frame.revalidate();	
					}
					/* ID starts with 5, go to Nurse GUI */
					else if(value == 5 && temp) {
						System.out.println("nurse login");
						NursePage nursePanel = new NursePage(frame, Database.getNurse(id));
						frame.setContentPane(nursePanel);
						frame.setSize(750, 450);
						frame.revalidate();	
					} else {
						/* in the case that ID does not start with one of the above values */
						System.out.println("Cannot identify login type");
					}
				/* catch exception if username contains more than just numbers */
				} catch(Exception loginEx) {
					errorLbl.setVisible(true);
					loginEx.printStackTrace();
				}	
			}
		});
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		
		passwordField = new JPasswordField();
		
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(57, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(passLbl)
						.addComponent(idLbl))
					.addGap(38)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(doneBtn)
						.addComponent(passwordField)
						.addComponent(loginLbl)
						.addComponent(errorLbl, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(idTxtField, GroupLayout.PREFERRED_SIZE, 177, GroupLayout.PREFERRED_SIZE))
					.addGap(109))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(loginLbl)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idLbl))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passLbl)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
					.addComponent(errorLbl)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(doneBtn)
					.addGap(46))
		);
		setLayout(groupLayout);

	}

}
