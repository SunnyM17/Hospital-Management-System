import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PatientRecordPeak extends JPanel {

	/**
	 * Creates the panel.
	 * @param id is used since we are aware that files' names are userIDs
	 * and are therefore needed to get the file from the directory it is in
	 */
	public PatientRecordPeak(int id, JFrame frame, Doctor DoctorUser) {
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		
		// Text Area where patient file record will be shown in GUI
		JTextArea textArea = new JTextArea();
		
		JButton btnNewButton = new JButton("Go Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DoctorPage panel = new DoctorPage(frame, DoctorUser);
				frame.setContentPane(panel);
				frame.revalidate();
			}
		});
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 348, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton)
							.addGap(15))))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(textArea, GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
					.addContainerGap())
		);
		
		
		String stringID = String.valueOf(id);
		/**
		 * We use this try-catch statement because we need to make
		 * use of file.io to read the contents from the patient's record file
		 * to be displayed for the Doctor
		 */
		
		try {
			BufferedReader bf = new BufferedReader(new FileReader(Database.LOCATION+"\\" + stringID+ ".txt"));
			String line = bf.readLine();
			while(line != null) {
					textArea.append(line + "\n");
				
				line = bf.readLine();
			}
			bf.close();
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		JLabel lblNewLabel = new JLabel("Patient Record");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		panel.add(lblNewLabel);
		setLayout(groupLayout);

		
		
	}

}
