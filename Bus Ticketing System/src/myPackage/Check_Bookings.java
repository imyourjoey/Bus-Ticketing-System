package myPackage;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import javax.swing.table.DefaultTableModel;

public class Check_Bookings extends JFrame {
	
	/*
	 *  INITIALISATION OF COMPONENTS IN THE FRAME
	 */
	private JPanel contentPane;
	private JTable tableTicket_Bookings;
	private JButton btnView_Ticket_Bookings;
	private JScrollPane scrollPane;
	
	
	/*
	 * CREATE THE FRAME
	 */
	public Check_Bookings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 660, 300);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnView_Ticket_Bookings = new JButton("View Ticket Bookings");
		btnView_Ticket_Bookings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnView_Ticket_Bookings.addActionListener(new ActionListener() {
			/*
			 * READS TICKET BOOKINGS FROM A TXT FILE [TicketBookings.txt] INTO A JTABLE
			 */
			public void actionPerformed(ActionEvent e) {
				String filePath = "TicketBookings.txt";
				File file = new File(filePath);
		        
		        
	            FileReader fr;
				try {
					fr = new FileReader(file);
					BufferedReader br = new BufferedReader(fr);
		            
		            DefaultTableModel model = (DefaultTableModel)tableTicket_Bookings.getModel();
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
		btnView_Ticket_Bookings.setBounds(191, 224, 263, 29);
		contentPane.add(btnView_Ticket_Bookings);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(69, 34, 499, 164);
		contentPane.add(scrollPane);
		
		tableTicket_Bookings = new JTable();
		tableTicket_Bookings.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ticket Ref No.", "Name", "Bus", "Date", "Ticket Type"
			}
		));
		tableTicket_Bookings.setFillsViewportHeight(true);
		tableTicket_Bookings.setColumnSelectionAllowed(true);
		tableTicket_Bookings.setCellSelectionEnabled(true);
		scrollPane.setViewportView(tableTicket_Bookings);
	}
}
