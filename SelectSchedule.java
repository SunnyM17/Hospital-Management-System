import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class SelectSchedule extends JPanel {

	/**
	 * Create the panel.
	 */
	public SelectSchedule(JFrame frame, Users currentUser, Map<Integer, Users> users) {
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Select a user");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		JList userList = new JList();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 670, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton viewBtn = new JButton("View");
		viewBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				String some = (String) userList.getSelectedValue();
				some = some.substring(0,7);
				System.out.println(some);
				
				
			}
		});
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel, Alignment.TRAILING))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 589, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(261)
							.addComponent(viewBtn)))
					.addContainerGap())
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel2.createSequentialGroup()
							.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(113)
							.addComponent(lblNewLabel)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(viewBtn)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		
		
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setModel(new AbstractListModel() {
			String[] values = Hospital.getListOfUsers(users);
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(userList);
		
		
		panel2.setLayout(gl_panel2);
		
		JLabel titleLbl = new JLabel("View Schedule");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int value = currentUser.getUserID()/1000000;
				/* ID starts with 1, go to admin GUI */
				if(value == 1) {
					AdminPage panel = new AdminPage(frame, Database.getAdmin(currentUser.getUserID()));
					frame.setContentPane(panel);
					frame.setSize(667, 432);
					frame.revalidate();	
				}
				/* ID starts with 2, go to doctor GUI */
				else if(value == 2) {
				}
				/* ID starts with 3, go to patient GUI */
				else if(value == 3) {
					PatientPage patientPanel = new PatientPage(frame, Database.getPatient(currentUser.getUserID()));
					frame.setContentPane(patientPanel);
					frame.setSize(657, 432);
					frame.revalidate();	
				}
				/* ID starts with 4, go to assistant GUI */
				else if(value == 4) {
					AssistantPage patientPanel = new AssistantPage(frame, Database.getAssistant(currentUser.getUserID()));
					frame.setContentPane(patientPanel);
					frame.setSize(657, 432);
					frame.revalidate();	
				}

				
			}
		});
		homeBtn.setBackground(Color.LIGHT_GRAY);
		homeBtn.setForeground(Color.BLACK);
		homeBtn.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(244, Short.MAX_VALUE)
					.addComponent(titleLbl)
					.addGap(164)
					.addComponent(homeBtn))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(homeBtn)
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(titleLbl)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);
		
		
	}
	
}

