package myPackage;

import javax.swing.*; //IMPORT NECESSARY PACKAGES

import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.*;

public class MainScreen extends JFrame {

	/*
	 * INITIALISATION OF COMPONENTS IN THE FRAME
	 */
	private JPanel contentPane;
	private JLabel lblTitle;
	private JButton btnViewBusSchedule;
	private JButton btnBookATicket;
	private JButton btnCheckTicketBookings;
	private JSeparator separator;

	/*
	 * MAIN METHOD (LAUNCHES THE PROGRAM)
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen frame = new MainScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * CREATE THE FRAME
	 */
	public MainScreen() {
		setTitle("Bus Ticketing System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblTitle = new JLabel("Bus Ticketing Sytem");
		lblTitle.setVerticalAlignment(SwingConstants.TOP);
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setBounds(57, 20, 322, 32);
		contentPane.add(lblTitle);
		
		btnViewBusSchedule = new JButton("View Bus Schedule");
		btnViewBusSchedule.addActionListener(new ActionListener() {
			/*
			 * OPENS VIEW BUS SCHEDULE WINDOW WHEN BUTTON IS CLICKED
			 */
			public void actionPerformed(ActionEvent e) {
				Bus_Schedule frame = new Bus_Schedule();
				frame.setVisible(true);
				
			}
		});
		btnViewBusSchedule.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnViewBusSchedule.setBounds(48, 90, 340, 40);
		contentPane.add(btnViewBusSchedule);
		
		btnBookATicket = new JButton("Book a Ticket");
		btnBookATicket.addActionListener(new ActionListener() {
			/*
			 * OPENS TICKET BOOKING WINDOW WHEN BUTTON IS CLICKED
			 */
			public void actionPerformed(ActionEvent e) {
				Ticket_Booking frame = new Ticket_Booking();
				frame.setVisible(true);
			}
		});
		btnBookATicket.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnBookATicket.setBounds(48, 140, 340, 40);
		contentPane.add(btnBookATicket);
		
		btnCheckTicketBookings = new JButton("Check Ticket Bookings (Admin only)");
		btnCheckTicketBookings.addActionListener(new ActionListener() {
			/*
			 * OPENS ADMIN LOGIN WINDOW WHEN BUTTON IS CLICKED
			 */
			public void actionPerformed(ActionEvent e) {
				Admin_Login frame = new Admin_Login();
				frame.setVisible(true);
			}
		});
		btnCheckTicketBookings.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCheckTicketBookings.setBounds(48, 190, 340, 40);
		contentPane.add(btnCheckTicketBookings);
		
		separator = new JSeparator();
		separator.setForeground(Color.GRAY);
		separator.setBackground(Color.WHITE);
		separator.setBounds(10, 71, 416, 9);
		contentPane.add(separator);
	}


}

