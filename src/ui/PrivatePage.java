package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PrivatePage extends JFrame {
	
	public PrivatePage() {

		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setTitle("CommonSenseConstruct Official");
		// 크기 변경 불가
		frame.setResizable(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 698, 709);
		frame.getContentPane().setLayout(null);
		
		JButton joinBtn = new JButton("JOIN");
		joinBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new productTable().setVisible(true);
				frame.setVisible(false);
			}
		});
		joinBtn.setForeground(new Color(167, 34, 22));
		joinBtn.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		joinBtn.setBounds(285, 548, 124, 47);
		frame.getContentPane().add(joinBtn);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(PrivatePage.class.getResource("/img/backgroundLogo.jpg")));
		lblNewLabel.setBounds(-15, 0, 729, 394);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(PrivatePage.class.getResource("/img/backgroundLogo.jpg")));
		lblNewLabel_1.setBounds(-15, 323, 729, 219);
		frame.getContentPane().add(lblNewLabel_1);
		panel.setLayout(null);
		

		frame.setVisible(true);
		frame.setSize(698, 629);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PrivatePage page = new PrivatePage();
	}
}
