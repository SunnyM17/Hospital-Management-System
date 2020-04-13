import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import javax.swing.JSplitPane;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class nurseSchedule extends JPanel {
	private JTextField idTextField;
	private JTextField mondayTextField;
	private JTextField tuesdayTextField;
	private JTextField wednesdayTextField;
	private JTextField thursdayTextField;
	private JTextField fridayTextField;

	/**
	 * Create the panel.
	 */
	

	public nurseSchedule() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JPanel panel = new JPanel();
		add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{137, 152, 0, 230, 0};
		gbl_panel.rowHeights = new int[]{0, 30, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel_4 = new JLabel("Nurse");
		lblNewLabel_4.setFont(new Font("Cambria", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("Schedule Builder");
		lblNewLabel.setFont(new Font("Cambria", Font.BOLD, 21));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter ID of the nurse:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		idTextField = new JTextField();
		GridBagConstraints gbc_idTextField = new GridBagConstraints();
		gbc_idTextField.insets = new Insets(0, 0, 5, 5);
		gbc_idTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_idTextField.gridx = 1;
		gbc_idTextField.gridy = 2;
		panel.add(idTextField, gbc_idTextField);
		idTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(" Enter the times in the");
		lblNewLabel_2.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("corresponding days");
		lblNewLabel_3.setFont(new Font("Cambria", Font.BOLD | Font.ITALIC, 15));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel mondayLabel = new JLabel("Monday: ");
		mondayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_mondayLabel = new GridBagConstraints();
		gbc_mondayLabel.anchor = GridBagConstraints.EAST;
		gbc_mondayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_mondayLabel.gridx = 0;
		gbc_mondayLabel.gridy = 6;
		panel.add(mondayLabel, gbc_mondayLabel);
		
		mondayTextField = new JTextField();
		GridBagConstraints gbc_mondayTextField = new GridBagConstraints();
		gbc_mondayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_mondayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_mondayTextField.gridx = 1;
		gbc_mondayTextField.gridy = 6;
		panel.add(mondayTextField, gbc_mondayTextField);
		mondayTextField.setColumns(10);
		
		JLabel tuesdayLabel = new JLabel("Tuesday: ");
		tuesdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_tuesdayLabel = new GridBagConstraints();
		gbc_tuesdayLabel.anchor = GridBagConstraints.EAST;
		gbc_tuesdayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_tuesdayLabel.gridx = 0;
		gbc_tuesdayLabel.gridy = 7;
		panel.add(tuesdayLabel, gbc_tuesdayLabel);
		
		tuesdayTextField = new JTextField();
		GridBagConstraints gbc_tuesdayTextField = new GridBagConstraints();
		gbc_tuesdayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_tuesdayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_tuesdayTextField.gridx = 1;
		gbc_tuesdayTextField.gridy = 7;
		panel.add(tuesdayTextField, gbc_tuesdayTextField);
		tuesdayTextField.setColumns(10);
		
		JLabel wednesdayLabel = new JLabel("Wednesday: ");
		wednesdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_wednesdayLabel = new GridBagConstraints();
		gbc_wednesdayLabel.anchor = GridBagConstraints.EAST;
		gbc_wednesdayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_wednesdayLabel.gridx = 0;
		gbc_wednesdayLabel.gridy = 8;
		panel.add(wednesdayLabel, gbc_wednesdayLabel);
		
		wednesdayTextField = new JTextField();
		GridBagConstraints gbc_wednesdayTextField = new GridBagConstraints();
		gbc_wednesdayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_wednesdayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_wednesdayTextField.gridx = 1;
		gbc_wednesdayTextField.gridy = 8;
		panel.add(wednesdayTextField, gbc_wednesdayTextField);
		wednesdayTextField.setColumns(10);
		
		JLabel thursdayLabel = new JLabel("Thursday: ");
		thursdayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_thursdayLabel = new GridBagConstraints();
		gbc_thursdayLabel.anchor = GridBagConstraints.EAST;
		gbc_thursdayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_thursdayLabel.gridx = 0;
		gbc_thursdayLabel.gridy = 9;
		panel.add(thursdayLabel, gbc_thursdayLabel);
		
		thursdayTextField = new JTextField();
		GridBagConstraints gbc_thursdayTextField = new GridBagConstraints();
		gbc_thursdayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_thursdayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_thursdayTextField.gridx = 1;
		gbc_thursdayTextField.gridy = 9;
		panel.add(thursdayTextField, gbc_thursdayTextField);
		thursdayTextField.setColumns(10);
		
		JLabel fridayLabel = new JLabel("Friday: ");
		fridayLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		GridBagConstraints gbc_fridayLabel = new GridBagConstraints();
		gbc_fridayLabel.anchor = GridBagConstraints.EAST;
		gbc_fridayLabel.insets = new Insets(0, 0, 5, 5);
		gbc_fridayLabel.gridx = 0;
		gbc_fridayLabel.gridy = 10;
		panel.add(fridayLabel, gbc_fridayLabel);
		
		fridayTextField = new JTextField();
		GridBagConstraints gbc_fridayTextField = new GridBagConstraints();
		gbc_fridayTextField.insets = new Insets(0, 0, 5, 5);
		gbc_fridayTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_fridayTextField.gridx = 1;
		gbc_fridayTextField.gridy = 10;
		panel.add(fridayTextField, gbc_fridayTextField);
		fridayTextField.setColumns(10);
		
		JButton backButton = new JButton("Back");

		GridBagConstraints gbc_backButton = new GridBagConstraints();
		gbc_backButton.insets = new Insets(0, 0, 0, 5);
		gbc_backButton.gridx = 1;
		gbc_backButton.gridy = 12;
		panel.add(backButton, gbc_backButton);
		
		JButton doneButton = new JButton("Done");
		doneButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				FileSystem file = new FileSystem(idTextField.getText());
				file.writeToFile(file.getFile(), mondayTextField.getText());
				file.writeToFile(file.getFile(), tuesdayTextField.getText());
				file.writeToFile(file.getFile(), wednesdayTextField.getText());
				file.writeToFile(file.getFile(), thursdayTextField.getText());
				file.writeToFile(file.getFile(), fridayTextField.getText());
				Database.load(file.getFile());
				
			}
		});
		GridBagConstraints gbc_doneButton = new GridBagConstraints();
		gbc_doneButton.insets = new Insets(0, 0, 0, 5);
		gbc_doneButton.gridx = 2;
		gbc_doneButton.gridy = 12;
		panel.add(doneButton, gbc_doneButton);

	}

}
