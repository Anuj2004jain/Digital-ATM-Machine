import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Event;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.lang.ProcessBuilder.Redirect;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.Box;
import javax.swing.border.LineBorder;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ATMMachine extends JFrame implements ActionListener {

	private JPanel contentPane;

	public JTextField txtHbv;
	JLabel lblNewLabel_2;
	static String num;
	static ATMMachine frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
					frame = new ATMMachine();
					frame.setVisible(true);
				
			}
		});
	}
	public void Frame() {
		frame = new ATMMachine();
		frame.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		num = txtHbv.getText();
		ATMmachineJDBC atm = new ATMmachineJDBC();
		atm.card();
		boolean flag = false;
		
			String card = txtHbv.getText();
			for (String i : atm.l) {
				if(i.equals(card)) {
					flag = true;
				}
			}
		if(flag == true) {
			lblNewLabel_2.setVisible(false);
			userpage user = new userpage();
			frame.dispose();
			user.Frame();
		}
		else {
			if(txtHbv.getText().length()==0) {
				lblNewLabel_2.setText("* This Field Is Required ");
				lblNewLabel_2.setVisible(true);
			}
			
			else if(flag == false) {
			lblNewLabel_2.setText("* Check Your Card Number ");
			lblNewLabel_2.setVisible(true);
			}
			
		}
			
	}

	/**
	 * Create the frame.
	 */
	public ATMMachine() {
		getContentPane().setBackground(new Color(204, 0, 102));
		getContentPane().setForeground(new Color(204, 0, 102));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		
		JLabel lblNewLabel = new JLabel("WELCOME TO SBI ATM BANK");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(null);
		
		JLabel lblNewLabel_3 = new JLabel("SBI");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 80));
		lblNewLabel_3.setForeground(new Color(51, 51, 204));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\IMG\\logo2.jpg"));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(43)
					.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 904, GroupLayout.PREFERRED_SIZE)
					.addGap(211))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_4)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_3)
					.addPreferredGap(ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 553, GroupLayout.PREFERRED_SIZE)
					.addGap(363))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(25)
							.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(lblNewLabel_3)))
					.addGap(24)
					.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 465, GroupLayout.PREFERRED_SIZE)
					.addGap(131))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(lblNewLabel_4)
					.addContainerGap(715, Short.MAX_VALUE))
		);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(255, 0, 102));
		horizontalBox.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Your Card Number");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		
		JSeparator separator = new JSeparator();
		
		txtHbv = new JTextField();
		txtHbv.setHorizontalAlignment(SwingConstants.CENTER);
		txtHbv.setColumns(10);
		txtHbv.addKeyListener(new KeyAdapter(){
			 public void keyPressed(KeyEvent ke) {
				    
		            String value = txtHbv.getText();
		            int l = value.length();
		            if (((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') && txtHbv.getText().length()<12) || ke.getKeyChar() == KeyEvent.VK_BACK_SPACE || ke.getKeyChar() == KeyEvent.VK_CONTROL ) {
		               txtHbv.setEditable(true);
		               
		            } else {
		               txtHbv.setEditable(false);
		            }
		         }
		      });
			

		JButton btnNewButton = new JButton("NEXT");
		
		btnNewButton.addActionListener(this);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBackground(Color.WHITE);
		
		lblNewLabel_2 = new JLabel("*This Feild Is Required.");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setVisible(false);
		
		JButton btnNewButton_1 = new JButton("LOGOUT");
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		}
		);
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(311)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_2)
						.addComponent(txtHbv, GroupLayout.PREFERRED_SIZE, 301, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(291, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(205)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(separator, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 492, Short.MAX_VALUE))
					.addGap(206))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(248)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 157, GroupLayout.PREFERRED_SIZE)
					.addGap(87)
					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(245, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(92)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_2)
					.addGap(27)
					.addComponent(txtHbv, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
					.addGap(27)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 52, Short.MAX_VALUE)
						.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, 52, Short.MAX_VALUE))
					.addGap(108))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		
		
	}
}
