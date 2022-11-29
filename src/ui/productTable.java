package ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.JButton;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class productTable {
	
	public static Connection con;
	private PreparedStatement ptmt;
	ResultSet rs;
	private JTextField selectName_tf;
	private JTextField number_tf;
	private JTextField name_tf;
	private JTextField cate_tf;
	private JTextField price_tf;
	private JTextField stock_tf;
	

	///////////////////////////////////////////////////////////////// table data import 
	public static String[][] getCustomers(){
		
		try {
			con = DbConnection();
			PreparedStatement ptmt = con.prepareStatement("SELECT * FROM PRODUCT ORDER BY CAST(PDNUMBER AS UNSIGNED)");

			ResultSet rs = ptmt.executeQuery();
			
			ArrayList<String[]> list = new ArrayList<String[]>();
			
			while(rs.next()) {
				list.add(new String[] {
						rs.getString("pdNumber"),
						rs.getString("pdName"),
						rs.getString("pdCategory"),
						rs.getString("pdPrice"),
						rs.getString("pdStock"),
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
	/**
	 * Create the frame.
	 */
	public productTable() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setTitle("CommonSenseConstruct Official");
		// 크기 변경 불가
		frame.setResizable(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 698, 709);
		String[] headings = new String[]{"Number", "Name", "Category", "Price", "Stcok"};
		String[][] data = productTable.getCustomers();
		frame.getContentPane().setLayout(null);

		panel.setLayout(null);
		DefaultTableModel model = new DefaultTableModel(data, headings);
		JTable table = new JTable(model);
		table.addMouseListener(new MouseAdapter() {
			//////////////////////////////////////////////////////
			// table의 내용을 텍스트필드로 불러오는 이벤트
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				
				int row1 = table.getSelectedRow();
				int row2 = table.getSelectedRow();
				int row3 = table.getSelectedRow();
				int row4 = table.getSelectedRow();
				int row5 = table.getSelectedRow();


                String cell1 = table.getModel().getValueAt(row1, 0).toString();
                String cell2 = table.getModel().getValueAt(row2, 1).toString();
                String cell3 = table.getModel().getValueAt(row3, 2).toString();
                String cell4 = table.getModel().getValueAt(row4, 3).toString();
                String cell5 = table.getModel().getValueAt(row5, 4).toString();

				String mouseClick = table.getModel().getValueAt(row, 0).toString();
				
				try {
					String sql = "SELECT * FROM PRODUCT WHERE PDNUMBER = '" + mouseClick + "'";
					ptmt = con.prepareStatement(sql);
					rs = ptmt.executeQuery(sql);
					
					if(rs.next()){
						number_tf.setText(cell1);
						name_tf.setText(cell2);
						cate_tf.setText(cell3);
						price_tf.setText(cell4);
						stock_tf.setText(cell5);
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("import error : " + e2.getMessage());
				}
			}
		});
		//////////////////////////////////////////////////////
		table.setSize(500,300);
		// ================================================================
		// table의 가로, 세로값을 설정
		table.setPreferredScrollableViewportSize(new Dimension(500, 200));
		table.setRowHeight(30);
		JScrollPane scrollPane = new JScrollPane(table);

		scrollPane.setBounds(-3, 20, 704, 379);
		scrollPane.setPreferredSize(new Dimension(200,200));
		panel.add(scrollPane);
		frame.getContentPane().add(panel);
		///////////////////////////////////////////////////////////////// table

		
		selectName_tf = new JTextField();
		selectName_tf.setHorizontalAlignment(SwingConstants.CENTER);
		selectName_tf.setBackground(new Color(241, 241, 240));
		selectName_tf.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				// table의 내용을 조회하는 이벤트
				String value = selectName_tf.getText();
				TableRowSorter<TableModel> trs = new TableRowSorter<>(table.getModel());
				table.setRowSorter(trs);
				trs.setRowFilter(RowFilter.regexFilter(value));
			}
		});
		TableColumnModel columnModels = table.getColumnModel();
		// column의 크기를 조절
		columnModels.getColumn(1).setPreferredWidth(250);


		selectName_tf.setBounds(105, 417, 363, 33);
		panel.add(selectName_tf);
		selectName_tf.setColumns(10);
		
		JButton deleteBtn = new JButton("DELETE");
		deleteBtn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// table data를 삭제하는 event
				int row = table.getSelectedRow();
				String cell = table.getModel().getValueAt(row, 0).toString();
				String sql = "DELETE FROM PRODUCT WHERE PDNUMBER = " + "'" + cell + "'";
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
		deleteBtn.setBounds(502, 560, 149, 52);
		panel.add(deleteBtn);
		
		JButton modifyBtn = new JButton("MODIFY");
		modifyBtn.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 		  // table의 정보를 수정
	                      String query = "UPDATE PRODUCT SET pdNumber ='"+number_tf.getText()+
										            	  "',pdName ='"+name_tf.getText()+
										            	  "',pdCategory ='"+cate_tf.getText()+
										            	  "',pdPrice ='"+price_tf.getText()+
										            	  "',pdStock ='"+stock_tf.getText()+
	            										  "' where pdNumber ='"+number_tf.getText()+"'";
	                      System.out.println(query);
	               try {
	                  ptmt = con.prepareStatement(query);
	                  ptmt.executeUpdate(query);
	                  JOptionPane.showMessageDialog(null, "Modify Succesfully");
	               } catch (SQLException e1) {    
	                  // TODO Auto-generated catch block
	            	   System.out.println(e1.getMessage());
	                  JOptionPane.showMessageDialog(null, "Modify Error");
	               }
	         }
	     });
		modifyBtn.setBackground(new Color(241, 241, 240));
		modifyBtn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
	
		modifyBtn.setBounds(502, 496, 149, 52);
		panel.add(modifyBtn);
		
		JLabel searchLb = new JLabel("SEARCH");
		searchLb.setBounds(25, 425, 61, 16);
		panel.add(searchLb);
		
		number_tf = new JTextField();
		number_tf.setForeground(Color.RED);
		number_tf.setText("--- Same number cannot be entered ---");
		number_tf.setBackground(new Color(241, 241, 240));
		number_tf.setHorizontalAlignment(SwingConstants.CENTER);
		number_tf.setBounds(104, 476, 363, 33);
		panel.add(number_tf);
		number_tf.setColumns(10);
		
		name_tf = new JTextField();
		name_tf.setHorizontalAlignment(SwingConstants.CENTER);
		name_tf.setBackground(new Color(241, 241, 240));
		name_tf.setColumns(10);
		name_tf.setBounds(104, 520, 363, 33);
		panel.add(name_tf);
		
		cate_tf = new JTextField();
		cate_tf.setHorizontalAlignment(SwingConstants.CENTER);
		cate_tf.setBackground(new Color(241, 241, 240));
		cate_tf.setColumns(10);
		cate_tf.setBounds(105, 565, 362, 33);
		panel.add(cate_tf);
		
		price_tf = new JTextField();
		price_tf.setHorizontalAlignment(SwingConstants.CENTER);
		price_tf.setBackground(new Color(241, 241, 240));
		price_tf.setColumns(10);
		price_tf.setBounds(104, 610, 363, 33);
		panel.add(price_tf);
		
		stock_tf = new JTextField();
		stock_tf.setHorizontalAlignment(SwingConstants.CENTER);
		stock_tf.setBackground(new Color(241, 241, 240));
		stock_tf.setColumns(10);
		stock_tf.setBounds(104, 655, 363, 33);
		panel.add(stock_tf);
		
		JLabel numberLb = new JLabel("NUMBER");
		numberLb.setBounds(24, 484, 61, 16);
		panel.add(numberLb);
		
		JLabel nameLb = new JLabel("NAME");
		nameLb.setBounds(24, 529, 61, 16);
		panel.add(nameLb);
		
		JLabel cateLb = new JLabel("CATEGORY");
		cateLb.setBounds(24, 573, 105, 16);
		panel.add(cateLb);
		
		JLabel priceLb = new JLabel("PRICE");
		priceLb.setBounds(24, 618, 61, 16);
		panel.add(priceLb);
		
		JLabel stockLb = new JLabel("STOCK");
		stockLb.setBounds(24, 663, 61, 16);
		panel.add(stockLb);
		
		JButton addBtn = new JButton("ADD");
		addBtn.setBackground(new Color(241, 241, 240));
		addBtn.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// table에 정보를 추가
				String number = number_tf.getText();
				String name = name_tf.getText();
				String cagegory = cate_tf.getText();
				String price = price_tf.getText();
				String stock = stock_tf.getText();

				try {
					ptmt = con.prepareStatement("INSERT INTO PRODUCT(pdNumber, pdName, pdCategory, pdPrice, pdStock) VALUES(?, ?, ?, ?, ?)");
					ptmt.setString(1, number);
					ptmt.setString(2, name);
					ptmt.setString(3, cagegory);
					ptmt.setString(4, price);
					ptmt.setString(5, stock) ;
					
					int k = ptmt.executeUpdate();
					
					if(k == 1) {
						// 오류가 없을 때 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Sucessfully add!!");
						number_tf.setText("");
						name_tf.setText("");
						cate_tf.setText("");
						price_tf.setText("");
						stock_tf.setText("");
					} else {
						// 오류발생 시 팝업 메세지 실행 
						JOptionPane.showMessageDialog(null,"Error to add!!");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"Same number cannot be entered");

					System.out.println("event error : " + e1.getMessage());
				}
			}
		});
		addBtn.setBounds(502, 432, 149, 52);
		panel.add(addBtn);
		
		JButton homeBtn_1 = new JButton("HOME");
		homeBtn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new PrivatePage().setVisible(true);
				frame.setVisible(false);
			}
		});
		homeBtn_1.setFont(new Font("Lucida Grande", Font.BOLD, 15));
		homeBtn_1.setBounds(502, 627, 149, 52);
		panel.add(homeBtn_1);
		

		frame.setVisible(true);
		frame.setSize(698, 737);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}
}
