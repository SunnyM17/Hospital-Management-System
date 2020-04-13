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
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class GenerateStatsPage extends JPanel {
	private JTable table;
	private JTable departmentTrafficTbl;
	private JTable usersTbl;
	private JTable trafficTbl;

	/**
	 * Create the panel.
	 */
	public GenerateStatsPage(JFrame frame, Admin adminUser) {
			
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
							.addComponent(panel3, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
							.addComponent(panel, Alignment.LEADING, 0, 0, Short.MAX_VALUE))
						.addContainerGap())
			);
			groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup(Alignment.LEADING)
					.addGroup(groupLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(panel3, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
						.addContainerGap())
			);
			
			JScrollPane scrollPane = new JScrollPane();
			
			JScrollPane scrollPane_1 = new JScrollPane();
			
			JButton doneBtn = new JButton("Done");
			doneBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					
					AdminPage panel = new AdminPage(frame, adminUser);
					frame.setContentPane(panel);
					frame.revalidate();	
					
				}
			});
			
			GroupLayout gl_panel3 = new GroupLayout(panel3);
			gl_panel3.setHorizontalGroup(
				gl_panel3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel3.createSequentialGroup()
						.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel3.createSequentialGroup()
								.addGap(28)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
								.addGap(74)
								.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel3.createSequentialGroup()
								.addGap(255)
								.addComponent(doneBtn)))
						.addContainerGap(43, Short.MAX_VALUE))
			);
			gl_panel3.setVerticalGroup(
				gl_panel3.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_panel3.createSequentialGroup()
						.addGap(32)
						.addGroup(gl_panel3.createParallelGroup(Alignment.LEADING, false)
							.addComponent(scrollPane_1, 0, 0, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
						.addGap(28)
						.addComponent(doneBtn)
						.addContainerGap(30, Short.MAX_VALUE))
			);
			
			//String[] columnName= {"Department", "Num of Patients"};
			trafficTbl = new JTable();
			trafficTbl.setModel(new DefaultTableModel(
				adminUser.getTrafficForDepartments(),
				new String[] {
					"Department" , "Num of Patients"
				}
			));
			scrollPane_1.setViewportView(trafficTbl);
			
			usersTbl = new JTable();
			usersTbl.setModel(new DefaultTableModel(
				new Object[][] {
					{"Administrator", Database.getNumOfUsers(1) },
					{"Doctor", Database.getNumOfUsers(2)},
					{"Nurse", Database.getNumOfUsers(5)},
					{"Assistant", Database.getNumOfUsers(4)},
					{"Patient", Database.getNumOfUsers(3)},
					{null, null},
					{"All Users:", Database.getAllUsers().size()},
				},
				new String[] {
					"Users", "Total"
				}
			));
			scrollPane.setViewportView(usersTbl);
			panel3.setLayout(gl_panel3);
			
			JLabel statsLbl = new JLabel("Statistics");
			statsLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
			
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
						.addContainerGap(270, Short.MAX_VALUE)
						.addComponent(statsLbl)
						.addGap(188)
						.addComponent(logoutBtn))
			);
			gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(statsLbl)
						.addContainerGap())
					.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addComponent(logoutBtn)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			panel.setLayout(gl_panel);
			setLayout(groupLayout);
			
		
	}
}
