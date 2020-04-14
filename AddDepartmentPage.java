import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLayeredPane;
import javax.swing.JList;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;


public class AddDepartmentPage extends JPanel {
	private JTextField departmentField;

	/** displays page for user to add a new department to the hospital
	 * This can only be accessed by administration staff
	 * 
	 * @param frame allows for sub-frames of other necessary frames to use the same JFrame
	 * @param adminUser makes sure that the frame is being user for the correct User only
	 *  */	
	public AddDepartmentPage(JFrame frame, Admin adminUser) {
		JPanel panel2 = new JPanel();
		panel2.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1 = new JLabel("Departments");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
						.addComponent(panel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel2, GroupLayout.PREFERRED_SIZE, 298, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("");
		
		JLayeredPane layeredPane = new JLayeredPane();
		
		JScrollPane scrollPane = new JScrollPane();
		
		departmentField = new JTextField();
		departmentField.setColumns(10);
		
		JLabel errorLbl = new JLabel("This department already exists!");;
		JButton addBtn = new JButton("Add");
		addBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(adminUser.addDepartment(departmentField.getText().toLowerCase())) {
					AddDepartmentPage panel = new AddDepartmentPage(frame, adminUser);
					errorLbl.setVisible(false);
					frame.setContentPane(panel);
					frame.revalidate();	
				} else {
					errorLbl.setVisible(true);
				}
			}
		});
		
		JLabel lblNewLabel_2 = new JLabel("Enter the name of the department");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		errorLbl.setVisible(false);
		
		errorLbl.setFont(new Font("Tahoma", Font.PLAIN, 17));
		errorLbl.setForeground(Color.RED);
		GroupLayout gl_panel2 = new GroupLayout(panel2);
		gl_panel2.setHorizontalGroup(
			gl_panel2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel, Alignment.TRAILING))
					.addGap(23)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 228, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addGroup(gl_panel2.createSequentialGroup()
							.addComponent(departmentField, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE))
						.addComponent(errorLbl))
					.addGap(48))
		);
		gl_panel2.setVerticalGroup(
			gl_panel2.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel2.createSequentialGroup()
					.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel2.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_panel2.createParallelGroup(Alignment.LEADING)
								.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel2.createSequentialGroup()
									.addComponent(layeredPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addGap(113)
									.addComponent(lblNewLabel))))
						.addGroup(gl_panel2.createSequentialGroup()
							.addGap(70)
							.addComponent(lblNewLabel_2)
							.addGap(39)
							.addGroup(gl_panel2.createParallelGroup(Alignment.BASELINE)
								.addComponent(addBtn)
								.addComponent(departmentField, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							.addGap(28)
							.addComponent(errorLbl)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		scrollPane.setColumnHeaderView(lblNewLabel_1);
		
		// Turns an arrayList into an array
		
		
		JList list = new JList();
		list.setSelectedIndex(0);
		list.setModel(new AbstractListModel() {
			String[] values = Hospital.getArrDepartments();
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		
		panel2.setLayout(gl_panel2);
		
		JLabel titleLbl = new JLabel("Add Department");
		titleLbl.setFont(new Font("Tahoma", Font.BOLD, 19));
		
		JButton homeBtn = new JButton("Home");
		homeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
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
