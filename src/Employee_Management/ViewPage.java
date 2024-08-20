package Employee_Management;

import java.util.Vector;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import java.awt.List;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.table.DefaultTableModel;

public class ViewPage extends JFrame implements ActionListener {

	private JPanel contentPane, topPanel, panel;
	private JLabel close, title, header;
	private JLabel invLabel, invDes;
	private JLabel lblNewLabel;
	
	public DefaultTableModel modelOP1, modelOP2, modelOP3, modelOP4, modelOP5, modelOP6, modelOP7;
	public JTextField choice1Field;
	public JButton btnOp1, btnOp2, btnOp3, btnOp4, btnOp5;
	public JScrollPane scrollPane1, scrollPane2, scrollPane3, scrollPane4, scrollPane5, scrollPane6, scrollPane7;
	public JTable op1Table, op2Table, op3Table, op4Table, op5Table, op6Table, op7Table;
	
	String strChoice;
	int intChoice;
	private JTextField textField;
	private JButton btnOp6;
	private JButton btnOp7;
	private JButton btnOp8;
	
	public ViewPage() {

		//FRAME 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 650);
		setUndecorated(true);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
	
		//-----------------------------//
		//TOP PANEL//
		topPanel = new JPanel();
		topPanel.setBounds(0, 0, 1175, 35);
		contentPane.add(topPanel);
		topPanel.setLayout(null);
		
		title = new JLabel("Employee Information Management System");
		title.setBounds(20, 0, 361, 35);
		topPanel.add(title);
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
		
		close = new JLabel("X");
		close.setBounds(1143, -1, 32, 34);
		topPanel.add(close);
		close.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		close.setHorizontalAlignment(SwingConstants.CENTER);
		close.setHorizontalTextPosition(SwingConstants.CENTER);
		close.setForeground(new Color(255, 255, 255));
		close.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		
		header = new JLabel("");
		header.setBounds(0, 0, 1175, 35);
		topPanel.add(header);
		header.setOpaque(true);
		header.setBackground(new Color(0, 153, 255));
		
		//-------------------------------//

		invLabel = new JLabel(" Info Management System");
		invLabel.setHorizontalAlignment(SwingConstants.CENTER);
		invLabel.setBounds(38, 64, 550, 58);
		contentPane.add(invLabel);
		invLabel.setForeground(new Color(0, 0, 153));
		invLabel.setFont(new Font("Candara", Font.BOLD, 40));
		
		invDes = new JLabel("Display Options:\r\n");
		invDes.setBounds(21, 127, 360, 24);
		contentPane.add(invDes);
		invDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewPage.class.getResource("/img/employees.png")));
		lblNewLabel.setBounds(21, 50, 79, 72);
		contentPane.add(lblNewLabel);
		
		btnOp1 = new JButton("Display all records");
		btnOp1.setForeground(SystemColor.text);
		btnOp1.setBackground(SystemColor.textHighlight);
		btnOp1.setVerticalAlignment(SwingConstants.TOP);
		btnOp1.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp1.addActionListener(this);
		btnOp1.setBounds(136, 122, 297, 24);
		contentPane.add(btnOp1);
		btnOp1.addActionListener(this);
		
		btnOp2 = new JButton("Display all employee records from client\r\n");
		btnOp2.setVerticalAlignment(SwingConstants.TOP);
		btnOp2.setForeground(Color.WHITE);
		btnOp2.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp2.setBackground(SystemColor.textHighlight);
		btnOp2.addActionListener(this);
		btnOp2.setBounds(136, 153, 297, 24);
		contentPane.add(btnOp2);
		
		JLabel choice1Label = new JLabel("Input client number:");
		choice1Label.setBounds(261, 188, 147, 14);
		contentPane.add(choice1Label);
		
		choice1Field = new JTextField();
		choice1Label.setLabelFor(choice1Field);
		choice1Field.setColumns(10);
		choice1Field.setBounds(398, 181, 35, 29);
		contentPane.add(choice1Field);
		
		btnOp3 = new JButton("Total Number of Employees\r\n");
		btnOp3.setVerticalAlignment(SwingConstants.TOP);
		btnOp3.setForeground(Color.WHITE);
		btnOp3.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp3.setBackground(SystemColor.textHighlight);
		btnOp3.addActionListener(this);
		btnOp3.setBounds(466, 122, 297, 24);
		contentPane.add(btnOp3);
		
		btnOp4 = new JButton("Total Number of Employees per Client");
		btnOp4.setVerticalAlignment(SwingConstants.TOP);
		btnOp4.setForeground(Color.WHITE);
		btnOp4.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp4.setBackground(SystemColor.textHighlight);
		btnOp4.addActionListener(this);
		btnOp4.setBounds(466, 153, 297, 24);
		contentPane.add(btnOp4);
		
		btnOp5 = new JButton("New employees who need to update ATMs");
		btnOp5.setVerticalAlignment(SwingConstants.TOP);
		btnOp5.setForeground(Color.WHITE);
		btnOp5.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp5.setBackground(SystemColor.textHighlight);
		btnOp5.addActionListener(this);
		btnOp5.setBounds(808, 122, 297, 24);
		contentPane.add(btnOp5);
		
		btnOp6 = new JButton("List of highest to lowest paying rate");
		btnOp6.setVerticalAlignment(SwingConstants.TOP);
		btnOp6.setForeground(Color.WHITE);
		btnOp6.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp6.setBackground(SystemColor.textHighlight);
		btnOp6.addActionListener(this);
		btnOp6.setBounds(808, 93, 297, 24);
		contentPane.add(btnOp6);
		
		btnOp7 = new JButton("Average payrate per employee (less than 1000)");
		btnOp7.setVerticalAlignment(SwingConstants.TOP);
		btnOp7.setForeground(Color.WHITE);
		btnOp7.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp7.setBackground(SystemColor.textHighlight);
		btnOp7.addActionListener(this);
		btnOp7.setBounds(808, 64, 297, 24);
		contentPane.add(btnOp7);
		
		btnOp8 = new JButton("Highest payed employees");
		btnOp8.setVerticalAlignment(SwingConstants.TOP);
		btnOp8.setForeground(Color.WHITE);
		btnOp8.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 12));
		btnOp8.setBackground(SystemColor.textHighlight);
		btnOp8.addActionListener(this);
		btnOp8.setBounds(808, 153, 297, 24);
		contentPane.add(btnOp8);
		
	}
	
	
	public void actionPerformed(ActionEvent ee){
		if(ee.getSource()==btnOp1) {
			try {
				
				scrollPane1 = new JScrollPane();
				scrollPane1.setBorder(null);
				scrollPane1.setBackground(Color.WHITE);
				scrollPane1.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane1);
				
				op1Table = new JTable();
				op1Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op1Table.setRowHeight(25);
				op1Table.setBorder(null);
				op1Table.setBackground(Color.WHITE);
			
				modelOP1 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"EmpID", "EmpName", "EmpPos", "EmpRegion", "EmpBranch", "DateFrom", "ATM",
							"PayPeriod", "PayOut", "BillRate", "PayRate", "LService",
							"ClientID", "ClientName", "ClientAdd", "ClientTelNum"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};   
				
				op1Table.setModel(modelOP1);
				scrollPane1.setViewportView(op1Table);
						
				modelOP1.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				String sql = "SELECT EmpID, EmpName, EmpPos, EmpRegion, EmpBranch, DateFrom, ATM, PayPeriod, PayOut, BillRate, PayRate, LService, ClientID, ClientName, ClientAdd, ClientTelNum\r\n" + 
						"FROM employee_management.employeeinfo E, employee_management.rateinfo R, employee_management.clientinfo C\r\n" + 
						"WHERE R.ClientCode = C.ClientID AND R.EmpCode = E.EmpID;";
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), rs.getString("EmpRegion"), rs.getString("EmpBranch"), rs.getString("DateFrom"), rs.getString("ATM"),
							rs.getString("PayPeriod"), rs.getString("PayOut"),rs.getString("BillRate"), rs.getString("PayRate"), rs.getString("LService"),
							rs.getString("ClientID"), rs.getString("ClientName"),rs.getString("ClientAdd"), rs.getString("ClientTelNum")};
					modelOP1.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op1Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane1.setViewportView(op1Table);
			
			
		} else if(ee.getSource()==btnOp2) {
			try {
				
				scrollPane2 = new JScrollPane();
				scrollPane2.setBorder(null);
				scrollPane2.setBackground(Color.WHITE);
				scrollPane2.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane2);
				
				op2Table = new JTable();
				op2Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op2Table.setRowHeight(25);
				op2Table.setBorder(null);
				op2Table.setBackground(Color.WHITE);
				
				
				modelOP2 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ClientID", "ClientName", "EmpID", "EmpName", "EmpPos", "EmpRegion", "EmpBranch", "DateFrom",
							"ATM", "BillRate", "PayRate", "LService"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op2Table.setModel(modelOP2);
				scrollPane2.setViewportView(op2Table);
						
				modelOP2.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				strChoice = choice1Field.getText();
				intChoice = Integer.parseInt(strChoice);
				
				String sql = "SELECT ClientID, ClientName, EmpID, EmpName, EmpPos, EmpRegion, EmpBranch, DateFrom, ATM, BillRate, PayRate, LService\r\n" + 
							"FROM employee_management.employeeinfo E, employee_management.rateinfo R, employee_management.clientinfo C\r\n" + 
							"WHERE R.ClientCode = C.ClientID AND R.EmpCode = E.EmpID AND ClientID LIKE '%" + intChoice + "';";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("ClientID"), rs.getString("ClientName"), rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), 
							rs.getString("EmpRegion"), rs.getString("EmpBranch"), rs.getString("DateFrom"), rs.getString("ATM"),
							rs.getString("BillRate"), rs.getString("PayRate"), rs.getString("LService")};
					modelOP2.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op2Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane2.setViewportView(op2Table);
			
			choice1Field.setText(null);
			intChoice = 0;
			
		}else if(ee.getSource()==btnOp3) {
			try {
				
				textField = new JTextField();
				textField.setColumns(10);
				textField.setEditable(false);
				textField.setBounds(808, 178, 297, 35);
				contentPane.add(textField);
				
				
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT COUNT(*) AS \"TOTAL NUMBER OF EMPLOYEES\"\r\n" + 
						"FROM employeeinfo;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					textField.setText("TOTAL NUMBER OF EMPLOYEES : " + rs.getString("TOTAL NUMBER OF EMPLOYEES"));
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
		} else if(ee.getSource()==btnOp4) {
			try {
				
				scrollPane3 = new JScrollPane();
				scrollPane3.setBorder(null);
				scrollPane3.setBackground(Color.WHITE);
				scrollPane3.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane3);
				
				op3Table = new JTable();
				op3Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op3Table.setRowHeight(25);
				op3Table.setBorder(null);
				op3Table.setBackground(Color.WHITE);
				
				
				modelOP3 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"ClientID", "ClientName", "Total Number of Employees"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op3Table.setModel(modelOP3);
				scrollPane3.setViewportView(op3Table);
						
				modelOP3.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT ClientID, ClientName, COUNT(*) AS \"TOTAL NUMBER OF EMPLOYEES\"\r\n" + 
						"FROM employee_management.employeeinfo E, employee_management.rateinfo R, employee_management.clientinfo C\r\n" + 
						"WHERE R.ClientCode = C.ClientID AND R.EmpCode = E.EmpID\r\n" + 
						"GROUP BY ClientID, ClientName;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("ClientID"), rs.getString("ClientName"), rs.getString("TOTAL NUMBER OF EMPLOYEES")};
					modelOP3.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op3Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane3.setViewportView(op3Table);
			
			
		} else if(ee.getSource()==btnOp5) {
			try {
				
				scrollPane4 = new JScrollPane();
				scrollPane4.setBorder(null);
				scrollPane4.setBackground(Color.WHITE);
				scrollPane4.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane4);
				
				op4Table = new JTable();
				op4Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op4Table.setRowHeight(25);
				op4Table.setBorder(null);
				op4Table.setBackground(Color.WHITE);
				
				
				modelOP4 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"EmpID", "EmpName", "EmpPos", "DateFrom", "ATM"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op4Table.setModel(modelOP4);
				scrollPane4.setViewportView(op4Table);
						
				modelOP4.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT EmpID, EmpName, EmpPos, DateFrom, ATM\r\n" + 
						"FROM employeeinfo\r\n" + 
						"WHERE ATM = 'NEW' AND YEAR(DateFrom) > 2021;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), rs.getString("DateFrom"),  rs.getString("ATM")};
					modelOP4.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op4Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane4.setViewportView(op4Table);
			
			
		} else if(ee.getSource()==btnOp6) {
			try {
				
				scrollPane5 = new JScrollPane();
				scrollPane5.setBorder(null);
				scrollPane5.setBackground(Color.WHITE);
				scrollPane5.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane5);
				
				op5Table = new JTable();
				op5Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op5Table.setRowHeight(25);
				op5Table.setBorder(null);
				op5Table.setBackground(Color.WHITE);
				
				
				modelOP5 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"EmpID", "EmpName", "EmpPos", "PayRate"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op5Table.setModel(modelOP5);
				scrollPane5.setViewportView(op5Table);
						
				modelOP5.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT EmpID, EmpName, EmpPos, PayRate\r\n" + 
						"FROM employee_management.employeeinfo E, employee_management.rateinfo R\r\n" + 
						"WHERE E.EmpID = R.EmpCode\r\n" + 
						"ORDER BY PayRate DESC;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), rs.getString("PayRate")};
					modelOP5.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op5Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane5.setViewportView(op5Table);
			
			
		}
		else if(ee.getSource()==btnOp7) {
			try {
				
				scrollPane6 = new JScrollPane();
				scrollPane6.setBorder(null);
				scrollPane6.setBackground(Color.WHITE);
				scrollPane6.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane6);
				
				op6Table = new JTable();
				op6Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op6Table.setRowHeight(25);
				op6Table.setBorder(null);
				op6Table.setBackground(Color.WHITE);
				
				
				modelOP6 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"EmpPos", "Average PayRate"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op6Table.setModel(modelOP6);
				scrollPane6.setViewportView(op6Table);
						
				modelOP6.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT EmpPos, AVG(PayRate) AS \"Average PayRate\"\r\n" + 
						"FROM employee_management.employeeinfo E, employee_management.rateinfo R\r\n" + 
						"WHERE R.EmpCode = E.EmpID\r\n" + 
						"GROUP BY EmpPos\r\n" + 
						"HAVING AVG(PayRate) < 1000;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpPos"), rs.getString("Average PayRate")};
					modelOP6.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op6Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane6.setViewportView(op6Table);
			
			
		}
		else if(ee.getSource()==btnOp8) {
			try {
				
				scrollPane7 = new JScrollPane();
				scrollPane7.setBorder(null);
				scrollPane7.setBackground(Color.WHITE);
				scrollPane7.setBounds(10, 220, 1151, 419);
				contentPane.add(scrollPane7);
				
				op7Table = new JTable();
				op7Table.setFont(new Font("Segoe UI", Font.PLAIN, 12));
				op7Table.setRowHeight(25);
				op7Table.setBorder(null);
				op7Table.setBackground(Color.WHITE);
				
				
				modelOP7 = new DefaultTableModel(
						new Object[][] {
						},
						new String[] {
							"EmpID", "EmpName", "EmpPos", "ATM", "PayRate"
						}
				)
				
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};
				
				op7Table.setModel(modelOP7);
				scrollPane7.setViewportView(op7Table);
						
				modelOP7.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				
				
				String sql = "SELECT EmpID, EmpName, EmpPos, ATM, PayRate\r\n" + 
						"FROM employee_management.employeeinfo E, employee_management.rateinfo R, employee_management.clientinfo C\r\n" + 
						"WHERE R.ClientCode = C.ClientID AND R.EmpCode = E.EmpID \r\n" + 
						"	AND PayRate BETWEEN 10000 AND 30000\r\n" + 
						"    AND  ATM IN (\"BDO\", \"NEW\")\r\n" + 
						"ORDER BY PayRate;";
					
				
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), rs.getString("ATM"), rs.getString("PayRate")};
					modelOP7.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			op7Table.getColumnModel().getColumn(0).setPreferredWidth(0);
			scrollPane7.setViewportView(op7Table);
			
			
		}
	}
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPage frame = new ViewPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
