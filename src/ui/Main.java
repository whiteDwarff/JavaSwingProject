package ui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import java.awt.Color;

public class Main extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 615);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 700, 1);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		
		JMenuBar mb = new JMenuBar(); 
		mb.setBackground(Color.BLACK);
		mb.setBounds(0, 0, 449, 22);
		getContentPane().add(mb);
		
		
		JMenu member = new JMenu("MYPAGE");
		member.setForeground(Color.BLACK);
		member.setBackground(Color.WHITE);
		mb.add(member);
		JMenuItem memberQna = new JMenuItem("Q&A");
		memberQna.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Qna().setVisible(true);
				setVisible(false);
			}
		});
		memberQna.setForeground(Color.BLACK);
		memberQna.setBackground(Color.WHITE);
		member.add(memberQna);

		JMenuItem memberLog = new JMenuItem("Logout");
		memberLog.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SwingDemo().setVisible(true);
				setVisible(false);
			}
		});
		
		memberLog.setForeground(Color.BLACK);
		memberLog.setBackground(Color.WHITE);
		member.add(memberLog);

		
		
		JMenu select = new JMenu("SELECT");
		select.setForeground(Color.WHITE);
		mb.add(select);
		
		JMenuItem shop = new JMenuItem("Shop");
		shop.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Select().setVisible(true);
				setVisible(false);
			}
		});
		shop.setForeground(Color.BLACK);
		shop.setBackground(Color.WHITE);
		select.add(shop);
	
		JMenu order = new JMenu("ORDER");
		order.setForeground(Color.WHITE);
		order.setBackground(Color.BLACK);
		mb.add(order);
		
		JMenuItem orderCart = new JMenuItem("Cart");
		orderCart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Cart().setVisible(true);
				setVisible(false);
			}
		});
		orderCart.setBackground(Color.WHITE);
		orderCart.setForeground(Color.BLACK);
		order.add(orderCart);
		
		JMenuItem selectOrder = new JMenuItem("Order List");
		selectOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OrderList().setVisible(true);
				setVisible(false);
			}
		});
		selectOrder.setForeground(Color.BLACK);
		selectOrder.setBackground(Color.WHITE);
		order.add(selectOrder);

		JMenu about = new JMenu("ABOUT US"); 
		about.setForeground(Color.WHITE);
		about.setBackground(Color.BLACK);
		mb.add(about);
		
		JMenuItem identity = new JMenuItem("Identity");
		identity.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Identity().setVisible(true);
				setVisible(false);
			}
		});
		identity.setForeground(Color.BLACK);
		identity.setBackground(Color.WHITE);
		about.add(identity);


		JLabel img = new JLabel();
		img.setIcon(new ImageIcon(Main.class.getResource("/img/1.jpg")));
		img.setBounds(0, 0, 449, 587);
		getContentPane().add(img);
	}
}
