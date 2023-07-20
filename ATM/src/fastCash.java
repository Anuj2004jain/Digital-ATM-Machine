import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class fastCash extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JPasswordField passwordField;
	static fastCash frame;
	static int amount;
	static double updatedBalence;

	/**
	 * Launch the application.
	 */
	
	/* public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fastCash frame = new fastCash();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	
	public void Frame() {
		frame = new fastCash();
		frame.setVisible(true);
	}
	
	public fastCash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 102));
		
		JLabel lblNewLabel_2 = new JLabel("* Every Field Is Required");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		
		JLabel lblNewLabel_4_1_1 = new JLabel("");
		lblNewLabel_4_1_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\logo2.jpg"));
		
		JLabel lblNewLabel_3_1 = new JLabel("SBI");
		lblNewLabel_3_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 80));
		
		JLabel lblNewLabel = new JLabel("Enter The Details");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblNewLabel_7 = new JLabel("Hello User");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\new.jpg"));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNewLabel_2))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(95)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(34)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE))))
							.addGap(14)
							.addComponent(lblNewLabel_2)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4_1_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(119, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel_1 = new JLabel("Select the Amount");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("100");
		rdbtnNewRadioButton.setBackground(new Color(255, 255, 255));
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("500");
		rdbtnNewRadioButton_1.setBackground(new Color(255, 255, 255));
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("1000");
		rdbtnNewRadioButton_2.setBackground(new Color(255, 255, 255));
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("2000");
		rdbtnNewRadioButton_3.setBackground(new Color(255, 255, 255));
		
		
		ButtonGroup radioButtonGroup = new ButtonGroup();
		radioButtonGroup.add(rdbtnNewRadioButton_3);
		radioButtonGroup.add(rdbtnNewRadioButton_2);
		radioButtonGroup.add(rdbtnNewRadioButton_1);
		radioButtonGroup.add(rdbtnNewRadioButton);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(this);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
				rdbtnNewRadioButton.setSelected(false);
				rdbtnNewRadioButton_1.setSelected(false);
				rdbtnNewRadioButton_2.setSelected(false);
				rdbtnNewRadioButton_3.setSelected(false);
			}
		});
		
		JButton btnCheck = new JButton("Enter");
		btnCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				fastcashJDBC f = new fastcashJDBC();
				f.Balence();
				f.password();
				
				if((rdbtnNewRadioButton.isSelected())){
					String money = rdbtnNewRadioButton.getText();
					amount = Integer.parseInt(money);
				}
				else if(rdbtnNewRadioButton_1.isSelected()) {
					String money = rdbtnNewRadioButton_1.getText();
					amount = Integer.parseInt(money);
					
				}
				
				else if(rdbtnNewRadioButton_2.isSelected()) {
					String money = rdbtnNewRadioButton_2.getText();
					amount = Integer.parseInt(money);
					
				}
				else if(rdbtnNewRadioButton_3.isSelected()) {
					String money = rdbtnNewRadioButton_3.getText();
					amount = Integer.parseInt(money);
					
				}
				
				// TODO Auto-generated method stub
				if((rdbtnNewRadioButton.isSelected() ||
						rdbtnNewRadioButton_1.isSelected() ||
						rdbtnNewRadioButton_2.isSelected() ||
						rdbtnNewRadioButton_3.isSelected() )&&
						passwordField.getText().equals(f.password) &&
						amount<=f.balence) {
					updatedBalence = f.balence-amount;
					f.SetBalence();
					lblNewLabel_2.setVisible(false);
					JOptionPane.showMessageDialog(frame, "collect your money " );
					ATMMachine a = new ATMMachine();
					frame.dispose();
					a.Frame();
					
				}
				else {
					lblNewLabel_2.setVisible(true);
					}
			}
		});
			
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCheck.setBackground(Color.WHITE);
		
		JLabel lblNewLabel_1_1 = new JLabel("Enter Your Password");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		passwordField = new JPasswordField();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton)
					.addGap(18)
					.addComponent(btnCancel)
					.addGap(18)
					.addComponent(btnCheck, GroupLayout.PREFERRED_SIZE, 115, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(25, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(100)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 232, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGap(20)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addComponent(rdbtnNewRadioButton)
										.addComponent(rdbtnNewRadioButton_1))
									.addGap(67)
									.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
										.addComponent(rdbtnNewRadioButton_2)
										.addComponent(rdbtnNewRadioButton_3)))
								.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
							.addGap(97))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(33)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton)
						.addComponent(rdbtnNewRadioButton_2))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnNewRadioButton_1)
						.addComponent(rdbtnNewRadioButton_3))
					.addGap(48)
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(60)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCheck))
					.addContainerGap(31, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		contentPane.setLayout(gl_contentPane);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		frame.dispose();
		userpage userpage = new userpage();
		userpage.Frame();
	}
}
