package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.BorderLayout;
import javax.swing.JCheckBox;
import javax.swing.JButton;

public class Buy extends JFrame {

	private JPanel contentPane;
	private JTextField name_tf;
	private JTextField adress_tf;
	private JTextField adress_tf2;
	private JTextField tel_tf1;
	private JTextField tel_tf2;
	private JTextField tel_tf3;
	private JTextField email_tf;
	private JTextField clientName_tf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Buy frame = new Buy();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Buy() {
		try {
		    UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );
		 } catch (Exception e) {
		            e.printStackTrace();
		 }
		////////////////////////////////////////////////////////////////////////////////
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 615);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel guide1 = new JLabel("배송지");
		guide1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		guide1.setBounds(21, 16, 61, 16);
		contentPane.add(guide1);
		
		JPanel clientInfo = new JPanel();
		clientInfo.setBackground(new Color(255, 255, 255));
		clientInfo.setBounds(21, 36, 406, 218);
		contentPane.add(clientInfo);
		clientInfo.setLayout(null);
		
		
		
		
		
		JLabel name = new JLabel("이름");
		name.setBounds(47, 29, 22, 16);
		clientInfo.add(name);
		
		name_tf = new JTextField();
		name_tf.setBounds(105, 24, 130, 26);
		name_tf.setColumns(10);
		clientInfo.add(name_tf); // 이름 
		
		JLabel adress = new JLabel("주소");
		adress.setBounds(47, 57, 22, 16);
		clientInfo.add(adress);
		
		adress_tf = new JTextField();
		adress_tf.setForeground(new Color(0, 0, 0));
		adress_tf.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		adress_tf.setBounds(105, 77, 295, 26);
		clientInfo.add(adress_tf);
		adress_tf.setColumns(10);
		
		adress_tf2 = new JTextField();
		adress_tf2.setFont(new Font("Lucida Grande", Font.PLAIN, 12));
		adress_tf2.setForeground(new Color(0, 0, 0));
		adress_tf2.setBounds(105, 52, 295, 26);
		clientInfo.add(adress_tf2);
		adress_tf2.setColumns(10); // 주소
		
		
		JLabel tel = new JLabel("휴대전화");
		tel.setBounds(47, 125, 44, 16);
		clientInfo.add(tel);
		
		tel_tf1 = new JTextField();
		tel_tf1.setBounds(105, 120, 58, 26);
		tel_tf1.setColumns(10);
		clientInfo.add(tel_tf1);
		
		tel_tf2 = new JTextField();
		tel_tf2.setBounds(177, 120, 58, 26);
		tel_tf2.setColumns(10);
		clientInfo.add(tel_tf2);
		
		tel_tf3 = new JTextField();
		tel_tf3.setBounds(256, 120, 58, 26);
		tel_tf3.setColumns(10);
		clientInfo.add(tel_tf3); 
		
		JLabel tel_line1 = new JLabel("-");
		tel_line1.setBounds(241, 125, 8, 16);
		clientInfo.add(tel_line1);
		
		JLabel tel_line2= new JLabel("-");
		tel_line2.setBounds(167, 125, 8, 16);
		clientInfo.add(tel_line2); // 휴대전화
		
		JLabel email = new JLabel("이메일");
		email.setBounds(47, 163, 33, 16);
		clientInfo.add(email);
		
		email_tf = new JTextField();
		email_tf.setBounds(105, 163, 209, 26);
		email_tf.setColumns(10);
		clientInfo.add(email_tf);
		//------------------------------------------- JPanel 1
		
		
		JLabel guide2 = new JLabel("결제수단");
		guide2.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		guide2.setBounds(21, 276, 61, 16);
		contentPane.add(guide2);
	
		JPanel bankInfo = new JPanel();
		bankInfo.setBackground(Color.WHITE);
		bankInfo.setBounds(21, 295, 406, 98);
		contentPane.add(bankInfo);
		bankInfo.setLayout(null);
		
		JRadioButton radioBtn = new JRadioButton("무통장입금");
		radioBtn.setBackground(Color.WHITE);
		radioBtn.setBounds(18, 6, 117, 23);
		bankInfo.add(radioBtn);
		
		JLabel info = new JLabel("입금은행");
		info.setBounds(28, 41, 49, 16);
		bankInfo.add(info);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"::: 선택해 주세요 :::", "하나은행 : 28791036517807 강문호"}));
		comboBox.setBounds(89, 37, 271, 27);
		bankInfo.add(comboBox);
		
		JLabel clientName = new JLabel("입금자명");
		clientName.setBounds(28, 69, 49, 16);
		bankInfo.add(clientName);
		
		clientName_tf = new JTextField();
		clientName_tf.setBounds(89, 64, 271, 26);
		bankInfo.add(clientName_tf);
		clientName_tf.setColumns(10);
		//------------------------------------------- JPanel 2

		
		JLabel guide3 = new JLabel("이용약관동의");
		guide3.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		guide3.setBounds(21, 416, 130, 16);
		contentPane.add(guide3);
		
		JPanel TermsOfService = new JPanel();
		TermsOfService.setBackground(new Color(252, 255, 255));
		TermsOfService.setBounds(21, 435, 406, 59);
		contentPane.add(TermsOfService);
		TermsOfService.setLayout(null);
		
		JCheckBox checkBox1 = new JCheckBox("[ 필수 ] 구매조건 확인 및 결제진행 동의");
		checkBox1.setBackground(new Color(253, 254, 255));
		checkBox1.setBounds(17, 6, 282, 23);
		TermsOfService.add(checkBox1);
		
		JCheckBox checkBox2 = new JCheckBox("[ 필수 ] 쇼핑몰 이용약관 동의\n");
		checkBox2.setBackground(new Color(252, 254, 255));
		checkBox2.setBounds(17, 29, 282, 23);
		TermsOfService.add(checkBox2);
		
		JButton buyBtn = new JButton("결제하기");
		buyBtn.setForeground(new Color(243, 253, 255));
		buyBtn.setBackground(new Color(197, 15, 0));
		buyBtn.setBounds(79, 524, 130, 36);
		contentPane.add(buyBtn);
		
		JButton canBtn = new JButton("취소하기");
		canBtn.setBackground(new Color(5, 5, 56));
		canBtn.setForeground(Color.WHITE);
		///////////////////////////////////////////////////////
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new OrderList().setVisible(true); // 
				setVisible(false);
			}
		});
		canBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				}
		});
		///////////////////////////////////////////////////////
		canBtn.setBounds(227, 524, 130, 36);
		contentPane.add(canBtn);
	}
}
