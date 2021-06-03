package myPackage;

import javax.swing.*; //IMPORT NECESSARY PACKAGES 
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.awt.Color;
import javax.swing.border.LineBorder;

public class Ticket_Booking extends JFrame {
	/*
	 * INITIALISATION OF COMPONENTS IN THE FRAME
	 */
	private JPanel contentPane;
	private JLabel lblTitle;
	private JLabel lblTicket_Type;
	private JRadioButton rdbtnChild;
	private JRadioButton rdbtnAdult;
	private JSeparator separator;
	private JButton btnExit;
	private JTextArea txtSubtotal;
	private JTextArea txtGST;
	private JTextArea txtTotal;
	private JLabel lblSubtotal;
	private JLabel lblGST;
	private JLabel lblTotal;
	private JLabel lblName;
	private JTextArea txtName;
	private JLabel lblBus;
	private JComboBox comboBox_Bus;
	private JLabel lblDate;
	private JComboBox comboBox_Day;
	private JComboBox comboBox_Month;
	private JComboBox comboBox_Year;
	private JTextArea txtTicketRef;
	private JButton btnCalculate_Total;
	private JTextArea txtPay;
	private JButton btnReset;
	private JLabel lblTicketRef;
	private JLabel lblPay;
	private JButton btnCheckout;
	private JSeparator separator_1;

	/*
	 * CREATE THE FRAME
	 */
	public Ticket_Booking() {
		setTitle("Ticket Booking System");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 939, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblTitle = new JLabel("Ticket Booking System");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblTitle.setBounds(222, 10, 480, 67);
		contentPane.add(lblTitle);

		lblTicket_Type = new JLabel("Ticket Type");
		lblTicket_Type.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTicket_Type.setBounds(10, 165, 173, 36);
		contentPane.add(lblTicket_Type);

		rdbtnChild = new JRadioButton("Child");
		rdbtnChild.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnChild.setBounds(165, 165, 103, 21);
		contentPane.add(rdbtnChild);

		rdbtnAdult = new JRadioButton("Adult");
		rdbtnAdult.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnAdult.setBounds(165, 188, 103, 21);
		contentPane.add(rdbtnAdult);

		separator = new JSeparator();
		separator.setBounds(10, 87, 865, 2);
		contentPane.add(separator);

		btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnExit.setBounds(375, 409, 87, 29);
		contentPane.add(btnExit);
		btnExit.setToolTipText("Exit System");
		btnExit.addActionListener(new ActionListener() {
			/*
			 * POP-UP MESSAGE TO ASK THE USER WHETHER THEY WANT TO EXIT PROGRAM
			 */
			public void actionPerformed(ActionEvent e) {

				JFrame frame = new JFrame("Exit");
				if (JOptionPane.showConfirmDialog(frame, "You May Lose Your Progress if You Exit Now",
						"Ticketing System", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
					System.exit(0);
				}
			}
		});

		txtSubtotal = new JTextArea();
		txtSubtotal.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtSubtotal.setBounds(757, 167, 118, 29);
		contentPane.add(txtSubtotal);

		txtGST = new JTextArea();
		txtGST.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtGST.setBounds(757, 233, 118, 29);
		contentPane.add(txtGST);

		txtTotal = new JTextArea();
		txtTotal.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtTotal.setBounds(757, 299, 118, 29);
		contentPane.add(txtTotal);

		lblSubtotal = new JLabel("Subtotal");
		lblSubtotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblSubtotal.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblSubtotal.setBounds(582, 154, 103, 36);
		contentPane.add(lblSubtotal);

		lblGST = new JLabel("GST (6%)");
		lblGST.setVerticalAlignment(SwingConstants.BOTTOM);
		lblGST.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblGST.setBounds(582, 231, 129, 36);
		contentPane.add(lblGST);

		lblTotal = new JLabel("Total");
		lblTotal.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTotal.setBounds(582, 297, 103, 36);
		contentPane.add(lblTotal);

		lblName = new JLabel("Name");
		lblName.setVerticalAlignment(SwingConstants.BOTTOM);
		lblName.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblName.setBounds(10, 99, 77, 36);
		contentPane.add(lblName);

		txtName = new JTextArea();
		txtName.setFont(new Font("Monospaced", Font.PLAIN, 23));
		txtName.setBounds(108, 99, 354, 41);
		contentPane.add(txtName);

		lblBus = new JLabel("Bus");
		lblBus.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblBus.setBounds(360, 165, 51, 36);
		contentPane.add(lblBus);

		comboBox_Bus = new JComboBox();
		comboBox_Bus.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_Bus.setModel(new DefaultComboBoxModel(new String[] { "--", "A", "B", "C", "D" }));
		comboBox_Bus.setBounds(411, 165, 51, 36);
		contentPane.add(comboBox_Bus);

		lblDate = new JLabel("Date");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDate.setBounds(10, 253, 62, 36);
		contentPane.add(lblDate);

		comboBox_Day = new JComboBox();
		comboBox_Day.setModel(new DefaultComboBoxModel(new String[] { "-Day-", "1", "2", "3", "4", "5", "6", "7", "8",
				"9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25",
				"26", "27", "28", "29", "30", "31" }));
		comboBox_Day.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_Day.setBounds(98, 252, 85, 36);
		contentPane.add(comboBox_Day);

		comboBox_Month = new JComboBox();
		comboBox_Month.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_Month.setModel(new DefaultComboBoxModel(new String[] { "---Month---", "January", "February", "March",
				"April", "May", "June ", "July ", "August", "September", "October ", "Novermber", "December" }));
		comboBox_Month.setBounds(193, 253, 152, 36);
		contentPane.add(comboBox_Month);

		comboBox_Year = new JComboBox();
		comboBox_Year.setFont(new Font("Tahoma", Font.PLAIN, 24));
		comboBox_Year.setModel(new DefaultComboBoxModel(new String[] { "-Year-", "2021", "2022" }));
		comboBox_Year.setBounds(355, 253, 107, 36);
		contentPane.add(comboBox_Year);

		txtTicketRef = new JTextArea();
		txtTicketRef.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtTicketRef.setBounds(757, 99, 118, 29);
		contentPane.add(txtTicketRef);

		btnCalculate_Total = new JButton("Calculate Total");
		btnCalculate_Total.addMouseListener(new MouseAdapter() {
			/*
			 * CALCULATE TAX, SUBTOTAL, AND TOTAL
			 */
			public void mouseClicked(MouseEvent e) {
				double subtotal = 0;
				double tax = 0.06;
				double total;

				if (comboBox_Bus.getSelectedItem().equals("A")) {
					if (rdbtnChild.isSelected()) {
						subtotal = 15;
					} else if (rdbtnAdult.isSelected()) {
						subtotal = 34;
					}

					total = subtotal * (tax + 1);

					String Tax = String.format("RM %.2f", subtotal * tax);
					txtGST.setText(Tax);

					String subTotal = String.format("RM%.2f", subtotal);
					txtSubtotal.setText(subTotal);

					String Total = String.format("RM%.2f", total);
					txtTotal.setText(Total);
				} else if (comboBox_Bus.getSelectedItem().equals("B")) {
					if (rdbtnChild.isSelected()) {
						subtotal = 12;
					} else if (rdbtnAdult.isSelected()) {
						subtotal = 30;
					}

					total = subtotal * (tax + 1);

					String Tax = String.format("RM %.2f", subtotal * tax);
					txtGST.setText(Tax);

					String subTotal = String.format("RM%.2f", subtotal);
					txtSubtotal.setText(subTotal);

					String Total = String.format("RM%.2f", total);
					txtTotal.setText(Total);
				} else if (comboBox_Bus.getSelectedItem().equals("C")) {
					if (rdbtnChild.isSelected()) {
						subtotal = 10;
					} else if (rdbtnAdult.isSelected()) {
						subtotal = 33;
					}

					total = subtotal * (tax + 1);

					String Tax = String.format("RM %.2f", subtotal * tax);
					txtGST.setText(Tax);

					String subTotal = String.format("RM%.2f", subtotal);
					txtSubtotal.setText(subTotal);

					String Total = String.format("RM%.2f", total);
					txtTotal.setText(Total);
				} else if (comboBox_Bus.getSelectedItem().equals("D")) {
					if (rdbtnChild.isSelected()) {
						subtotal = 14;
					} else if (rdbtnAdult.isSelected()) {
						subtotal = 30;
					}

					total = subtotal * (tax + 1);

					String Tax = String.format("RM %.2f", subtotal * tax);
					txtGST.setText(Tax);

					String subTotal = String.format("RM%.2f", subtotal);
					txtSubtotal.setText(subTotal);

					String Total = String.format("RM%.2f", total);
					txtTotal.setText(Total);
				}

			}
		});
		btnCalculate_Total.addActionListener(new ActionListener() {
			/*
			 * GENERATES A RANDOM TICKET REFERENCE NUMBER
			 */
			public void actionPerformed(ActionEvent e) {
				int num1;
				String s1 = "";
				num1 = 1423 + (int) (Math.random() * 1234);
				s1 += num1 + 1324;
				txtTicketRef.setText(s1);

			}
		});
		btnCalculate_Total.setToolTipText("");
		btnCalculate_Total.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCalculate_Total.setBounds(10, 409, 203, 29);
		contentPane.add(btnCalculate_Total);

		txtPay = new JTextArea();
		txtPay.setFont(new Font("Monospaced", Font.PLAIN, 24));
		txtPay.setBounds(798, 358, 77, 29);
		contentPane.add(txtPay);

		btnReset = new JButton("Reset");
		btnReset.setToolTipText("Reset System");
		btnReset.addActionListener(new ActionListener() {
			/*
			 * RESETS ALL USER SELECTIONS
			 */
			public void actionPerformed(ActionEvent e) {
				txtSubtotal.setText(null);
				txtGST.setText(null);
				txtTotal.setText(null);
				txtName.setText(null);
				txtTicketRef.setText(null);
				txtPay.setText(null);

				rdbtnChild.setSelected(false);
				rdbtnAdult.setSelected(false);
				comboBox_Day.setSelectedItem("-Day-");
				comboBox_Month.setSelectedItem("---Month---");
				comboBox_Year.setSelectedItem("-Year-");
				comboBox_Bus.setSelectedItem("--");

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnReset.setBounds(268, 409, 97, 29);
		contentPane.add(btnReset);

		lblTicketRef = new JLabel("Ticket Ref No.");
		lblTicketRef.setVerticalAlignment(SwingConstants.BOTTOM);
		lblTicketRef.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblTicketRef.setBounds(582, 88, 165, 36);
		contentPane.add(lblTicketRef);

		lblPay = new JLabel("Pay                   RM");
		lblPay.setVerticalAlignment(SwingConstants.BOTTOM);
		lblPay.setFont(new Font("Dialog", Font.PLAIN, 25));
		lblPay.setBounds(582, 356, 216, 36);
		contentPane.add(lblPay);

		btnCheckout = new JButton("Checkout");

		btnCheckout.addActionListener(new ActionListener() {
			/*
			 * WRITES USER'S SELECTION AND INFO INTO A TXT FILE NAMED [TicketBookings.txt]
			 */
			public void actionPerformed(ActionEvent e) {
				Path path = Paths.get("TicketBookings.txt");
				String info = "lol";
				if (rdbtnChild.isSelected()) {
					info = txtTicketRef.getText() + " " + txtName.getText() + " "
							+ (String) comboBox_Bus.getSelectedItem() + " " + (String) comboBox_Day.getSelectedItem()
							+ "_" + (String) comboBox_Month.getSelectedItem() + "_"
							+ (String) comboBox_Year.getSelectedItem() + " Child";

				} else if (rdbtnAdult.isSelected()) {
					info = txtTicketRef.getText() + " " + txtName.getText() + " "
							+ (String) comboBox_Bus.getSelectedItem() + " " + (String) comboBox_Day.getSelectedItem()
							+ "_" + (String) comboBox_Month.getSelectedItem() + "_"
							+ (String) comboBox_Year.getSelectedItem() + " Adult";
				}

				try {
					FileWriter fstream = new FileWriter("TicketBookings.txt", true);
					BufferedWriter out = new BufferedWriter(fstream);
					out.write(info + "\n");
					out.close();
				} catch (Exception e1) {
					System.err.println("Error while writing to file: " + e1.getMessage());
				}

			}
		});

		btnCheckout.addMouseListener(new MouseAdapter() {
			/*
			 * DISPLAY CHANGE AFTER PAYMENT
			 */
			@SuppressWarnings("deprecation")
			public void mouseClicked(MouseEvent e) {
				double pay = Double.parseDouble(txtPay.getText());
				double Total = Double.parseDouble(txtTotal.getText().substring(2, txtTotal.getText().length()));
				double change = pay - Total;

				String Change = String.format("RM%.2f", change);

				JFrame frame = new JFrame("Thank You!");
				if (JOptionPane.showConfirmDialog(frame, "Your change is " + Change, "Thank You!",
						JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {

				}
				dispose();
			}
		});
		btnCheckout.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnCheckout.setBounds(582, 409, 293, 29);
		contentPane.add(btnCheckout);

		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBackground(Color.BLACK);
		separator_1.setForeground(Color.GRAY);
		separator_1.setBounds(524, 91, 2, 367);
		contentPane.add(separator_1);

	}

}
