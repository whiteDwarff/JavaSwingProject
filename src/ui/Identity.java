package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Identity extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Identity frame = new Identity();
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
	public Identity() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 615);
		setLocationRelativeTo(null);
		setTitle("CommonSenseConstruct Official");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel TitleLabel = new JLabel("'INTERNAL CONFLICT'\n");
		TitleLabel.setForeground(Color.WHITE);
		TitleLabel.setFont(new Font("Arial Black", Font.BOLD, 25));
		TitleLabel.setBounds(17, 441, 321, 31);
		contentPane.add(TitleLabel);
		
		JLabel contentLabel1 = new JLabel("INCONSISTENT INTEGRATION, ABOUT HUMAN EMOTION\n");
		contentLabel1.setForeground(Color.WHITE);
		contentLabel1.setFont(new Font("Arial Black", Font.BOLD, 10));
		contentLabel1.setBounds(17, 467, 412, 45);
		contentPane.add(contentLabel1);
		
		JLabel contentLabel2 = new JLabel("AND INDIVIDUALITY.");
		contentLabel2.setForeground(Color.WHITE);
		contentLabel2.setFont(new Font("Arial Black", Font.BOLD, 10));
		contentLabel2.setBounds(17, 484, 412, 45);
		contentPane.add(contentLabel2);
		
		JButton leftBtn = new JButton("<");
		leftBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				new Main().setVisible(true);
			}
		});
		leftBtn.setBounds(190, 524, 45, 29);
		contentPane.add(leftBtn);
		
		
		JLabel imgLabel = new JLabel("");
		imgLabel.setBounds(0, 10, 449, 577);
		imgLabel.setIcon(new ImageIcon(Identity.class.getResource("/img/back.jpg")));
		contentPane.add(imgLabel);
	}

}
