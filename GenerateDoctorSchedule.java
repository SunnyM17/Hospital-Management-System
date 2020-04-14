import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import javax.swing.JFrame;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class GenerateDoctorSchedule extends JPanel {

	/**
	 * Creates the panel where the doctor can select
	 * in a checkbox style, the times of the week where he would be available
	 * for patient or any other appointments
	 * @param frame allows for sub-frames of other necessary frames to use the same JFrame
	 * @param user makes sure that the frame is being user for the correct User only
	 */
	public GenerateDoctorSchedule(JFrame frame, int id, Doctor user) {
		
		String drFileName = String.valueOf(id);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 76, 0, 146, 129, 0};
		gridBagLayout.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_5 = new JLabel("Doctor Schedule");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 0;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Builder");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 0;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		/*
		 * This button is made so that, if clicked, it goes back to the Main Doctor's page GUI
		 */
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DoctorPage panel = new DoctorPage(frame, user);
				frame.setContentPane(panel);
				frame.setSize(602, 330);
				frame.revalidate();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 4;
		gbc_btnNewButton.gridy = 1;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Monday");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Tuesday");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 2;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Wednesday");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 2;
		gbc_lblNewLabel_2.gridy = 2;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Thursday");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Friday");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		/**
		 * This Comment will explain thoroughly every what every checkbox is constituted of. Not every single checkbox
		 * will be commented because there is 45 of them, all with very similar functionality.
		 * Basically, when the checkbox is in fact checked, the specific message, starting with "Schedule: " to denote
		 * that the line item in file is part of the schedule of the patient, is written onto the Doctor's file to ensure
		 * that his schedule is being caputured on his file. Every checkbox has a different checkbox, denoting what time of the day
		 * and what day of the week the 1-hour availability window is for. This is the same case for all other checkboxes
		 */
		
		JCheckBox chckbxNewCheckBox_9 = new JCheckBox("9:00AM-10:00AM");
		chckbxNewCheckBox_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				/*
				 * We have File.IO classes because we require information of availability
				 * to be written onto the Doctor's File.
				 */
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 9AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_9.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_9 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_9.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_9.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_9.gridx = 0;
		gbc_chckbxNewCheckBox_9.gridy = 3;
		add(chckbxNewCheckBox_9, gbc_chckbxNewCheckBox_9);
		
		JCheckBox chckbxNewCheckBox_10 = new JCheckBox("9:00AM-10:00AM");
		chckbxNewCheckBox_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 9AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_10.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_10 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_10.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_10.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_10.gridx = 1;
		gbc_chckbxNewCheckBox_10.gridy = 3;
		add(chckbxNewCheckBox_10, gbc_chckbxNewCheckBox_10);
		
		JCheckBox chckbxNewCheckBox_11 = new JCheckBox("9:00AM-10:00AM");
		chckbxNewCheckBox_11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 9AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_11.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_11 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_11.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_11.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_11.gridx = 2;
		gbc_chckbxNewCheckBox_11.gridy = 3;
		add(chckbxNewCheckBox_11, gbc_chckbxNewCheckBox_11);
		
		JCheckBox chckbxNewCheckBox_12 = new JCheckBox("9:00AM-10:00AM");
		chckbxNewCheckBox_12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 9AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_12.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_12 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_12.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_12.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_12.gridx = 3;
		gbc_chckbxNewCheckBox_12.gridy = 3;
		add(chckbxNewCheckBox_12, gbc_chckbxNewCheckBox_12);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("9:00AM-10:00AM");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 9AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.SOUTHWEST;
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.gridx = 4;
		gbc_chckbxNewCheckBox.gridy = 3;
		add(chckbxNewCheckBox, gbc_chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("10:00AM - 11:00AM");
		chckbxNewCheckBox_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 10AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_1_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1_1.gridx = 0;
		gbc_chckbxNewCheckBox_1_1.gridy = 4;
		add(chckbxNewCheckBox_1_1, gbc_chckbxNewCheckBox_1_1);
		
		JCheckBox chckbxNewCheckBox_1_2 = new JCheckBox("10:00AM - 11:00AM");
		chckbxNewCheckBox_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 10AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_1_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1_2.gridx = 1;
		gbc_chckbxNewCheckBox_1_2.gridy = 4;
		add(chckbxNewCheckBox_1_2, gbc_chckbxNewCheckBox_1_2);
		
		JCheckBox chckbxNewCheckBox_1_3 = new JCheckBox("10:00AM - 11:00AM");
		chckbxNewCheckBox_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 10AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_1_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1_3.gridx = 2;
		gbc_chckbxNewCheckBox_1_3.gridy = 4;
		add(chckbxNewCheckBox_1_3, gbc_chckbxNewCheckBox_1_3);
		
		JCheckBox chckbxNewCheckBox_1_4 = new JCheckBox("10:00AM - 11:00AM");
		chckbxNewCheckBox_1_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 10AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_1_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_1_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1_4.gridx = 3;
		gbc_chckbxNewCheckBox_1_4.gridy = 4;
		add(chckbxNewCheckBox_1_4, gbc_chckbxNewCheckBox_1_4);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("10:00AM - 11:00AM");
		chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 10AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_1.gridx = 4;
		gbc_chckbxNewCheckBox_1.gridy = 4;
		add(chckbxNewCheckBox_1, gbc_chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2_1 = new JCheckBox("11:00AM-12:00PM");
		chckbxNewCheckBox_2_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 11AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_2_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2_1.gridx = 0;
		gbc_chckbxNewCheckBox_2_1.gridy = 5;
		add(chckbxNewCheckBox_2_1, gbc_chckbxNewCheckBox_2_1);
		
		JCheckBox chckbxNewCheckBox_2_2 = new JCheckBox("11:00AM-12:00PM");
		chckbxNewCheckBox_2_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 11AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_2_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_2_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2_2.gridx = 1;
		gbc_chckbxNewCheckBox_2_2.gridy = 5;
		add(chckbxNewCheckBox_2_2, gbc_chckbxNewCheckBox_2_2);
		
		JCheckBox chckbxNewCheckBox_2_3 = new JCheckBox("11:00AM-12:00PM");
		chckbxNewCheckBox_2_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 11AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_2_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_2_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_2_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2_3.gridx = 2;
		gbc_chckbxNewCheckBox_2_3.gridy = 5;
		add(chckbxNewCheckBox_2_3, gbc_chckbxNewCheckBox_2_3);
		
		JCheckBox chckbxNewCheckBox_2_4 = new JCheckBox("11:00AM-12:00PM");
		chckbxNewCheckBox_2_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 11AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_2_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_2_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_2_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_2_4.gridx = 3;
		gbc_chckbxNewCheckBox_2_4.gridy = 5;
		add(chckbxNewCheckBox_2_4, gbc_chckbxNewCheckBox_2_4);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("11:00AM-12:00PM");
		chckbxNewCheckBox_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 11AM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_2.gridx = 4;
		gbc_chckbxNewCheckBox_2.gridy = 5;
		add(chckbxNewCheckBox_2, gbc_chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3_1 = new JCheckBox("12:00PM-1:00PM");
		chckbxNewCheckBox_3_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 12PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_3_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_3_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3_1.gridx = 0;
		gbc_chckbxNewCheckBox_3_1.gridy = 6;
		add(chckbxNewCheckBox_3_1, gbc_chckbxNewCheckBox_3_1);
		
		JCheckBox chckbxNewCheckBox_3_2 = new JCheckBox("12:00PM-1:00PM");
		chckbxNewCheckBox_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 12PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_3_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_3_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_3_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3_2.gridx = 1;
		gbc_chckbxNewCheckBox_3_2.gridy = 6;
		add(chckbxNewCheckBox_3_2, gbc_chckbxNewCheckBox_3_2);
		
		JCheckBox chckbxNewCheckBox_3_3 = new JCheckBox("12:00PM-1:00PM");
		chckbxNewCheckBox_3_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 12PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_3_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_3_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_3_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3_3.gridx = 2;
		gbc_chckbxNewCheckBox_3_3.gridy = 6;
		add(chckbxNewCheckBox_3_3, gbc_chckbxNewCheckBox_3_3);
		
		JCheckBox chckbxNewCheckBox_3_4 = new JCheckBox("12:00PM-1:00PM");
		chckbxNewCheckBox_3_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 12PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_3_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_3_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_3_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_3_4.gridx = 3;
		gbc_chckbxNewCheckBox_3_4.gridy = 6;
		add(chckbxNewCheckBox_3_4, gbc_chckbxNewCheckBox_3_4);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("12:00PM-1:00PM");
		chckbxNewCheckBox_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 12PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_3.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_3.gridx = 4;
		gbc_chckbxNewCheckBox_3.gridy = 6;
		add(chckbxNewCheckBox_3, gbc_chckbxNewCheckBox_3);
		
		JCheckBox chckbxNewCheckBox_4_1 = new JCheckBox("1:00PM - 2:00PM");
		chckbxNewCheckBox_4_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 1PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_4_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_4_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_4_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_4_1.gridx = 0;
		gbc_chckbxNewCheckBox_4_1.gridy = 7;
		add(chckbxNewCheckBox_4_1, gbc_chckbxNewCheckBox_4_1);
		
		JCheckBox chckbxNewCheckBox_4_2 = new JCheckBox("1:00PM - 2:00PM");
		chckbxNewCheckBox_4_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 1PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_4_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_4_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_4_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_4_2.gridx = 1;
		gbc_chckbxNewCheckBox_4_2.gridy = 7;
		add(chckbxNewCheckBox_4_2, gbc_chckbxNewCheckBox_4_2);
		
		JCheckBox chckbxNewCheckBox_4_3 = new JCheckBox("1:00PM - 2:00PM");
		chckbxNewCheckBox_4_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 1PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_4_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_4_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_4_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_4_3.gridx = 2;
		gbc_chckbxNewCheckBox_4_3.gridy = 7;
		add(chckbxNewCheckBox_4_3, gbc_chckbxNewCheckBox_4_3);
		
		JCheckBox chckbxNewCheckBox_4_4 = new JCheckBox("1:00PM - 2:00PM");
		chckbxNewCheckBox_4_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 1PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_4_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_4_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_4_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_4_4.gridx = 3;
		gbc_chckbxNewCheckBox_4_4.gridy = 7;
		add(chckbxNewCheckBox_4_4, gbc_chckbxNewCheckBox_4_4);
		
		JCheckBox chckbxNewCheckBox_4 = new JCheckBox("1:00PM - 2:00PM");
		chckbxNewCheckBox_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 1PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_4.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_4.gridx = 4;
		gbc_chckbxNewCheckBox_4.gridy = 7;
		add(chckbxNewCheckBox_4, gbc_chckbxNewCheckBox_4);
		
		JCheckBox chckbxNewCheckBox_5_1 = new JCheckBox("2:00PM - 3:00PM");
		chckbxNewCheckBox_5_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 2PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_5_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_5_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5_1.gridx = 0;
		gbc_chckbxNewCheckBox_5_1.gridy = 8;
		add(chckbxNewCheckBox_5_1, gbc_chckbxNewCheckBox_5_1);
		
		JCheckBox chckbxNewCheckBox_5_2 = new JCheckBox("2:00PM - 3:00PM");
		chckbxNewCheckBox_5_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 2PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_5_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_5_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_5_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5_2.gridx = 1;
		gbc_chckbxNewCheckBox_5_2.gridy = 8;
		add(chckbxNewCheckBox_5_2, gbc_chckbxNewCheckBox_5_2);
		
		JCheckBox chckbxNewCheckBox_5_3 = new JCheckBox("2:00PM - 3:00PM");
		chckbxNewCheckBox_5_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 2PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_5_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_5_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_5_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5_3.gridx = 2;
		gbc_chckbxNewCheckBox_5_3.gridy = 8;
		add(chckbxNewCheckBox_5_3, gbc_chckbxNewCheckBox_5_3);
		
		JCheckBox chckbxNewCheckBox_5_4 = new JCheckBox("2:00PM - 3:00PM");
		chckbxNewCheckBox_5_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 2PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_5_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_5_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_5_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_5_4.gridx = 3;
		gbc_chckbxNewCheckBox_5_4.gridy = 8;
		add(chckbxNewCheckBox_5_4, gbc_chckbxNewCheckBox_5_4);
		
		JCheckBox chckbxNewCheckBox_5 = new JCheckBox("2:00PM - 3:00PM");
		chckbxNewCheckBox_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 2PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_5.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_5 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_5.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_5.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_5.gridx = 4;
		gbc_chckbxNewCheckBox_5.gridy = 8;
		add(chckbxNewCheckBox_5, gbc_chckbxNewCheckBox_5);
		
		JCheckBox chckbxNewCheckBox_6_1 = new JCheckBox("3:00PM - 4:00PM");
		chckbxNewCheckBox_6_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 3PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_6_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_6_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_6_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6_1.gridx = 0;
		gbc_chckbxNewCheckBox_6_1.gridy = 9;
		add(chckbxNewCheckBox_6_1, gbc_chckbxNewCheckBox_6_1);
		
		JCheckBox chckbxNewCheckBox_6_2 = new JCheckBox("3:00PM - 4:00PM");
		chckbxNewCheckBox_6_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 3PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_6_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_6_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_6_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6_2.gridx = 1;
		gbc_chckbxNewCheckBox_6_2.gridy = 9;
		add(chckbxNewCheckBox_6_2, gbc_chckbxNewCheckBox_6_2);
		
		JCheckBox chckbxNewCheckBox_6_4 = new JCheckBox("3:00PM - 4:00PM");
		chckbxNewCheckBox_6_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 3PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_6_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_6_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_6_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6_4.gridx = 2;
		gbc_chckbxNewCheckBox_6_4.gridy = 9;
		add(chckbxNewCheckBox_6_4, gbc_chckbxNewCheckBox_6_4);
		
		JCheckBox chckbxNewCheckBox_6_3 = new JCheckBox("3:00PM - 4:00PM");
		chckbxNewCheckBox_6_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 3PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_6_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_6_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_6_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_6_3.gridx = 3;
		gbc_chckbxNewCheckBox_6_3.gridy = 9;
		add(chckbxNewCheckBox_6_3, gbc_chckbxNewCheckBox_6_3);
		
		JCheckBox chckbxNewCheckBox_6 = new JCheckBox("3:00PM - 4:00PM");
		chckbxNewCheckBox_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 3PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_6.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_6 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_6.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_6.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_6.gridx = 4;
		gbc_chckbxNewCheckBox_6.gridy = 9;
		add(chckbxNewCheckBox_6, gbc_chckbxNewCheckBox_6);
		
		JCheckBox chckbxNewCheckBox_7_1 = new JCheckBox("4:00PM - 5:00PM");
		chckbxNewCheckBox_7_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 4PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_7_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_7_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_7_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7_1.gridx = 0;
		gbc_chckbxNewCheckBox_7_1.gridy = 10;
		add(chckbxNewCheckBox_7_1, gbc_chckbxNewCheckBox_7_1);
		
		JCheckBox chckbxNewCheckBox_7_2 = new JCheckBox("4:00PM - 5:00PM");
		chckbxNewCheckBox_7_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 4PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_7_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_7_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_7_2.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7_2.gridx = 1;
		gbc_chckbxNewCheckBox_7_2.gridy = 10;
		add(chckbxNewCheckBox_7_2, gbc_chckbxNewCheckBox_7_2);
		
		JCheckBox chckbxNewCheckBox_7_3 = new JCheckBox("4:00PM - 5:00PM");
		chckbxNewCheckBox_7_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 4PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_7_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_7_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_7_3.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7_3.gridx = 2;
		gbc_chckbxNewCheckBox_7_3.gridy = 10;
		add(chckbxNewCheckBox_7_3, gbc_chckbxNewCheckBox_7_3);
		
		JCheckBox chckbxNewCheckBox_7_4 = new JCheckBox("4:00PM - 5:00PM");
		chckbxNewCheckBox_7_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 4PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_7_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_7_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_7_4.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_7_4.gridx = 3;
		gbc_chckbxNewCheckBox_7_4.gridy = 10;
		add(chckbxNewCheckBox_7_4, gbc_chckbxNewCheckBox_7_4);
		
		JCheckBox chckbxNewCheckBox_7 = new JCheckBox("4:00PM - 5:00PM");
		chckbxNewCheckBox_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 4PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_7.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_7 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_7.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_7.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox_7.gridx = 4;
		gbc_chckbxNewCheckBox_7.gridy = 10;
		add(chckbxNewCheckBox_7, gbc_chckbxNewCheckBox_7);
		
		JCheckBox chckbxNewCheckBox_8_1 = new JCheckBox("5:00PM - 6:00PM");
		chckbxNewCheckBox_8_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Monday, 5PM, Available");
					pw.close();bw.close();fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_8_1.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_8_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8_1.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_8_1.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_8_1.gridx = 0;
		gbc_chckbxNewCheckBox_8_1.gridy = 11;
		add(chckbxNewCheckBox_8_1, gbc_chckbxNewCheckBox_8_1);
		
		JCheckBox chckbxNewCheckBox_8_2 = new JCheckBox("5:00PM - 6:00PM");
		chckbxNewCheckBox_8_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Tuesday, 5PM, Available");
					pw.close();
					bw.close();
					fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_8_2.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_8_2 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8_2.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_8_2.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_8_2.gridx = 1;
		gbc_chckbxNewCheckBox_8_2.gridy = 11;
		add(chckbxNewCheckBox_8_2, gbc_chckbxNewCheckBox_8_2);
		
		JCheckBox chckbxNewCheckBox_8_4 = new JCheckBox("5:00PM - 6:00PM");
		chckbxNewCheckBox_8_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Wednesday, 5PM, Available");
					pw.close();
					bw.close();
					fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_8_4.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_8_4 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8_4.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_8_4.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_8_4.gridx = 2;
		gbc_chckbxNewCheckBox_8_4.gridy = 11;
		add(chckbxNewCheckBox_8_4, gbc_chckbxNewCheckBox_8_4);
		
		JCheckBox chckbxNewCheckBox_8_3 = new JCheckBox("5:00PM - 6:00PM");
		chckbxNewCheckBox_8_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Thursday, 5PM, Available");
					pw.close();
					bw.close(); fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_8_3.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_8_3 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8_3.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_8_3.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxNewCheckBox_8_3.gridx = 3;
		gbc_chckbxNewCheckBox_8_3.gridy = 11;
		add(chckbxNewCheckBox_8_3, gbc_chckbxNewCheckBox_8_3);
		
		JCheckBox chckbxNewCheckBox_8 = new JCheckBox("5:00PM - 6:00PM");
		chckbxNewCheckBox_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				PrintWriter pw = null;
				try {
					fw = new FileWriter(Database.LOCATION+"\\" + drFileName + ".txt", true);
					bw = new BufferedWriter(fw);
					pw = new PrintWriter(bw);
					pw.println("Schedule: Friday, 5PM, Available");
					pw.close(); bw.close(); fw.close();
					
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		});
		chckbxNewCheckBox_8.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_chckbxNewCheckBox_8 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_8.anchor = GridBagConstraints.WEST;
		gbc_chckbxNewCheckBox_8.gridx = 4;
		gbc_chckbxNewCheckBox_8.gridy = 11;
		add(chckbxNewCheckBox_8, gbc_chckbxNewCheckBox_8);
		}

}
