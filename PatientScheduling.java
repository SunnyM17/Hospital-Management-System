import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientScheduling extends JPanel {

	/**
	 * JPanel to display the GUI. Allows the patient to 
	 * schedule an appointment based on the doctor's 
	 * schedule.
	 */
	public PatientScheduling(JFrame frame, Patient patientUser, String id) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JPanel panel_1 = new JPanel();
		
		JList mondayList = new JList();
		JList tuesList = new JList();
		JList wedList = new JList();
		JList thursList = new JList();
		JList friList = new JList();
		
		
		panel_1.setBackground(Color.WHITE);
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 687, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 288, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(33, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_5 = new JLabel("Schedule Appointment");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_5.setForeground(Color.BLACK);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				PatientPage panel = new PatientPage(frame, patientUser);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(338, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5)
					.addGap(208)
					.addComponent(btnNewButton))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(25, Short.MAX_VALUE)
					.addComponent(lblNewLabel_5)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(btnNewButton)
					.addContainerGap(32, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		
		JScrollPane scrollPane_1 = new JScrollPane();
		
		JScrollPane scrollPane_2 = new JScrollPane();
		
		JScrollPane scrollPane_3 = new JScrollPane();
		
		JScrollPane scrollPane_4 = new JScrollPane();
		
		JButton doneBtn = new JButton("Done");
		doneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				
				int checkSelection = 0;
				String appointment = " ";
				
				if(!mondayList.isSelectionEmpty()) {
					checkSelection++;
					appointment = (String) mondayList.getSelectedValue();
				}
				if(!tuesList.isSelectionEmpty()) {
					checkSelection++;
					appointment = (String) tuesList.getSelectedValue();
				}
				if(!wedList.isSelectionEmpty()) {
					checkSelection++;
					appointment = (String) wedList.getSelectedValue();
				}
				if(!thursList.isSelectionEmpty()) {
					checkSelection++;
					appointment = (String) thursList.getSelectedValue();
				}
				if(!friList.isSelectionEmpty()) {
					checkSelection++;
					appointment = (String) friList.getSelectedValue();
				}
				
				if(checkSelection == 1) {
					FileSystem file = new FileSystem(Integer.toString(patientUser.getUserID()));
					file.writeToFile(file.getFile(), " Appointment: "+ "Dr. " + Database.getDoctor(Integer.parseInt(id)).getFirstName() +appointment);
					PatientPage panel = new PatientPage(frame, patientUser);
					frame.setContentPane(panel);
					frame.revalidate();
				
				}
			}
		});
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 149, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 147, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(doneBtn)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane_4, GroupLayout.PREFERRED_SIZE, 221, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_3, GroupLayout.PREFERRED_SIZE, 224, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_2, GroupLayout.PREFERRED_SIZE, 226, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane_1, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
					.addComponent(doneBtn))
		);
		
		
		FileSystem file = new FileSystem(id);
	
		friList.setModel(new AbstractListModel() {
			String[] values = file.readFromFile(file.getFile(), id, "Friday");;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_4.setViewportView(friList);
		
		JLabel lblNewLabel_4 = new JLabel("Friday");
		scrollPane_4.setColumnHeaderView(lblNewLabel_4);
		
		thursList.setModel(new AbstractListModel() {
			String[] values = file.readFromFile(file.getFile(), id, "Thursday");;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_3.setViewportView(thursList);
		
		JLabel lblNewLabel_3 = new JLabel("Thursday");
		scrollPane_3.setColumnHeaderView(lblNewLabel_3);
		
		
		wedList.setModel(new AbstractListModel() {
			String[] values = file.readFromFile(file.getFile(), id, "Wednesday");
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_2.setViewportView(wedList);
		
		JLabel lblNewLabel_1 = new JLabel("Wednesday");
		scrollPane_2.setColumnHeaderView(lblNewLabel_1);
		
		tuesList.setModel(new AbstractListModel() {
			String[] values = file.readFromFile(file.getFile(), id, "Tuesday");;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane_1.setViewportView(tuesList);
		
		JLabel lblNewLabel_2 = new JLabel("Tuesday");
		scrollPane_1.setColumnHeaderView(lblNewLabel_2);
		
		
		mondayList.setModel(new AbstractListModel() {
			String[] values = file.readFromFile(file.getFile(), id, "Monday");;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(mondayList);
		
		JLabel lblNewLabel = new JLabel("Monday");
		scrollPane.setColumnHeaderView(lblNewLabel);
		panel_1.setLayout(gl_panel_1);
		setLayout(groupLayout);

	}
}
