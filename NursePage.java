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
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NursePage extends JPanel {

	/**
	 * JPanel for GUI for what a nurse sees then they log in to the system
	 * Nurse is able to view their schedule and edit patient record
	 */
	public NursePage(JFrame frame, Users nurseUser) {
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
		
		JButton viewScheduleBtn = new JButton("View Schedule");
		viewScheduleBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("View schedule button pressed");
				
			}
		});
		viewScheduleBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JButton viewPatientBtn = new JButton("View Patient Record");
		viewPatientBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.out.println("View Patient Record button pressed");
			}
		});
		viewPatientBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		

		
		GroupLayout gl_panel3 = new GroupLayout(panel3);
		gl_panel3.setHorizontalGroup(
			gl_panel3.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
						.addComponent(viewScheduleBtn, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 248, Short.MAX_VALUE)
						.addComponent(viewPatientBtn, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel3.setVerticalGroup(
			gl_panel3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel3.createSequentialGroup()
					.addGap(25)
					.addComponent(viewScheduleBtn)
					.addGap(29)
					.addComponent(viewPatientBtn)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		panel3.setLayout(gl_panel3);
		
		JLabel nameLbL = new JLabel("New label");
		nameLbL.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		nameLbL.setText("Welcome " + nurseUser.getFirstName() + " " + nurseUser.getLastName() + " !");
		
		JLayeredPane layeredPane = new JLayeredPane();
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(93)
							.addComponent(nameLbL)))
					.addContainerGap(93, Short.MAX_VALUE))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(nameLbL)
					.addContainerGap(318, Short.MAX_VALUE))
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
