import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.CheckboxGroup;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;

import javafx.scene.control.CheckBox;

import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class GenSchedule extends JPanel {

	/**
	 * Create the panel.
	 */
	public GenSchedule(JFrame frame, Users user) {
		setBackground(Color.WHITE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_5 = new JLabel("Schedule Builder");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
							.addComponent(lblNewLabel_5)
							.addGap(422))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 984, Short.MAX_VALUE)
							.addContainerGap())))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_5)
					.addGap(32)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(45, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Monday");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox cb0 = new JCheckBox("9:00AM-10:00AM");
		cb0.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb1 = new JCheckBox("10:00AM - 11:00AM");
		cb1.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_1 = new JLabel("Tuesday");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox cb9 = new JCheckBox("9:00AM-10:00AM");
		cb9.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb10 = new JCheckBox("10:00AM - 11:00AM");
		cb10.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb18 = new JCheckBox("9:00AM-10:00AM");
		cb18.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb19 = new JCheckBox("10:00AM - 11:00AM");
		cb19.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_2 = new JLabel("Wednesday");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox cb27 = new JCheckBox("9:00AM-10:00AM");
		cb27.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLabel lblNewLabel_3 = new JLabel("Thursday");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JLabel lblNewLabel_4 = new JLabel("Friday");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		
		JCheckBox cb37 = new JCheckBox("10:00AM - 11:00AM");
		cb37.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb36 = new JCheckBox("9:00AM-10:00AM");
		cb36.setHorizontalAlignment(SwingConstants.LEFT);
		//cb28.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb2 = new JCheckBox("11:00AM-12:00PM");
		//cb2.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb11 = new JCheckBox("11:00AM-12:00PM");
		//cb11.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb20 = new JCheckBox("11:00AM-12:00PM");
		//cb20.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb38 = new JCheckBox("11:00AM-12:00PM");
		//cb38.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb3 = new JCheckBox("12:00PM-1:00PM");
		//cb3.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb12 = new JCheckBox("12:00PM-1:00PM");
		//cb12.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb21 = new JCheckBox("12:00PM-1:00PM");
		//cb21.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb30 = new JCheckBox("12:00PM-1:00PM");
		//cb30.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb39 = new JCheckBox("12:00PM-1:00PM");
		//cb4.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb13 = new JCheckBox("1:00PM - 2:00PM");
		//cb13.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb22 = new JCheckBox("1:00PM - 2:00PM");
		//cb22.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb31 = new JCheckBox("1:00PM - 2:00PM");
		//cb31.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb40 = new JCheckBox("1:00PM - 2:00PM");
		//cb5.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb14 = new JCheckBox("2:00PM - 3:00PM");
		//cb6.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb15 = new JCheckBox("3:00PM - 4:00PM");
		//cb14.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb23 = new JCheckBox("2:00PM - 3:00PM");
		//cb15.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb24 = new JCheckBox("3:00PM - 4:00PM");
		//cb23.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb32 = new JCheckBox("2:00PM - 3:00PM");
		//cb24.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb33 = new JCheckBox("3:00PM - 4:00PM");
		//cb32.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb41 = new JCheckBox("2:00PM - 3:00PM");
		//cb33.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb42 = new JCheckBox("3:00PM - 4:00PM");
		//cb16.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb25 = new JCheckBox("4:00PM - 5:00PM");
		//cb7.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb16 = new JCheckBox("4:00PM - 5:00PM");
		
		JCheckBox cb29 = new JCheckBox("11:00AM-12:00PM");
		cb29.setHorizontalAlignment(SwingConstants.LEFT);
		//cb39.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb4 = new JCheckBox("1:00PM - 2:00PM");
		cb40.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb5 = new JCheckBox("2:00PM - 3:00PM");
		
		JCheckBox cb28 = new JCheckBox("10:00AM - 11:00AM");
		//cb41.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb6 = new JCheckBox("3:00PM - 4:00PM");
		//cb42.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb7 = new JCheckBox("4:00PM - 5:00PM");
		//cb25.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb34 = new JCheckBox("4:00PM - 5:00PM");
		//cb34.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb43 = new JCheckBox("4:00PM - 5:00PM");
		//cb43.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb8 = new JCheckBox("5:00PM - 6:00PM");
		//cb8.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb17 = new JCheckBox("5:00PM - 6:00PM");
		//cb17.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb26 = new JCheckBox("5:00PM - 6:00PM");
		//cb26.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb35 = new JCheckBox("5:00PM - 6:00PM");
		//cb35.setHorizontalAlignment(SwingConstants.LEFT);
		
		JCheckBox cb44 = new JCheckBox("5:00PM - 6:00PM");
		
		JButton doneBtn = new JButton("Done");
		doneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				JCheckBox [] temp = new JCheckBox [] {cb0, cb1, cb2, cb3, cb4, cb5, cb6, cb7, cb8, cb9,
						cb10, cb11, cb12, cb13, cb14, cb15, cb16, cb17, cb18, cb19, cb20, cb21, cb22, cb23, 
						cb24, cb25, cb26, cb27, cb28, cb29, cb30, cb31, cb32, cb33, cb34, cb35, cb36, cb37,
						cb38, cb39, cb40, cb41, cb42, cb43, cb44
				};
				ArrayList<JCheckBox> time = new ArrayList<JCheckBox>();
				time.addAll(Arrays.asList(temp));
				
				FileSystem tempFile = new FileSystem(Integer.toString(user.getUserID()));
				File file = tempFile.getFile();
				
				for(int i=0; i< time.size(); i++) {
					if(time.get(i).isSelected() && i>=0 && i<=8) {
						tempFile.writeToFile(file, "Schedule: " + "Monday " +time.get(i).getLabel());
					}
					else if(time.get(i).isSelected() && i>=9 && i<=17) {
						tempFile.writeToFile(file, "Schedule: " + "Tuesday "+ time.get(i).getLabel());
					}
					else if(time.get(i).isSelected() && i>=17 && i<=26) {
						tempFile.writeToFile(file, "Schedule: " + "Wednesday "+ time.get(i).getLabel());
					}
					else if(time.get(i).isSelected() && i>=26 && i<=35) {
						tempFile.writeToFile(file, "Schedule: " + "Thursday "+ time.get(i).getLabel());
					}
					else if(time.get(i).isSelected() && i>=35 && i<=44) {
						tempFile.writeToFile(file, "Schedule: " + "Friday "+ time.get(i).getLabel());
					}
				}
					

			}
		});
		
		JButton backBtn = new JButton("Back");
		backBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				int value = user.getUserID()/1000000;
				/* ID starts with 1, go to admin GUI */
				
				SelectSchedule panel = new SelectSchedule(frame, Database.getAdmin(user.getUserID()), Database.getAllNurses());
				frame.setContentPane(panel);
				frame.setSize(675, 435);
				frame.revalidate();	
			
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(cb3)
							.addComponent(cb0)
							.addComponent(cb1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cb4, GroupLayout.PREFERRED_SIZE, 166, GroupLayout.PREFERRED_SIZE)
							.addComponent(cb5)
							.addComponent(lblNewLabel)
							.addComponent(cb6)
							.addComponent(cb7)
							.addComponent(cb2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(cb8))
					.addGap(14)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(cb17)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING, false)
							.addComponent(cb9)
							.addComponent(cb11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(cb12)
							.addComponent(cb13)
							.addComponent(cb14)
							.addComponent(cb15)
							.addComponent(cb16)
							.addComponent(cb10))
						.addComponent(lblNewLabel_1))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(backBtn, GroupLayout.PREFERRED_SIZE, 76, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(doneBtn))
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(cb22)
									.addComponent(cb23)
									.addComponent(cb24)
									.addGroup(gl_panel.createSequentialGroup()
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(cb18)
											.addComponent(cb21)
											.addComponent(cb19)
											.addComponent(cb25)
											.addComponent(lblNewLabel_2))
										.addGap(23)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
											.addComponent(cb34)
											.addComponent(lblNewLabel_3)
											.addComponent(cb28, GroupLayout.PREFERRED_SIZE, 174, GroupLayout.PREFERRED_SIZE)
											.addComponent(cb30)
											.addComponent(cb27)
											.addComponent(cb31)
											.addComponent(cb32)
											.addComponent(cb33)
											.addComponent(cb29)
											.addComponent(cb35)))
									.addComponent(cb20))
								.addComponent(cb26))
							.addGap(20)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cb41)
								.addComponent(cb40)
								.addComponent(cb37, GroupLayout.PREFERRED_SIZE, 159, GroupLayout.PREFERRED_SIZE)
								.addComponent(cb39)
								.addComponent(cb38)
								.addComponent(cb42)
								.addComponent(lblNewLabel_4)
								.addComponent(cb36)
								.addComponent(cb43)
								.addComponent(cb44))))
					.addGap(38))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(cb0)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cb1)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cb2)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(cb3))
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb18)
										.addComponent(cb27)
										.addComponent(cb36))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb19)
										.addComponent(cb37)
										.addComponent(cb28))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb20)
										.addComponent(cb38)
										.addComponent(cb29))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb21)
										.addComponent(cb39)
										.addComponent(cb30))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb22)
										.addComponent(cb31)
										.addComponent(cb40))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb23)
										.addComponent(cb32)
										.addComponent(cb41))
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(cb24)
										.addComponent(cb33)
										.addComponent(cb42))))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(cb43)
								.addComponent(cb34)))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(cb9)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cb10)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cb11)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(cb12)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cb13)
								.addComponent(cb4))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cb14)
								.addComponent(cb5))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cb15)
								.addComponent(cb6))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(cb16)
								.addComponent(cb25)
								.addComponent(cb7))))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(cb8)
						.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
							.addComponent(cb17)
							.addComponent(cb26)
							.addComponent(cb35)
							.addComponent(cb44)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(doneBtn)
						.addComponent(backBtn))
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		setLayout(groupLayout);

	}
}
