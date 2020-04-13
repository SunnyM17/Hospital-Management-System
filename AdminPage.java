import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLayeredPane;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 * Displays the page that the Administrator will see
 * when it logins to the system.
 */
public class AdminPage extends JPanel {

	public AdminPage(JFrame frame, Admin adminUser) {
		
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
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel3, GroupLayout.PREFERRED_SIZE, 205, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 403, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGap(32))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel2, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
						.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE))
					.addContainerGap())
		);
		
		JButton manageEmployeesBtn = new JButton("Manage Users");
		manageEmployeesBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				ManageUsersPage panel = new ManageUsersPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.revalidate();	
				
			}
		});
		manageEmployeesBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton statsBtn = new JButton("Generate Statistics");
		statsBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				GenerateStatsPage panel = new GenerateStatsPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		statsBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton addDepartmentBtn = new JButton("Add Department");
		addDepartmentBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				AddDepartmentPage panel = new AddDepartmentPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.revalidate();	
			}
		});
		addDepartmentBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton btnNewButton = new JButton("Manage Nurse's Schedule");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(manageEmployeesBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 154, Short.MAX_VALUE)
						.addComponent(statsBtn, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addComponent(addDepartmentBtn, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(58)
					.addComponent(manageEmployeesBtn)
					.addGap(29)
					.addComponent(statsBtn)
					.addGap(27)
					.addComponent(addDepartmentBtn)
					.addGap(26)
					.addComponent(btnNewButton)
					.addContainerGap(50, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLabel nameLbL = new JLabel("New label");
		nameLbL.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		nameLbL.setText("Welcome " + adminUser.getFirstName() + " " + adminUser.getLastName() + " !");
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, Alignment.TRAILING))
					.addContainerGap(423, Short.MAX_VALUE))
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap(54, Short.MAX_VALUE)
					.addComponent(nameLbL)
					.addGap(132))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(111)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameLbL)
					.addContainerGap(183, Short.MAX_VALUE))
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
					.addContainerGap(68, Short.MAX_VALUE)
					.addComponent(hospitalNameLbl)
					.addGap(26)
					.addComponent(logoutBtn))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(logoutBtn)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(hospitalNameLbl)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		
	}
}
