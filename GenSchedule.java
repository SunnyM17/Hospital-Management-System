import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import javax.swing.JList;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GenSchedule extends JPanel {

	/**
	 * Create the panel.
	 */
	public GenSchedule(int id) {
		
		String patientFileName = String.valueOf(id);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 76, 0, 146, 129, 0};
		gridBagLayout.rowHeights = new int[]{29, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblNewLabel_5_1 = new JLabel("Patient");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5_1.gridx = 1;
		gbc_lblNewLabel_5_1.gridy = 0;
		add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		JLabel lblNewLabel_5 = new JLabel("Appointment   ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 0;
		add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Scheduler");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 3;
		gbc_lblNewLabel_6.gridy = 0;
		add(lblNewLabel_6, gbc_lblNewLabel_6);
		
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
		
		FileInputStream fs;
		try {
			fs = new FileInputStream(Database.LOCATION + "\\" + patientFileName + ".txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			for(int i = 0; i <6; i++)
			{
				br.readLine();
			}
			
			String doctorFile = br.readLine();
			
			
			FileInputStream fr = new FileInputStream(Database.LOCATION + "\\" + doctorFile + ".txt");
			BufferedReader bs = new BufferedReader(new InputStreamReader(fr));
			for(int j = 0; j<5;j++)
			{
				bs.readLine();
			}
			
			ArrayList<String> docAvailable = new ArrayList<String>();
			
			while(bs.readLine() != null)
			{
				
				System.out.println(bs.readLine());
				docAvailable.add(bs.readLine());
			}
			
			
			
			JCheckBox chckbxNewCheckBox_9 = new JCheckBox("9:00AM-10:00AM");
			
			chckbxNewCheckBox_9.setVisible(false);
			
			String monday9 = "Schedule: Monday, 9AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday9.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_9.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_9.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 9AM ");
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
			
			chckbxNewCheckBox_10.setVisible(false);
			
			String tuesday9 = "Schedule: Tuesday, 9AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday9.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_10.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_10.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 9AM ");
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
			
			chckbxNewCheckBox_11.setVisible(false);
			
			String wednesday9 = "Schedule: Wednesday, 9AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday9.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_11.setVisible(true);
						}
			}

			chckbxNewCheckBox_11.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 9AM ");
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
			
			chckbxNewCheckBox_12.setVisible(false);
			
			String thursday9 = "Schedule: Thursday, 9AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday9.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_12.setVisible(true);
						}
			}

			chckbxNewCheckBox_12.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 9AM ");
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
			
			chckbxNewCheckBox.setVisible(false);
			
			String friday9 = "Schedule: Friday, 9AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday9.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox.setVisible(true);
						}
			}
			
			chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 9AM ");
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
			chckbxNewCheckBox_1_1.setVisible(false);
			
			String monday10 = "Schedule: Monday, 10AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday10.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_1_1.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_1_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 10AM ");
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
			
			chckbxNewCheckBox_1_2.setVisible(false);
			
			String tuesday10 = "Schedule: Tuesday, 10AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday10.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_1_2.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_1_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 10AM ");
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
			
			chckbxNewCheckBox_1_3.setVisible(false);
			
			String wednesday10 = "Schedule: Wednesday, 10AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday10.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_1_3.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_1_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 10AM ");
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
			chckbxNewCheckBox_1_4.setVisible(false);
			
			String thursday10 = "Schedule: Thursday, 10AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday10.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_1_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_1_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 10AM ");
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
			chckbxNewCheckBox_1.setVisible(false);
			
			String friday10 = "Schedule: Friday, 10AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday10.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_1.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 10AM ");
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
			
			chckbxNewCheckBox_2_1.setVisible(false);
			
			String monday11 = "Schedule: Monday, 11AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday11.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_2_1.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_2_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 11AM ");
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
			
			chckbxNewCheckBox_2_2.setVisible(false);
			
			String tuesday11 = "Schedule: Tuesday, 11AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday11.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_2_2.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_2_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 11AM ");
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
			
			chckbxNewCheckBox_2_3.setVisible(false);
			
			String wednesday11 = "Schedule: Wednesday, 11AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday11.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_2_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_2_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 11AM ");
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
			chckbxNewCheckBox_2_4.setVisible(false);
			
			String thursday11 = "Schedule: Thursday, 11AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday11.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_2_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_2_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 11AM ");
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
			
			chckbxNewCheckBox_2.setVisible(false);
			
			String friday11 = "Schedule: Friday, 11AM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday11.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_2.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 11AM ");
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
			
			chckbxNewCheckBox_3_1.setVisible(false);
			
			String monday12 = "Schedule: Monday, 12PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday12.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_3_1.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_3_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 12PM ");
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
			chckbxNewCheckBox_3_2.setVisible(false);
			
			String tuesday12 = "Schedule: Tuesday, 12PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday12.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_3_2.setVisible(true);
						}
			}
			
			chckbxNewCheckBox_3_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 12PM ");
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
			
			chckbxNewCheckBox_3_3.setVisible(false);
			
			String wednesday12 = "Schedule: Wednesday, 12PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday12.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_3_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_3_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 12PM ");
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
			chckbxNewCheckBox_3_4.setVisible(false);
			
			String thursday12 = "Schedule: Thursday, 12PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday12.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_3_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_3_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 12PM ");
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
			
			chckbxNewCheckBox_3.setVisible(false);
			String friday12 = "Schedule: Friday, 12PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday12.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 12PM ");
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
			chckbxNewCheckBox_4_1.setVisible(false);
			String monday1 = "Schedule: Monday, 1PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday1.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_4_1.setVisible(true);
						}
			}
			chckbxNewCheckBox_4_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 1PM ");
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
			chckbxNewCheckBox_4_2.setVisible(false);
			String tuesday1 = "Schedule: Tuesday, 1PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday1.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_4_2.setVisible(true);
						}
			}
			chckbxNewCheckBox_4_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 1PM ");
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
			chckbxNewCheckBox_4_3.setVisible(false);
			String wednesday1 = "Schedule: Wednesday, 1PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday1.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_4_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_4_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 1PM ");
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
			chckbxNewCheckBox_4_4.setVisible(false);
			String thursday1 = "Schedule: Thursday, 1PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday1.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_4_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_4_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 1PM ");
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
			
			chckbxNewCheckBox_4.setVisible(false);
			String friday1 = "Schedule: Friday, 1PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday1.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 1PM ");
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
			
			chckbxNewCheckBox_5_1.setVisible(false);
			String monday2 = "Schedule: Monday, 2PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday2.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_5_1.setVisible(true);
						}
			}
			chckbxNewCheckBox_5_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 2PM ");
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
			
			chckbxNewCheckBox_5_2.setVisible(false);
			String tuesday2 = "Schedule: Tuesday, 2PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday2.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_5_2.setVisible(true);
						}
			}
			chckbxNewCheckBox_5_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 2PM ");
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
			
			chckbxNewCheckBox_5_3.setVisible(false);
			String wednesday2 = "Schedule: Wednesday, 2PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday2.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_5_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_5_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 2PM ");
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
			chckbxNewCheckBox_5_4.setVisible(false);
			
			String thursday2 = "Schedule: Thursday, 2PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday2.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_5_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_5_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 2PM ");
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
			
			chckbxNewCheckBox_5.setVisible(false);
			
			String friday2 = "Schedule: Friday, 2PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday2.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_5.setVisible(true);
						}
			}
			chckbxNewCheckBox_5.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 2PM ");
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
			
			chckbxNewCheckBox_6_1.setVisible(false);
			
			String monday3 = "Schedule: Monday, 3PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday3.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_6_1.setVisible(true);
						}
			}
			chckbxNewCheckBox_6_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 3PM ");
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
			
			chckbxNewCheckBox_6_2.setVisible(false);
			
			String tuesday3 = "Schedule: Tuesday, 3PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday3.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_6_2.setVisible(true);
						}
			}
			chckbxNewCheckBox_6_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 3PM ");
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
			
			chckbxNewCheckBox_6_4.setVisible(false);
			
			String wednesday3 = "Schedule: Wednesday, 3PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday3.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_6_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_6_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 3PM ");
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
			
			chckbxNewCheckBox_6_3.setVisible(false);
			
			String thursday3 = "Schedule: Thursday, 3PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday3.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_6_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_6_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 3PM ");
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
			
			chckbxNewCheckBox_6.setVisible(false);
			
			String friday3 = "Schedule: Friday, 3PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday3.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_6.setVisible(true);
						}
			}
			chckbxNewCheckBox_6.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 3PM ");
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
			
			chckbxNewCheckBox_7_1.setVisible(false);
			
			String monday4 = "Schedule: Monday, 4PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday4.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_7_1.setVisible(true);
						}
			}
			chckbxNewCheckBox_7_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 4PM ");
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
			chckbxNewCheckBox_7_2.setVisible(false);
			
			String tuesday4 = "Schedule: Tuesday, 4PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday4.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_7_2.setVisible(true);
						}
			}
			chckbxNewCheckBox_7_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 4PM ");
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
			chckbxNewCheckBox_7_3.setVisible(false);
			
			String wednesday4 = "Schedule: Wednesday, 4PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday4.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_7_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_7_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 4PM ");
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
			chckbxNewCheckBox_7_4.setVisible(false);
			
			String thursday4 = "Schedule: Thursday, 4PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday4.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_7_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_7_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 4PM ");
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
			chckbxNewCheckBox_7.setVisible(false);
			
			String friday4 = "Schedule: Friday, 4PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday4.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_7.setVisible(true);
						}
			}
			chckbxNewCheckBox_7.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 4PM ");
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
			chckbxNewCheckBox_8_1.setVisible(false);
			
			String monday5 = "Schedule: Monday, 5PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(monday5.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_8_1.setVisible(true);
						}
			}
			chckbxNewCheckBox_8_1.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Monday, 5PM ");
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
			chckbxNewCheckBox_8_2.setVisible(false);
			
			String tuesday5 = "Schedule: Tuesday, 5PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(tuesday5.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_8_2.setVisible(true);
						}
			}
			chckbxNewCheckBox_8_2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Tuesday, 5PM ");
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
			chckbxNewCheckBox_8_4.setVisible(false);
			
			String wednesday5 = "Schedule: Wednesday, 5PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(wednesday5.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_8_4.setVisible(true);
						}
			}
			chckbxNewCheckBox_8_4.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Wednesday, 5PM ");
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
			chckbxNewCheckBox_8_3.setVisible(false);
			
			String thursday5 = "Schedule: Thursday, 5PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(thursday5.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_8_3.setVisible(true);
						}
			}
			chckbxNewCheckBox_8_3.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Thursday, 5PM ");
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
			chckbxNewCheckBox_8.setVisible(false);
			
			String friday5 = "Schedule: Friday, 5PM, Available";
			
			for(int i = 0; i < docAvailable.size(); i++)
			{
				if(friday5.equals(docAvailable.get(i)))
						{
					chckbxNewCheckBox_8.setVisible(true);
						}
			}
			chckbxNewCheckBox_8.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					FileWriter fw = null;
					BufferedWriter bw = null;
					PrintWriter pw = null;
					try {
						fw = new FileWriter(Database.LOCATION+"\\" + patientFileName + ".txt", true);
						bw = new BufferedWriter(fw);
						pw = new PrintWriter(bw);
						pw.println("Appointment: Friday, 5PM ");
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
			
			
			
		} catch (IOException e1) {
			
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		


}
}
