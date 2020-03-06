import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JPanel {
	private JTextField idTxtField;
	private JTextField passTxtField;

	/**
	 * Create the panel.
	 */
	public Login(JFrame frame, Authorize returningUser) {
		
		idTxtField = new JTextField();
		idTxtField.setColumns(10);
		
		passTxtField = new JTextField();
		passTxtField.setColumns(10);
		
		JLabel idLbl = new JLabel("ID");
		
		JLabel passLbl = new JLabel("Password");
		
		JButton doneBtn = new JButton("Done");
		doneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	
				int id = Integer.parseInt(idTxtField.getText());
				String pass = passTxtField.getText();
				
				boolean temp = returningUser.login(id, pass);
				System.out.println(temp);
				
				
			}
		});
		
		JLabel loginLbl = new JLabel("Login");
		loginLbl.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addGap(33)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(idLbl)
						.addComponent(passLbl))
					.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(doneBtn)
						.addComponent(passTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(135))
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(183)
					.addComponent(loginLbl)
					.addContainerGap(228, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(loginLbl)
					.addGap(53)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(idTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(idLbl))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(passTxtField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(passLbl))
					.addGap(54)
					.addComponent(doneBtn)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

}
