package Employee_Management;


import java.awt.event.ActionListener;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Admin extends JFrame implements ActionListener {

	private JPanel contentPane;
	public JButton btnDisplay, btnAlter1, btnLogout;
	private JLabel lbl2;
	
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 320);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JLabel lbl1 = new JLabel("  ADMIN");
		lbl1.setIcon(new ImageIcon(Admin.class.getResource("/img/userr.png")));
		lbl1.setFont(new Font("Cambria", Font.BOLD, 22));
		lbl1.setBounds(10, 11, 191, 66);
		contentPane.add(lbl1);
		
		btnDisplay = new JButton("View/Display");
		btnDisplay.setBackground(UIManager.getColor("Button.background"));
		btnDisplay.setFont(new Font("Cambria", Font.BOLD, 14));
		btnDisplay.setBounds(30, 158, 155, 41);
		btnDisplay.addActionListener(this);
		contentPane.add(btnDisplay);
		
		btnAlter1 = new JButton("Alter Employee Records");
		btnAlter1.setBackground(UIManager.getColor("Button.background"));
		btnAlter1.setFont(new Font("Cambria", Font.BOLD, 14));
		btnAlter1.setBounds(234, 158, 214, 41);
		btnAlter1.addActionListener(this);
		contentPane.add(btnAlter1);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(0, 78, 564, 2);
		contentPane.add(separator);
		
		btnLogout = new JButton("Log out");
		btnLogout.setForeground(SystemColor.desktop);
		btnLogout.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogout.setFont(new Font("Cambria", Font.PLAIN, 15));
		btnLogout.setIcon(new ImageIcon(Admin.class.getResource("/img/log-out.png")));
		btnLogout.setBackground(SystemColor.activeCaption);
		btnLogout.setBounds(343, 26, 131, 41);
		btnLogout.addActionListener(this);
		contentPane.add(btnLogout);
		
		lbl2 = new JLabel("Select functions in order to modify employee records:");
		lbl2.setFont(new Font("Cambria", Font.PLAIN, 11));
		lbl2.setBounds(30, 88, 285, 14);
		contentPane.add(lbl2);

	}
	
	
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==btnDisplay) {
			ViewPage vipage = new ViewPage();
			vipage.setVisible(true);
			this.setVisible(false);
		}
		if(ee.getSource()==btnAlter1) {
			AlterPage adpage = new AlterPage();
			adpage.setVisible(true);
			this.setVisible(false);
		}
		if(ee.getSource()==btnLogout) {
			System.exit(0);
		}
	}
	
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
