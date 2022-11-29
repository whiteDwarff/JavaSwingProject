package ui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class OrderList extends JFrame {

	public static Connection con;
	ResultSet rs;
	/**
	 * Create the frame.
	 */
	public static String[][] tableSetting(){
		
		try {
			con = DbConnection();
			String SQL = "SELECT * FROM `orderList`";
			PreparedStatement ptmt = con.prepareStatement(SQL);

			ResultSet rs = ptmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("pdNumber"),
						rs.getString("pdName"),
						rs.getString("pdCategory"),
						rs.getString("pdPrice"),
						rs.getString("date"),
				});
			}
			System.out.println("The data has been fatched");
			// list의 사이즈와 col의 갯수
			String[][] arr = new String[list.size()][5];
			return list.toArray(arr);
			 
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Customers Error : " + e.getMessage());
		}
		return null;
	}
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
	public OrderList() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setTitle("CommonSenseConstruct Official");
		// 크기 변경 불가
		frame.setResizable(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 698, 593);
		String[] headings = new String[]{"Number", "Name", "Category", "Price","Date"};
		String[][] data = OrderList.tableSetting();
//		frame.getContentPane().setLayout(null);

		frame.setVisible(true);
		frame.setSize(698, 620);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		panel.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(data, headings);
		JTable table = new JTable(model);
		table.setSize(500,300);
		table.setRowHeight(30);
		
		TableColumnModel columnModels = table.getColumnModel();
		// column의 크기를 조절
		columnModels.getColumn(0).setPreferredWidth(50);
		columnModels.getColumn(1).setPreferredWidth(240);
		columnModels.getColumn(2).setPreferredWidth(60);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(60, 129, 567, 324);
		scrollPane.setPreferredSize(new Dimension(200,200));
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
		

		JButton mainBtn = new JButton("<");
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Main().setVisible(true);
			}
		});
		mainBtn.setBounds(314, 537, 52, 34);
		panel.add(mainBtn);
		
		JLabel titleLabel = new JLabel("O R D E R  L I S T");
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		titleLabel.setBounds(234, 17, 229, 32);
		panel.add(titleLabel);
		

		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setIcon(new ImageIcon(Cart.class.getResource("/img/add.jpg")));
		imgLabel.setBounds(0, -42, 698, 653);
		panel.add(imgLabel);
	}
}
