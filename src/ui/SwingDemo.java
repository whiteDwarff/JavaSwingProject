package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class SwingDemo extends JFrame {

	private JPanel contentPane;
	JTextField id_tf;
	private JPasswordField pw_tf;
	public static Connection con;
	private PreparedStatement ptmt;
	private ResultSet rs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DbConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingDemo frame = new SwingDemo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
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
	public SwingDemo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 615);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel();
		title.setIcon(new ImageIcon(SwingDemo.class.getResource("/img/logo2.png")));
		title.setForeground(new Color(255, 32, 12));
		title.setFont(new Font("Lucida Grande", Font.BOLD, 22));
		title.setBounds(85, 316, 271, 114);
		contentPane.add(title);
		
		id_tf = new JTextField("15");
		id_tf.setForeground(new Color(130, 130, 130));
		id_tf.setToolTipText("");
		id_tf.setText("");
		id_tf.setBounds(82, 432, 310, 37);
		contentPane.add(id_tf);
		id_tf.setColumns(10);
		
		JButton loginBtn = new JButton("로그인");
		///////////////////////////////////////////////////////
		loginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				String user = id_tf.getText();
				String pwd = new String(pw_tf.getPassword());
				String SQL = "SELECT id, password FROM USER";
				int login = 1;
				
				try {
					ptmt = con.prepareStatement(SQL);
					rs = ptmt.executeQuery();
					
					while(rs.next()) {
						String name = rs.getString("id");					   // id를 입력받는 textField에서 받아온 값을 저장 
						String password = rs.getString("password");			   // password를 입력받는 passwordField 값을 저장
						if((user.equals(name)) && (pwd.equals(password))) {    // id / password 일치여부 확인
							login = 0;
							// 로그인 성공 시 팝업창 출력 
							JOptionPane.showMessageDialog(null, "Login Successed");
							new Main().setVisible(true);    				   // Main 화면으로 이동
							setVisible(false);								   // 현재 화면 닫기
							break;
						}
					if(login == 1) {
						JOptionPane.showMessageDialog(null,"You Failed to Login");
						}
					}
				} catch (Exception ex) {
						// 로그인 실패 시 팝업창 출력
						System.out.println(ex.getMessage());
				}
			}
		});
		///////////////////////////////////////////////////////
		loginBtn.setForeground(Color.BLACK);
		loginBtn.setBackground(Color.WHITE);
		loginBtn.setFont(new Font("PingFang HK", Font.BOLD, 15));
		loginBtn.setBounds(118, 519, 103, 37);
		contentPane.add(loginBtn);
		
		JButton joinBtn = new JButton("회원가입");
		joinBtn.setFont(new Font("PingFang HK", Font.BOLD, 15));
		joinBtn.setBounds(253, 519, 103, 37);
		contentPane.add(joinBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SwingDemo.class.getResource("/img/qwertyuioytrew.jpg")));
		lblNewLabel.setBounds(0, 0, 451, 368);
		contentPane.add(lblNewLabel);
		
		pw_tf = new JPasswordField();
		pw_tf.setBounds(82, 469, 310, 37);
		contentPane.add(pw_tf);
	
		joinBtn .addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			new Join().setVisible(true); // 
			setVisible(false);
			}
			});
	}
}