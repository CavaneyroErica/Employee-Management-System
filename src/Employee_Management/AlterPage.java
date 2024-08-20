package Employee_Management;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;

public class AlterPage extends JFrame {

		//---------------------//
		//DECLARING COMPONENTS
		private JPanel contentPane;
		private JPanel topPanel;
		private JLabel close; 
		private JLabel title; 
		private JLabel header;
		private JPanel list;
		private JLabel invLabel;
		private JLabel invDes;
		private DefaultTableModel userModel;
		private JTable invTable;
		private JScrollPane scrollPane;
		private JButton addData;
		private JButton delData;
		private JButton updateData;
		private JPanel info;
		private JLabel pinfoLabel;
		private JLabel pIDLabel;
		private JTextField EmpIDField;
		private JLabel pnameLabel;
		private JTextField EmpNameField;
		private JLabel pposLabel;
		private JTextField EmpPosField;
		private JLabel pEmpRegionLabel;
		private JTextField EmpRegionField;
		private JLabel pEmpBranchLabel;
		private JTextField EmpBranchField;
		private JLabel pDateFromLabel;
		private JTextField DateFromField;
		private JLabel pATMLabel;
		private JTextField ATMField;

		private JButton addDataDB;
		private JButton updateDataDB;

		
		//---------------------//
		//MAIN FUNCTION TO SET FRAME VISIBLE//
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AlterPage frame = new AlterPage();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		//---------------------//
		
		
		//---------------------//
		//FUNCTION TO SHOW employeeinfo TABLE//
		public void showTable() {
			try {
				
				userModel.setRowCount(0);
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
				
				Statement stm = con.createStatement();
				String sql = "SELECT * FROM employeeinfo";
				ResultSet rs = stm.executeQuery(sql);
				
				while(rs.next()) {
					String[] data = {rs.getString("EmpID"), rs.getString("EmpName"), rs.getString("EmpPos"), rs.getString("EmpRegion"), rs.getString("EmpBranch"), rs.getString("DateFrom"), rs.getString("ATM")};
					userModel.addRow(data);
				}
				
			} catch (ClassNotFoundException | SQLException e1) {
				
				e1.printStackTrace();
			}
			
			invTable.getColumnModel().getColumn(0).setPreferredWidth(0);
		}
		//---------------------//

		
		
		//---------------------//
		//CONTENTS OF employeeinfo APP//
		public AlterPage(){
			
			//this.Login = new Login();
			
			//FRAME 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1065, 650);
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
			topPanel.setBounds(0, 0, 1065, 35);
			contentPane.add(topPanel);
			topPanel.setLayout(null);
			
			close = new JLabel("X");
			close.setBounds(1012, 0, 32, 34);
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
			
			title = new JLabel("Employee Information Management System");
			title.setBounds(20, 0, 361, 35);
			topPanel.add(title);
			title.setForeground(new Color(255, 255, 255));
			title.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 14));
			
			header = new JLabel("");
			header.setBounds(0, 0, 1065, 35);
			topPanel.add(header);
			header.setOpaque(true);
			header.setBackground(new Color(0, 153, 255));
			//-------------------------------//
	
			
			//-------------------------------//
			//TABLE FOR SHOWING employeeinfo DATABASE 
			list = new JPanel();
			list.setBackground(Color.WHITE);
			list.setBounds(0, 35, 810, 615);
			contentPane.add(list);
			list.setLayout(null);
			
			invLabel = new JLabel(" Info Management System");
			invLabel.setHorizontalAlignment(SwingConstants.CENTER);
			invLabel.setBounds(56, 24, 550, 58);
			list.add(invLabel);
			invLabel.setForeground(new Color(0, 0, 153));
			invLabel.setFont(new Font("Candara", Font.BOLD, 40));
			
			invDes = new JLabel("Showing all the employees and their information.\r\n");
			invDes.setBounds(50, 93, 360, 24);
			list.add(invDes);
			invDes.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(null);
			scrollPane.setBackground(Color.WHITE);
			scrollPane.setBounds(30, 115, 770, 400);
			list.add(scrollPane);
			
			invTable = new JTable();
			invTable.setFont(new Font("Segoe UI", Font.PLAIN, 12));
			invTable.setRowHeight(25);
			invTable.setBorder(null);
			userModel = new DefaultTableModel(
					new Object[][] {
					},
					new String[] {
						"EmpID", "EmpName", "EmpPos", "EmpRegion", "EmpBranch", "DateFrom", "ATM"
					}
				)
				
				//FUNCTION TO MAKE TABLE NOT EDITABLE
				{
					@Override
				    public boolean isCellEditable(int row, int column) {
				       //all cells false
				       return false;
					}
				};

			
			invTable.setSelectionBackground(new Color(102, 205, 170));
			invTable.setGridColor(Color.decode("#197D4B"));
			invTable.setBackground(Color.WHITE);
			invTable.setModel(userModel);
			scrollPane.setViewportView(invTable);		
			
			//FUNCTION TO SET PRODUCT ID NO TO INFO PRODUCT FIELD
			addData = new JButton("Add");
			addData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					pinfoLabel.setText("Register");
					addDataDB.show();
					updateDataDB.hide();
					info.show();
					

					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
						
						Statement stm = con.createStatement();
						String sql = "SELECT * FROM employeeinfo";
						ResultSet rs = stm.executeQuery(sql);
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			addData.setIgnoreRepaint(true);
			addData.setForeground(Color.WHITE);
			addData.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			addData.setFocusPainted(false);
			addData.setDefaultCapable(false);
			addData.setBorderPainted(false);
			addData.setBorder(null);
			addData.setBackground(new Color(0, 153, 255));
			addData.setBounds(30, 547, 110, 36);
			list.add(addData);
			
			
			//FUNCTION TO SET INFORMATIONS TO INFO PRODUCT FIELDS
			updateData = new JButton("Update");
			updateData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			updateData.addActionListener(new ActionListener() {
				@SuppressWarnings("deprecation")
				public void actionPerformed(ActionEvent e) {
					addDataDB.hide();
					info.show();
					pinfoLabel.setText("Update");
					updateDataDB.show();
					
					int row = invTable.getSelectedRow();
					String emp_id = invTable.getModel().getValueAt(row, 0).toString();
					String ename = invTable.getModel().getValueAt(row, 1).toString();
					String epos = invTable.getModel().getValueAt(row, 2).toString();
					String eregion = invTable.getModel().getValueAt(row, 3).toString();
					String ebranch = invTable.getModel().getValueAt(row, 4).toString();
					String datef = invTable.getModel().getValueAt(row, 5).toString();
					String atm = invTable.getModel().getValueAt(row, 6).toString();

					EmpIDField.setText(emp_id);
					EmpNameField.setText(ename);
					EmpPosField.setText(epos);
					EmpRegionField.setText(eregion);
					EmpBranchField.setText(ebranch);
					DateFromField.setText(datef);
					ATMField.setText(atm);

					
				}
			});
			updateData.setIgnoreRepaint(true);
			updateData.setForeground(Color.WHITE);
			updateData.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			updateData.setFocusPainted(false);
			updateData.setDefaultCapable(false);
			updateData.setBorderPainted(false);
			updateData.setBorder(null);
			updateData.setBackground(new Color(0, 153, 255));
			updateData.setBounds(150, 547, 110, 36);
			list.add(updateData);
			
			
			//FUNCTION TO DELETE IN DATABASE
			delData = new JButton("Delete");
			delData.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			delData.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int column1 = 0;
					int j=1, x = 0,z;
					int row = invTable.getSelectedRow();
					String delS = invTable.getModel().getValueAt(row, column1).toString();
					int delNo = Integer.parseInt(delS);
					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
						
						String delete1 = " DELETE FROM employeeinfo WHERE EmpID="+ delNo +" ;";
						
						PreparedStatement preparedStmt = con.prepareStatement(delete1);
						
						preparedStmt.execute();
						
						Statement stm = con.createStatement();
						String sql = "SELECT * FROM employeeinfo";
						ResultSet rs = stm.executeQuery(sql);
						
						String upNo = "UPDATE employeeinfo SET EmpID = ? WHERE EmpID = ?;";
						PreparedStatement statement1 = con.prepareStatement(upNo);
						
						while(rs.next()) {
							j++;
						}
						
						for(x=0;x<=j;x++) {
							z = x - 1;
							statement1.setInt(1, z);
							statement1.setInt(2, x);
							if(x > row) {
								statement1.executeUpdate();
							}
							
						}
						
						showTable();
						
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			delData.setIgnoreRepaint(true);
			delData.setForeground(Color.WHITE);
			delData.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			delData.setFocusPainted(false);
			delData.setDefaultCapable(false);
			delData.setBorderPainted(false);
			delData.setBorder(null);
			delData.setBackground(new Color(0, 153, 255));
			delData.setBounds(270, 547, 110, 36);
			list.add(delData);
			
			JLabel lblIMG = new JLabel("");
			lblIMG.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIMG.setIcon(new ImageIcon(AlterPage.class.getResource("/img/employees.png")));
			lblIMG.setBounds(0, 11, 101, 71);
			list.add(lblIMG);
			
			
			
			//FORM WHEN ADDING AND UPDATING employeeinfo DATABASE
			info = new JPanel();
			info.hide();
			info.setBackground(new Color(102, 204, 255));
			info.setBounds(810, 35, 255, 615);
			contentPane.add(info);
			info.setLayout(null);

			pinfoLabel = new JLabel("Information");
			pinfoLabel.setForeground(Color.WHITE);
			pinfoLabel.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 26));
			pinfoLabel.setBounds(30, 10, 175, 39);
			info.add(pinfoLabel);
			
			pIDLabel = new JLabel("EmpID");
			pIDLabel.setForeground(Color.WHITE);
			pIDLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pIDLabel.setBounds(30, 53, 175, 25);
			info.add(pIDLabel);
			
			EmpIDField = new JTextField();
			EmpIDField.setColumns(10);
			EmpIDField.setBorder(null);
			EmpIDField.setBounds(28, 83, 175, 25);
			info.add(EmpIDField);
			
			pnameLabel = new JLabel("EmpName");
			pnameLabel.setForeground(Color.WHITE);
			pnameLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pnameLabel.setBounds(30, 110, 175, 27);
			info.add(pnameLabel);
			
			EmpNameField = new JTextField();
			EmpNameField.setBorder(null);
			EmpNameField.setColumns(10);
			EmpNameField.setBounds(30, 139, 175, 25);
			info.add(EmpNameField);
			
			pposLabel = new JLabel("EmpPos");
			pposLabel.setForeground(Color.WHITE);
			pposLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pposLabel.setBounds(30, 166, 124, 20);
			info.add(pposLabel);
			
			EmpPosField = new JTextField();
			EmpPosField.setColumns(10);
			EmpPosField.setBorder(null);
			EmpPosField.setBounds(30, 191, 175, 25);
			info.add(EmpPosField);
			
			pEmpRegionLabel = new JLabel("EmpRegion\r\n");
			pEmpRegionLabel.setForeground(Color.WHITE);
			pEmpRegionLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pEmpRegionLabel.setBounds(30, 216, 124, 25);
			info.add(pEmpRegionLabel);
			
			EmpRegionField = new JTextField();
			EmpRegionField.setColumns(10);
			EmpRegionField.setBorder(null);
			EmpRegionField.setBounds(30, 243, 175, 25);
			info.add(EmpRegionField);
			
			pEmpBranchLabel = new JLabel("EmpBranch");
			pEmpBranchLabel.setForeground(Color.WHITE);
			pEmpBranchLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pEmpBranchLabel.setBounds(30, 271, 161, 25);
			info.add(pEmpBranchLabel);
			
			EmpBranchField = new JTextField();
			EmpBranchField.setColumns(10);
			EmpBranchField.setBorder(null);
			EmpBranchField.setBounds(30, 298, 175, 25);
			info.add(EmpBranchField);
			
			pDateFromLabel = new JLabel("DateFrom");
			pDateFromLabel.setForeground(Color.WHITE);
			pDateFromLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pDateFromLabel.setBounds(30, 327, 175, 29);
			info.add(pDateFromLabel);
			
			DateFromField = new JTextField();
			DateFromField.setColumns(10);
			DateFromField.setBorder(null);
			DateFromField.setBounds(30, 354, 175, 25);
			info.add(DateFromField);

			pATMLabel = new JLabel("ATM");
			pATMLabel.setForeground(Color.WHITE);
			pATMLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
			pATMLabel.setBounds(32, 382, 173, 30);
			info.add(pATMLabel);
			
			ATMField = new JTextField();
			ATMField.setColumns(10);
			ATMField.setBorder(null);
			ATMField.setBounds(30, 413, 175, 25);
			info.add(ATMField);
			
			
			//ADDING A PRODUCT IN DATABASE
			addDataDB = new JButton("Add Data");
			addDataDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			addDataDB.hide();
			addDataDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
						
						String insert1 = " INSERT INTO employeeinfo VALUES (?, ?, ?, ?, ?, ?, ?)";
						
						String 
						empid = EmpIDField.getText(),
						empname = EmpNameField.getText(),
						emppos = EmpPosField.getText(),
						empreg = EmpRegionField.getText(),
						empbr = EmpBranchField.getText(),
						datefrom = DateFromField.getText(),
						atm = ATMField.getText();
						
						int eID = Integer.parseInt(empid);

						PreparedStatement preparedStmt = con.prepareStatement(insert1);
						preparedStmt.setInt(1, eID);
						preparedStmt.setString(2, empname);
						preparedStmt.setString (3, emppos);
						preparedStmt.setString (4, empreg);
						preparedStmt.setString(5, empbr);
						preparedStmt.setString(6, datefrom);
						preparedStmt.setString(7, atm);

						preparedStmt.execute();
						
						
						showTable();
						info.hide();
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			addDataDB.setIgnoreRepaint(true);
			addDataDB.setForeground(new Color(0, 0, 153));
			addDataDB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			addDataDB.setFocusPainted(false);
			addDataDB.setDefaultCapable(false);
			addDataDB.setBorderPainted(false);
			addDataDB.setBorder(null);
			addDataDB.setBackground(Color.WHITE);
			addDataDB.setBounds(30, 497, 124, 36);
			info.add(addDataDB);
			
			
			//UPDATING A PRODUCT IN DATABASE
			updateDataDB = new JButton("Update Data");
			updateDataDB.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			updateDataDB.hide();
			updateDataDB.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {					
					try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee_management", "root","aj231d89zzi@A");
						
						String 
						empid = EmpIDField.getText(),
						empname = EmpNameField.getText(),
						emppos = EmpPosField.getText(),
						empreg = EmpRegionField.getText(),
						empbr = EmpBranchField.getText(),
						datefrom = DateFromField.getText(),
						atm = ATMField.getText();
						
						//int eID = Integer.parseInt(empid);
						
						String upNo = "UPDATE employeeinfo SET EmpID = '" + empid + "', EmpName = '" + empname + "', EmpPos = '" + emppos + "', EmpRegion = '" + empreg + "', EmpBranch ='" + empbr + "', DateFrom ='" + datefrom +"', ATM = '" + atm + "' WHERE EmpID = '" + empid + "' ;";
						PreparedStatement statement1 = con.prepareStatement(upNo);
						statement1.executeUpdate();
						
						showTable();
						info.hide();
						con.close();
						
					} catch (ClassNotFoundException | SQLException e1) {
						
						e1.printStackTrace();
					}
				}
			});
			updateDataDB.setIgnoreRepaint(true);
			updateDataDB.setForeground(new Color(0, 0, 153));
			updateDataDB.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 13));
			updateDataDB.setFocusPainted(false);
			updateDataDB.setDefaultCapable(false);
			updateDataDB.setBorderPainted(false);
			updateDataDB.setBorder(null);
			updateDataDB.setBackground(Color.WHITE);
			updateDataDB.setBounds(30, 532, 124, 36);
			info.add(updateDataDB);
			
			showTable();
			//-------------------------------//
	}
}
