package myPackage;

import javax.swing.*; //IMPORT NECESSARY PACKAGES
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;

public class Bus_Schedule extends JFrame {

	private JPanel contentPane;
	private JTable tableBus_Schedule;
	private JScrollPane scrollPane;
	private JButton btnShow_Schedule;

	/*
	 * CREATE THE FRAME
	 */
	public Bus_Schedule() {
		setTitle("Bus Schedule");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1025, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 10, 991, 88);
		contentPane.add(scrollPane);
		
		tableBus_Schedule = new JTable();
		tableBus_Schedule.setFillsViewportHeight(true);
		tableBus_Schedule.setFont(new Font("Tahoma", Font.PLAIN, 18));
		scrollPane.setViewportView(tableBus_Schedule);
		tableBus_Schedule.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Bus", "Plate Number", "From", "To", "Departure Time", "Adult Price", "Children Price"
			}
		));
		tableBus_Schedule.getColumnModel().getColumn(0).setPreferredWidth(15);
		
		btnShow_Schedule = new JButton("Show Schedule");
		btnShow_Schedule.addActionListener(new ActionListener() {
			/*
			 * READS BUS SCHEDULE FROM A TXT FILE [BusSchedule.txt] INTO A JTABLE
			 */
			public void actionPerformed(ActionEvent e) {
				
				
				String filePath = "BusSchedule.txt";
				File file = new File(filePath);
				DefaultTableModel model = (DefaultTableModel)tableBus_Schedule.getModel();
		        
		            FileReader fr;
					try {
						fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
			            
			            
			            Object[] lines = br.lines().toArray();
			            
			            for(int i = 0; i < lines.length; i++){
			                String[] row = lines[i].toString().split(" ");
			                model.addRow(row);
			            }
					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					}
		            
			}
		});
		btnShow_Schedule.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnShow_Schedule.setBounds(404, 108, 202, 21);
		contentPane.add(btnShow_Schedule);
	}
	
	
}
