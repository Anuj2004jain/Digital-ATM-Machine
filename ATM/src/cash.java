import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.ImageIcon;

public class cash extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	static cash frame;
	static double Amount;
	static double updateBalence;
	JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cash frame = new cash();
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
		// TODO Auto-generated method stub
		frame = new cash();
		frame.setVisible(true);
	}
	
	public cash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(frame.MAXIMIZED_BOTH);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(204, 0, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 0, 102));
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				userpage userpage = new userpage();
				userpage.Frame();
			}
		});
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				textField_1.setText("");
				textField.setText("");
				textField_2.setText("");
				
			}
		});

		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnDeposit.setBackground(Color.WHITE);
		btnDeposit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cashJDBC c = new cashJDBC();
				c.Balence();
				// TODO Auto-generated method stub
				int noteList[] = {50,100,200,500};
				int note;
				int total;
				int f = 0;
				int t;
				int count = Integer.parseInt(textField.getText()) ;
				note = Integer.parseInt(textField_1.getText()) ;
				 total = Integer.parseInt(textField_2.getText());
				 
				 for(int i:noteList) {
					 if(note == i) {
						 f = 1;
						 break;
					 }
					 else {
						 f =0;
					 }
				 }
				 t = count*note;
                if(textField.getText().length()>0 && 
                		textField_1.getText().length()>0 && 
                		textField_2.getText().length()>0 && 
                		count <=10 && f ==1 && total == t ) {
                	String A = textField_2.getText();
                	Amount = Double.parseDouble(A);
                	Double B =c.balence;
                	updateBalence = B+Amount;
                	c.SetBalence();
                	lblNewLabel_3.setVisible(false);
					JOptionPane.showMessageDialog(frame, "Your Money IS Credited In Your Account" );
					ATMMachine a = new ATMMachine();
					frame.dispose();
					a.Frame();	
                }
                else {
                	lblNewLabel_3.setText("Please Enter Valid values");
					lblNewLabel_3.setVisible(true);
                } 
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Enter Numbers of Notes");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_6 = new JLabel("Note Value");
		lblNewLabel_6.setForeground(new Color(255, 255, 255));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		JLabel lblNewLabel_2 = new JLabel("Total Ammount");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 25));
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				
		            String value = textField.getText();
		            int l = value.length();
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && textField.getText().length()<2) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField.setEditable(true);
		               
		            } else {
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
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && textField_1.getText().length()<3) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField_1.setEditable(true);
		               
		            } else {
		               textField_1.setEditable(false);
		            }
		         }
		      });
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				
		            String value = textField_2.getText();
		            int l = value.length();
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && textField_2.getText().length()<4) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE ) {
		               textField_2.setEditable(true);
		               
		            } else {
		               textField_2.setEditable(false);
		            }
		         }
		      });
		
		lblNewLabel_3 = new JLabel("* Every Field Is Required");
		lblNewLabel_3.setVisible(false);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGap(35)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING, false)
								.addComponent(lblNewLabel_1, Alignment.LEADING)
								.addComponent(lblNewLabel_6, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE)
								.addComponent(lblNewLabel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
								.addComponent(textField_2, Alignment.LEADING)
								.addComponent(textField, Alignment.LEADING)))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 103, GroupLayout.PREFERRED_SIZE)
							.addGap(27)
							.addComponent(btnCancel, GroupLayout.PREFERRED_SIZE, 129, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(btnDeposit, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_1.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3, GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel_3)
					.addGap(34)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(lblNewLabel_2, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addGap(74)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCancel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnDeposit))
					.addGap(21))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\logo2.jpg"));
		
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
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(529, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 450, GroupLayout.PREFERRED_SIZE)
					.addGap(371))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 168, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
					.addGap(267)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
					.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 95, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(37)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblNewLabel_7, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(7)
									.addComponent(lblNewLabel_1_1_1, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
							.addGap(37)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 535, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNewLabel_4_1, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(47, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	

}
