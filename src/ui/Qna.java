package ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Qna extends JFrame {

	private JPanel contentPane;
	private JTextField qnaTitle_tf;
	private static Connection con;
	private PreparedStatement ptmt;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		DbConnection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Qna frame = new Qna();
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

	public Qna() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 615);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(24, 120, 402, 335);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel title = new JLabel("Q&A");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		title.setBounds(191, 50, 61, 16);
		contentPane.add(title);
		
		JLabel qnaTitle = new JLabel("제목");
		qnaTitle.setForeground(Color.WHITE);
		qnaTitle.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		qnaTitle.setBounds(19, 21, 61, 16);
		panel.add(qnaTitle);
		
		qnaTitle_tf = new JTextField();
		qnaTitle_tf.setBounds(60, 17, 323, 26);
		panel.add(qnaTitle_tf);
		qnaTitle_tf.setColumns(10);
		
		JLabel qnaContent = new JLabel("내용");
		qnaContent.setForeground(Color.WHITE);
		qnaContent.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		qnaContent.setBounds(19, 59, 61, 16);
		panel.add(qnaContent);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(60, 49, 323, 256);
		panel.add(textArea);
		
		JButton qnaBtn = new JButton("제출");
		///////////////////////////////////////////////////////
		qnaBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true); // 
				setVisible(false);
				
				String title = qnaTitle_tf.getText();
				String content = textArea.getText();
				// sql 형식의 데이터 타입
				Date sqlDate = new Date(System.currentTimeMillis());

				try {
					ptmt = con.prepareStatement("INSERT INTO INQUIRY(QNADATE, TITLE, CONTENT) VALUES(?, ?, ?)");
			
					// 날짜 형식을 넘겨주는 setDate()
					ptmt.setDate(1, sqlDate); 
					ptmt.setString(2, title);
					ptmt.setString(3, content);
					
					int k = ptmt.executeUpdate();
					
					if(k == 1) {
						// 오류가 없을 때 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Sucessfully submit!!");
						qnaTitle_tf.setText("");
						textArea.setText("");
					} else {
						JOptionPane.showMessageDialog(null,"Error to submit!!");			
					} 
				}catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					System.out.println("event error : " + e1.getMessage());
				}		
			}
		});
		///////////////////////////////////////////////////////
		qnaBtn.setBounds(164, 524, 117, 39);
		contentPane.add(qnaBtn);
		
		JLabel img = new JLabel("");
		
		img.setIcon(new ImageIcon(Qna.class.getResource("/img/3.jpg")));
		img.setBounds(0, 0, 451, 587);
		contentPane.add(img);
	}
}
