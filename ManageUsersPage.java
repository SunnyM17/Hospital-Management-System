import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class ManageUsersPage extends JPanel {

	/**
	 * JPanel for GUI so that the administrator is able
	 * to edit, delete and add users
	 */
	public ManageUsersPage(JFrame frame, Admin adminUser) {
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Select a User to Edit or Delete");
		JList userList = new JList();
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel2, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, 0, 0, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 293, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton deleteBtn = new JButton("Delete User");
		deleteBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Gets the ID of the selected user
				String selectedUser = (String) userList.getSelectedValue();
				selectedUser= selectedUser.substring(0,7);
				System.out.println(selectedUser);
				
				adminUser.deleteUser(Integer.parseInt(selectedUser));
				// Displays the Manage Users panel
				ManageUsersPage panel = new ManageUsersPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.revalidate();	
		
			}
		});
		
		JButton editBtn = new JButton("Edit User");
		editBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				// Gets the ID of the selected user
				String id = (String) userList.getSelectedValue();
				id= id.substring(0,7);
				
				// Displays the update information panel
				UpdateInfo panel = new UpdateInfo(frame, Database.getUser(adminUser.getUserID()), Database.getUser(Integer.parseInt(id)));
				frame.setContentPane(panel);
				frame.setSize(640, 470);
				frame.revalidate();	

			}
		});
		
		JButton addBtn = new JButton("Add New User");
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Authorize auth = new Authorize();
				
				// Displays the register panel
				Register panel = new Register(frame, auth, adminUser);
				frame.setContentPane(panel);
				frame.setSize(602, 330);
				frame.revalidate();	
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
							.addGap(86)
							.addComponent(editBtn, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
							.addGap(46)
							.addComponent(deleteBtn)
							.addGap(44)
							.addComponent(addBtn)))
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
					.addGap(18)
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(addBtn)
						.addComponent(deleteBtn)
						.addComponent(editBtn))
					.addGap(23))
		);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		
		// Creates a list of all users
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setModel(new AbstractListModel() {
			String[] values = Hospital.getListOfUsers(Database.getAllUsers());
			
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(userList);
		
		
		panel2.setLayout(gl_panel2);
		
		JLabel titleLbl = new JLabel("Manage Users");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				// Displays the administrator's home page
				AdminPage panel = new AdminPage(frame, adminUser);
				frame.setContentPane(panel);
				frame.revalidate();
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
