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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;


public class Select extends JFrame {

	private JPanel contentPane;
	public static Connection con;
	private PreparedStatement ptmt;
	ResultSet rs;
	/**
	 * Create the frame.
	 */
	
	///////////////////////////////////////////////////////////////// database connection
	public static Connection DbConnection() {
		try {
			String URL = "jdbc:mysql://localhost:8889/CMNSC_Project";
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(URL, "root", "root");
			System.out.println("The Connection Successful");
			return con;
		} catch (Exception e) {
			System.out.println("Connection Error : " + e.getMessage());
			return null;
		}
	}
	/////////////////////////////////////////////////////////////////
	public Select() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 615);
		setLocationRelativeTo(null);
		setTitle("CommonSenseConstruct Official");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));


		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("S H O P");
		lblNewLabel_4.setForeground(Color.RED);
		lblNewLabel_4.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		lblNewLabel_4.setBounds(182, 27, 224, 41);
		contentPane.add(lblNewLabel_4);

		JPanel TrackPn = new JPanel();
		TrackPn.setBackground(Color.WHITE);
		TrackPn.setBounds(16, 116, 416, 76);
		contentPane.add(TrackPn);
		TrackPn.setLayout(null);
		
		JLabel trackPantBk = new JLabel("RACING TRACK PANTS BLACK");
		trackPantBk.setForeground(Color.BLACK);
		trackPantBk.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		trackPantBk.setBounds(31, 6, 262, 33);
		TrackPn.add(trackPantBk);
		
		JLabel lblNewLabel_2 = new JLabel("220,000원");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setBounds(305, 13, 89, 20);
		TrackPn.add(lblNewLabel_2);
		
		JButton cart_1 = new JButton("장바구니");		
		///////////////////////////////////////////////////////
		cart_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO CART VALUES(now(), '1', 'RACING TRACK PANTS BLACK', 'BOTTOM', '220,000원')";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		cart_1.setBounds(117, 37, 88, 29);
		TrackPn.add(cart_1);
		
		JButton buy_1 = new JButton("구매하기");
		buy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO ORDERLIST VALUES('1', 'RACING TRACK PANTS BLACK', 'BOTTOM', '220,000원',now())";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully buy!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"faild");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		buy_1.setBounds(205, 37, 88, 29);
		TrackPn.add(buy_1);	
		buy_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		/////////////////////////////////////////////////////// RACING TRACK PANTS
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.BLACK);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(16, 216, 416, 76);
		contentPane.add(panel_1);
	
		JButton cart_2 = new JButton("장바구니");
		cart_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO CART VALUES(now(), '2', 'RACING TRACK PANTS WHITE', 'BOTTOM', '220,000원')";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		cart_2.setBounds(111, 40, 88, 29);
		panel_1.add(cart_2);
		
		
		JButton buy_2 = new JButton("구매하기");
		buy_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO ORDERLIST VALUES('2', 'RACING TRACK PANTS WHITE', 'BOTTOM', '220,000원' ,now())";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		buy_2.setBounds(199, 40, 88, 29);
		panel_1.add(buy_2);
		
		JLabel trackPn2 = new JLabel("RACING TRACK PANTS WHITE");
		trackPn2.setForeground(Color.BLACK);
		trackPn2.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		trackPn2.setBounds(32, 6, 262, 33);
		panel_1.add(trackPn2);
		
		JLabel lblNewLabel_2_1 = new JLabel("220,000원");
		lblNewLabel_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1.setBounds(303, 13, 89, 20);
		panel_1.add(lblNewLabel_2_1);
				
		JPanel capPn = new JPanel();
		capPn.setForeground(Color.WHITE);
		capPn.setLayout(null);
		capPn.setBackground(Color.WHITE);
		capPn.setBounds(16, 316, 416, 76);
		contentPane.add(capPn);
		
		JButton buy_3 = new JButton("구매하기");
		buy_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO ORDERLIST VALUES('3', 'RACING CAP BLACK WITH RED', 'ACC', '90,000원', now())";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		buy_3.setBounds(201, 43, 88, 29);
		capPn.add(buy_3);
		
		JButton cart_3 = new JButton("장바구니");
		cart_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO CART VALUES(now(), '3', 'RACING CAP BLACK WITH RED', 'ACC', '90,000원')";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		cart_3.setBounds(113, 43, 88, 29);
		capPn.add(cart_3);
		
		JLabel capBk = new JLabel("RACING CAP BLACK WITH RED");
		capBk.setForeground(Color.BLACK);
		capBk.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		capBk.setBounds(29, 6, 262, 33);
		capPn.add(capBk);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("90,000원 ");
		lblNewLabel_2_1_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2.setBounds(303, 13, 89, 20);
		capPn.add(lblNewLabel_2_1_2);


		JPanel capPn_1 = new JPanel();
		capPn_1.setBounds(16, 417, 416, 76);
		contentPane.add(capPn_1);
		capPn_1.setLayout(null);
		capPn_1.setForeground(Color.WHITE);
		capPn_1.setBackground(Color.WHITE);
		
		JButton buy_4 = new JButton("구매하기");
		buy_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO ORDERLIST VALUES('4', 'RACING CAP WHITE WITH GREY ', 'ACC', '90,000원', now())";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		buy_4.setBounds(201, 43, 88, 29);
		capPn_1.add(buy_4);
		
		JButton cart_4 = new JButton("장바구니");
		cart_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					con = DbConnection();
					String query = "INSERT INTO CART VALUES(now(), '4', 'RACING CAP WHITE WITH GREY ', 'ACC', '90,000원')";
													
					 ptmt = con.prepareStatement(query);
	                 ptmt.executeUpdate(query);
					JOptionPane.showMessageDialog(null,"Sucessfully cart!!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Failed shopping cart");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		
		cart_4.setBounds(113, 43, 88, 29);
		capPn_1.add(cart_4);
		
		JLabel capBk_1 = new JLabel("RACING CAP WHITE WITH GREY ");
		capBk_1.setForeground(Color.BLACK);
		capBk_1.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		capBk_1.setBounds(29, 6, 262, 33);
		capPn_1.add(capBk_1);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("90,000원 ");
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setBounds(303, 13, 89, 20);
		capPn_1.add(lblNewLabel_2_1_2_1);
		
		///////////////////////////////////////////////////////
		JButton leftBtn = new JButton("<");
		leftBtn.setBounds(166, 533, 45, 29);
		contentPane.add(leftBtn);
		
		JButton rightBtn = new JButton(">");
		rightBtn.setBounds(223, 533, 45, 29);
		contentPane.add(rightBtn);
		
		
		///////////////////////////////////////////////////////
		leftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Main().setVisible(true);
				setVisible(false);
			}
		});
		///////////////////////////////////////////////////////
		JLabel img = new JLabel();
		img.setIcon(new ImageIcon(Select.class.getResource("/img/3.jpg")));
		img.setBounds(0, 0, 451, 587);
		contentPane.add(img);
	}
}
