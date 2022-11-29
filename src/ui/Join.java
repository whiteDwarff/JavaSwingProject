package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Join extends JFrame {

	private JPanel contentPane;
	private JTextField id_tf;
	private JTextField pw_tf;
	private JTextField adress_tf;
	private JTextField name_tf;
	private JTextField tel_tf1;
	private JTextField email_tf;
	
	public static Connection con;
	private PreparedStatement ptmt;
//	private ResultSet rs;

	public static void DbConnection() {
		try {
			String URL = "jdbc:mysql://localhost:8889/CMNSC_Project";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "root");
			System.out.println("The Connection Successful");
		} catch (Exception e) {
			System.out.println("Connection Error : " + e.getMessage());
		}
	}
	
	/**
	 * Create the frame.
	 */
	public Join() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 666);
		setLocationRelativeTo(null);
		setTitle("CommonSenseConstruct Official");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel guide1 = new JLabel("회원가입");
		guide1.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		guide1.setBounds(53, 35, 61, 16);
		contentPane.add(guide1);
		
		
		
		JPanel clientInfo = new JPanel();
		clientInfo.setBackground(Color.WHITE);
		clientInfo.setBorder(new LineBorder(new Color(196, 196, 196)));
		clientInfo.setBounds(53, 65, 589, 258);
		contentPane.add(clientInfo);
		clientInfo.setLayout(null);
		
		JLabel id = new JLabel("아이디");
		id.setBounds(78, 44, 33, 16);
		clientInfo.add(id);
		
		id_tf = new JTextField();
		id_tf.setBounds(160, 35, 130, 25);
		clientInfo.add(id_tf);
		id_tf.setColumns(10);
		
		JLabel idInfo = new JLabel("(영어소문자/숫자, 4~16자)");
		idInfo.setBounds(302, 40, 164, 16);
		clientInfo.add(idInfo);
		idInfo.setForeground(new Color(0, 0, 0)); // id
		

		JLabel pw = new JLabel("비밀번호");
		pw.setBounds(78, 81, 53, 16);
		clientInfo.add(pw);
		
		pw_tf = new JTextField();
		pw_tf.setColumns(10);
		pw_tf.setBounds(160, 72, 130, 25);
		clientInfo.add(pw_tf);
		
		JLabel pwInfo = new JLabel("(영문 대소문자/숫자/특수문자 중 2가지 이상 조합)");
		pwInfo.setForeground(Color.BLACK);
		pwInfo.setBounds(302, 77, 281, 16);
		clientInfo.add(pwInfo);
		
		JLabel adress = new JLabel("주소");
		adress.setBounds(78, 147, 70, 16);
		clientInfo.add(adress);
		
		adress_tf = new JTextField();
		adress_tf.setColumns(10);
		adress_tf.setBounds(160, 142, 130, 25);
		clientInfo.add(adress_tf);	// pw
		
		JLabel name = new JLabel("이름");
		name.setBounds(79, 114, 70, 16);
		clientInfo.add(name);
		
		name_tf = new JTextField();
		name_tf.setColumns(10);
		name_tf.setBounds(161, 109, 130, 25);
		clientInfo.add(name_tf);	// name
		
		JLabel tel = new JLabel("휴대전화");
		tel.setBounds(78, 182, 70, 16);
		clientInfo.add(tel);
		
		tel_tf1 = new JTextField();
		tel_tf1.setColumns(10);
		tel_tf1.setBounds(160, 177, 130, 25);
		clientInfo.add(tel_tf1);
		
		JLabel email = new JLabel("이메일");
		email.setBounds(78, 217, 70, 16);
		clientInfo.add(email);
		
		email_tf = new JTextField();
		email_tf.setColumns(10);
		email_tf.setBounds(160, 212, 130, 25);
		clientInfo.add(email_tf);	// email
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new LineBorder(new Color(201, 200, 202)));
		panel_1.setBounds(53, 376, 594, 172);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("\t이용약관 및 개인정보수집 및 이용, 쇼핑정보 수신(선택)에 모두 동의합니다.");
		chckbxNewCheckBox.setBackground(Color.WHITE);
		chckbxNewCheckBox.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		chckbxNewCheckBox.setBounds(65, 16, 414, 23);
		panel_1.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("동의함");
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(367, 51, 128, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("[필수] 이용약관에 동의하십니까?\n");
		lblNewLabel_4.setLabelFor(chckbxNewCheckBox_1);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_4.setBounds(105, 52, 198, 23);
		panel_1.add(lblNewLabel_4);
		
		JCheckBox chckbxNewCheckBox_1_1 = new JCheckBox("동의함");
		chckbxNewCheckBox_1_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1_1.setBounds(367, 74, 128, 23);
		panel_1.add(chckbxNewCheckBox_1_1);
		
		JLabel lblNewLabel_4_1 = new JLabel("[필수] 개인정보 수집 및 이용에 동의하십니까? ");
		lblNewLabel_4_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(105, 75, 289, 23);
		panel_1.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("[선택] 쇼핑정보 수신 동의\n");
		lblNewLabel_4_1_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_4_1_1.setBounds(105, 98, 289, 23);
		panel_1.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_5 = new JLabel("SMS 수신을 동의하십니까?");
		lblNewLabel_5.setBounds(138, 124, 159, 16);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_5_1 = new JLabel("이메일 수신을 동의하십니까?");
		lblNewLabel_5_1.setBounds(138, 142, 159, 16);
		panel_1.add(lblNewLabel_5_1);
		
		JCheckBox chckbxNewCheckBox_1_1_1 = new JCheckBox("동의함");
		chckbxNewCheckBox_1_1_1.setBackground(Color.WHITE);
		lblNewLabel_5.setLabelFor(chckbxNewCheckBox_1_1_1);
		chckbxNewCheckBox_1_1_1.setBounds(367, 120, 128, 23);
		panel_1.add(chckbxNewCheckBox_1_1_1);
		
		JCheckBox chckbxNewCheckBox_1_1_2 = new JCheckBox("동의함");
		chckbxNewCheckBox_1_1_2.setBackground(Color.WHITE);
		lblNewLabel_5_1.setLabelFor(chckbxNewCheckBox_1_1_2);
		chckbxNewCheckBox_1_1_2.setBounds(367, 138, 128, 23);
		panel_1.add(chckbxNewCheckBox_1_1_2);
		
		JLabel lblNewLabel_3 = new JLabel("전체동의");
		lblNewLabel_3.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(53, 348, 61, 16);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				
				new SwingDemo().setVisible(true);
				setVisible(false);
				
				String userId = id_tf.getText();
				String userPassword = pw_tf.getText();
				String userName = name_tf.getText();
				String userAdress = adress_tf.getText();
				String userPhone = tel_tf1.getText();
				String userEmail = email_tf.getText();

				try {
					String sql = "INSERT INTO USER(ID, PASSWORD, NAME, PHONE, ADRESS, EMAIL) VALUES(?, ?, ?, ?, ?, ?)";
					ptmt = con.prepareStatement(sql);
					ptmt.setString(1, userId);
					ptmt.setString(2, userPassword);
					ptmt.setString(3, userName);
					ptmt.setString(4, userAdress);
					ptmt.setString(5, userPhone);
					ptmt.setString(6, userEmail);
					
					int k = ptmt.executeUpdate(sql);
					
					if(k == 1) {
						id_tf.setText("");
						pw_tf.setText("");
						name_tf.setText("");
						adress_tf.setText("");
						tel_tf1.setText("");
						email_tf.setText("");
						// 오류가 없을 때 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Sucessfully insert!!");

					} else {
						// 오류발생 시 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Failed to insert!!");

					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.out.println("event error : " + e1.getMessage());
					JOptionPane.showMessageDialog(null,"dadada!!");
				}
			}
		});
		
		///////////////////////////////////////////////////////
//		joinBtn.addActionListener(e -> {
//			new SwingDemo().setVisible(true);
//			setVisible(false);
//			
//			String userId = id_tf.getText();
//			String userPassword = pw_tf.getText();
//			String userName = name_tf.getText();
//			String userAdress = adress_tf.getText();
//			String userPhone = tel_tf1.getText();
//			String userEmail = email_tf.getText();
//
//			try {
//				ptmt = con.prepareStatement("INSERT INTO USER(ID, PASSWORD, NAME, PHONE, ADRESS, EMAIL) VALUES(?, ?, ?, ?, ?, ?)");
//				ptmt.setString(1, userId);
//				ptmt.setString(2, userPassword);
//				ptmt.setString(3, userName);
//				ptmt.setString(4, userAdress);
//				ptmt.setString(5, userPhone);
//				ptmt.setString(6, userEmail);
//				
//				int k = ptmt.executeUpdate();
//				
//				if(k == 1) {
//					id_tf.setText("");
//					pw_tf.setText("");
//					name_tf.setText("");
//					adress_tf.setText("");
//					tel_tf1.setText("");
//					email_tf.setText("");
//					// 오류가 없을 때 팝업 메세지 실행 
//					JOptionPane.showMessageDialog(null,"Sucessfully insert!!");
//
//				} else {
//					// 오류발생 시 팝업 메세지 실행 
//					JOptionPane.showMessageDialog(null,"Error to insert!!");
//
//				}
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				System.out.println("event error : " + e1.getMessage());
//			}
//		});
		///////////////////////////////////////////////////////
		joinBtn.setBackground(Color.WHITE);
		joinBtn.setBounds(273, 573, 149, 42);
		contentPane.add(joinBtn);
	}
}
