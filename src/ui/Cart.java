package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cart extends JFrame {

	public static Connection con;
	private PreparedStatement ptmt;
	ResultSet rs;
	private JTextField number_tf;
	private JTextField name_tf;
	private JTextField cate_tf;
	private JTextField price_tf;

	/**
	 * Create the frame.
	 */
	
	public static String[][] tableSetting(){
		
		try {
			con = DbConnection();
			String SQL = "SELECT * FROM CART";
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
	
	
	public Cart() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setTitle("CommonSenseConstruct Official");
		// 크기 변경 불가
		frame.setResizable(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 698, 593);
	
		frame.setVisible(true);
		frame.setSize(698, 620);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
		panel.setLayout(null);
		
		String[] headings = new String[]{"Number", "Name", "Category", "Price","Date"};
		String[][] data = Cart.tableSetting();

		DefaultTableModel model = new DefaultTableModel(data, headings);
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				int row1 = table.getSelectedRow();
				int row2 = table.getSelectedRow();
				int row3 = table.getSelectedRow();
				int row4 = table.getSelectedRow();

                String cell1 = table.getModel().getValueAt(row1, 0).toString();
                String cell2 = table.getModel().getValueAt(row2, 1).toString();
                String cell3 = table.getModel().getValueAt(row3, 2).toString();
                String cell4 = table.getModel().getValueAt(row4, 3).toString();

				String mouseClick = table.getModel().getValueAt(row, 0).toString();
				
				try {
					String sql = "SELECT * FROM CART WHERE PDNUMBER = '" + mouseClick + "'";
					ptmt = con.prepareStatement(sql);
					rs = ptmt.executeQuery(sql);
					
					if(rs.next()){
						number_tf.setText(cell1);
						name_tf.setText(cell2);
						cate_tf.setText(cell3);
						price_tf.setText(cell4);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("import error : " + e2.getMessage());
				}
			}
		});
		table.setSize(500,300);
		table.setRowHeight(30);
		
		TableColumnModel columnModels = table.getColumnModel();
		// column의 크기를 조절
		columnModels.getColumn(0).setPreferredWidth(50);
		columnModels.getColumn(1).setPreferredWidth(240);
		columnModels.getColumn(2).setPreferredWidth(60);


		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(61, 61, 567, 324);
		scrollPane.setPreferredSize(new Dimension(200,200));
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
		
		JButton deleteBtn = new JButton("DELETE");
			deleteBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// table data를 삭제하는 event
						int row = table.getSelectedRow();
						String cell = table.getModel().getValueAt(row, 0).toString();
						String sql = "DELETE FROM CART WHERE PDNUMBER = " + "'" + cell + "'";
						System.out.println(sql);
						try {
							ptmt = con.prepareStatement(sql);
							ptmt.execute();
							JOptionPane.showMessageDialog(null,"Deleted Succesfully");
						} catch (Exception e2) {
							// TODO: handle exception
							JOptionPane.showMessageDialog(null,"Deleted Error!!");
							System.out.println("deleted error : " + e2.getMessage());
						} 
						model.removeRow(row);
				}
		});
		deleteBtn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		deleteBtn.setBounds(192, 466, 138, 51);
		panel.add(deleteBtn);
		
		JButton buyBtn = new JButton("BUY NOW");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String number = number_tf.getText();
				String name = name_tf.getText();
				String cagegory = cate_tf.getText();
				String price = price_tf.getText();

				try {
					ptmt = con.prepareStatement("INSERT INTO ORDERLIST(pdNumber, pdName, pdCategory, pdPrice, DATE) VALUES(?, ?, ?, ?, NOW())");
					ptmt.setString(1, number);
					ptmt.setString(2, name);
					ptmt.setString(3, cagegory);
					ptmt.setString(4, price);
					
					int k = ptmt.executeUpdate();
					
					if(k == 1) {
						// 오류가 없을 때 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Sucessfully Buy!!");
						number_tf.setText("");
						name_tf.setText("");
						cate_tf.setText("");
						price_tf.setText("");
					} else {
						// 오류발생 시 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Error to add!!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"faild");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		buyBtn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		buyBtn.setBounds(352, 466, 138, 51);
		panel.add(buyBtn);
		
		JButton mainBtn = new JButton("<");
		mainBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Main().setVisible(true);
			}
		});
		mainBtn.setBounds(314, 537, 52, 34);
		panel.add(mainBtn);
		
		JLabel titleLabel = new JLabel("C A R T");
		titleLabel.setForeground(Color.RED);
		titleLabel.setFont(new Font("Lucida Grande", Font.BOLD, 20));
		titleLabel.setBounds(285, 17, 126, 32);
		panel.add(titleLabel);
		
		number_tf = new JTextField();
		number_tf.setEnabled(false);
		number_tf.setBounds(59, 397, 67, 34);
		panel.add(number_tf);
		number_tf.setColumns(10);
		
		name_tf = new JTextField();
		name_tf.setEnabled(false);
		name_tf.setColumns(10);
		name_tf.setBounds(138, 397, 264, 34);
		panel.add(name_tf);
		
		cate_tf = new JTextField();
		cate_tf.setEnabled(false);
		cate_tf.setColumns(10);
		cate_tf.setBounds(414, 397, 104, 34);
		panel.add(cate_tf);
		
		price_tf = new JTextField();
		price_tf.setEnabled(false);
		price_tf.setColumns(10);
		price_tf.setBounds(530, 397, 98, 34);
		panel.add(price_tf);
		
		JLabel imgLabel = new JLabel("New label");
		imgLabel.setIcon(new ImageIcon(Cart.class.getResource("/img/add.jpg")));
		imgLabel.setBounds(0, -42, 698, 653);
		panel.add(imgLabel);
	}
}
