import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.ImageIcon;

public class transfer extends JFrame implements ActionListener {

	private JPanel contentPane;
	public static JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;
	static transfer frame;
	JLabel lblNewLabel_9 ;
	static Double updateReciverBalence;
	static Double updatesenderBalence;
	static String num;
	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { frame = new transfer();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public void Frame() {
		frame = new transfer();
		frame.setVisible(true);
	}
	
	public transfer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		//setExtendedState(frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel_1 = new JLabel("Account Number");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_2 = new JLabel("Re-enter account number");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_3 = new JLabel("IFSC code");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_5 = new JLabel("Amount");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_6 = new JLabel("Password");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				
		            String value = textField.getText();
		            int l = value.length();
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && textField.getText().length()<15) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField.setEditable(true);
		               
		            } 
		            else {
		               textField.setEditable(false);
		            }
		         }
		      });
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				
		            String value = textField_1.getText();
		            int l = value.length();
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && textField_1.getText().length()<15) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField_1.setEditable(true);
		               
		            } else {
		               textField_1.setEditable(false);
		            }
		         }
		      });
		
		JLabel lblNewLabel_4 = new JLabel("Account holder's name");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(15);
		textField_4.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				
		            String value = textField_4.getText();
		            int l = value.length();
		            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField_4.setEditable(true);
		               
		            } else {
		               textField_4.setEditable(false);
		            }
		         }
		      });
		
		passwordField = new JPasswordField();
		
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
				textField.setText("");
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
				textField_4.setText("");
				passwordField.setText("");
				
			}
		});
		
		JButton btnTransfer = new JButton("TRANSFER");
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnTransfer.setBackground(Color.WHITE);
		btnTransfer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				num = textField.getText();
				System.out.println(num);
				
				transferJDBC tj = new transferJDBC();
				tj.Account();
				tj.AccountDetails();
				tj.Balence();
				tj.password();
				boolean flag = false;
				String name = tj.Name;
				String ifsc = tj.IFSC;
				String pass = tj.password;
				Double recieverbalence = tj.balence;
				Double Balence = tj.Acc_Balence;
				String b = textField_4.getText();
				System.out.println(b);
				
				
				/*
				 * System.out.println(name); System.out.println(tj.Name);
				 * System.out.println(ifsc); System.out.println(tj.IFSC);
				 * System.out.println(pass); System.out.println(tj.password);
				 * System.out.println(balence); System.out.println(tj.balence);
				 */
				for (String i : tj.l) {
					if(i.equals(num)) {
						
						flag = true;
					}
					
				}
				// TODO Auto-generated method stub
				if(/*num.length() == 0 ||*/
						textField_1.getText().length()==0 ||
						textField_2.getText().length()==0 || 
						textField_3.getText().length()==0 ||
						textField_4.getText().length()==0 ||
						passwordField.getText().length()==0 ) {
					System.out.println(textField.getText());
					System.out.println(b);
					System.out.println("IF");
					lblNewLabel_9.setText("* Every Field Is Required");
					lblNewLabel_9.setVisible(true);
				}
				else {
					System.out.println("else");
					double Amount = Double.parseDouble(b);
					if((flag == true) && 
							textField_1.getText().equals(num) && 
							(Amount <= Balence) &&
							textField_2.getText().equals(ifsc)  &&
							textField_3.getText().equals(name) && 
							passwordField.getText().equals(pass)) {
						System.out.println("elseif");
						updatesenderBalence = recieverbalence-Amount;
						updateReciverBalence= Balence+Amount;
						
						tj.SetReciverBalence();
						tj.SetSenderBalence();
						lblNewLabel_9.setVisible(false);
						JOptionPane.showMessageDialog(frame, "Your Transaction Is successfully Complete.");
						ATMMachine a = new ATMMachine();
						frame.dispose();
						a.Frame();
					}
					else {
						System.out.println("else-else");
						lblNewLabel_9.setText("Re-check Your Entered Details");
						lblNewLabel_9.setVisible(true);
					}
					
				}
				
			}
		});
		
		lblNewLabel_9 = new JLabel(" *Every Field Is Required");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("Enter The Details");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\logo2.jpg"));
		
		JLabel lblNewLabel_3_1 = new JLabel("SBI");
		lblNewLabel_3_1.setForeground(new Color(51, 51, 204));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 80));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\new.jpg"));
		
		JLabel lblNewLabel_7 = new JLabel("Hello User");
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 40));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
									.addGap(102)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(btnNewButton)
											.addPreferredGap(ComponentPlacement.RELATED, 156, Short.MAX_VALUE)
											.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
											.addGap(148)
											.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel_1)
												.addComponent(textField, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_2)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblNewLabel_5)
												.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 272, GroupLayout.PREFERRED_SIZE))
											.addGap(159)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordField, 272, 272, 272)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
													.addComponent(lblNewLabel_3)
													.addComponent(textField_2, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
													.addComponent(lblNewLabel_4)
													.addComponent(textField_3, GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
													.addComponent(lblNewLabel_6)))))
									.addGap(228))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblNewLabel)
									.addGap(193)
									.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
									.addGap(18)
									.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(212)
							.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 478, GroupLayout.PREFERRED_SIZE))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(595, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(648, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(35, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(32)
					.addComponent(lblNewLabel_9, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(lblNewLabel_4))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_6))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(textField_4, GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
					.addGap(49)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton)
						.addComponent(btnTransfer, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE))
					.addGap(150))
		);
		contentPane.setLayout(gl_contentPane);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
			userpage userpage = new userpage();
			frame.dispose();
			userpage.Frame();
		
		
		
	}
}
