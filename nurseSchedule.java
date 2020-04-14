import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.SystemColor;

public class nurseSchedule extends JPanel {
	
	private JTextField idTextField;
	private JTextField mondayTextField;
	private JTextField tuesdayTextField;
	private JTextField wednesdayTextField;
	private JTextField thursdayTextField;
	private JTextField fridayTextField;

	public nurseSchedule(JFrame frame, Admin adminUser, Users selectedUser) {
	setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 571, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 370, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 183, GroupLayout.PREFERRED_SIZE)))
					.addGap(347))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 311, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 307, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("Nurse Schedule Builder");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JButton homeBtn = new JButton("Home");
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(204, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(81)
					.addComponent(homeBtn))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(homeBtn)
					.addContainerGap(29, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel_2.createSequentialGroup()
					.addContainerGap(20, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addContainerGap())
		);
		panel_2.setLayout(gl_panel_2);
		
		JButton doneButton = new JButton("Done");
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				FileSystem file = new FileSystem(idTextField.getText());
				ArrayList<String> schedule = new ArrayList<String>();
				file.writeToFile(file.getFile(), mondayTextField.getText());
				file.writeToFile(file.getFile(), tuesdayTextField.getText());
				file.writeToFile(file.getFile(), wednesdayTextField.getText());
				file.writeToFile(file.getFile(), thursdayTextField.getText());
				file.writeToFile(file.getFile(), fridayTextField.getText());
				Database.load(file.getFile());
				
			}
		});
		
		JButton backButton = new JButton("Back");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AdminPage panel = new AdminPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.resize(675,460);
				frame.revalidate();
			}
		});
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_4.createSequentialGroup()
					.addGap(57)
					.addGroup(gl_panel_4.createParallelGroup(Alignment.TRAILING)
						.addComponent(doneButton)
						.addComponent(backButton))
					.addContainerGap(57, Short.MAX_VALUE))
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_4.createSequentialGroup()
					.addContainerGap(89, Short.MAX_VALUE)
					.addComponent(doneButton)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(backButton)
					.addGap(144))
		);
		panel_4.setLayout(gl_panel_4);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel_3.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID of the nurse:");
		
		idTextField = new JTextField();
		idTextField.setBackground(SystemColor.control);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" Enter the times in the");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		
		JLabel lblNewLabel_3 = new JLabel("corresponding days");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		
		JLabel mondayLabel = new JLabel("Monday: ");
		mondayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		mondayTextField = new JTextField();
		mondayTextField.setBackground(SystemColor.control);
		mondayTextField.setColumns(10);
		
		JLabel tuesdayLabel = new JLabel("Tuesday: ");
		tuesdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		tuesdayTextField = new JTextField();
		tuesdayTextField.setBackground(SystemColor.control);
		tuesdayTextField.setColumns(10);
		
		JLabel wednesdayLabel = new JLabel("Wednesday: ");
		wednesdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		wednesdayTextField = new JTextField();
		wednesdayTextField.setBackground(SystemColor.control);
		wednesdayTextField.setColumns(10);
		
		JLabel thursdayLabel = new JLabel("Thursday: ");
		thursdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		thursdayTextField = new JTextField();
		thursdayTextField.setBackground(SystemColor.control);
		thursdayTextField.setColumns(10);
		
		JLabel fridayLabel = new JLabel("Friday: ");
		fridayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		fridayTextField = new JTextField();
		fridayTextField.setBackground(SystemColor.control);
		fridayTextField.setColumns(10);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(mondayLabel)
					.addGap(5)
					.addComponent(mondayTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(88)
					.addComponent(tuesdayLabel)
					.addGap(5)
					.addComponent(tuesdayTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(68)
					.addComponent(wednesdayLabel)
					.addGap(5)
					.addComponent(wednesdayTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(83)
					.addComponent(thursdayLabel)
					.addGap(5)
					.addComponent(thursdayTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(106)
					.addComponent(fridayLabel)
					.addGap(5)
					.addComponent(fridayTextField, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(lblNewLabel_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addGap(23))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(3)
					.addComponent(lblNewLabel_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(idTextField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(idTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(mondayLabel))
						.addComponent(mondayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(tuesdayLabel))
						.addComponent(tuesdayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(wednesdayLabel))
						.addComponent(wednesdayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(thursdayLabel))
						.addComponent(thursdayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(5)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(fridayLabel))
						.addComponent(fridayTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(64))
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(gl_panel_1);

	}
}

