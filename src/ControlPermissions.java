package swing_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class ControlPermissions {

	private JFrame frame;
	private JTextField seconds;
	private JTextField minutes;
	private JTextField hours;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swing_1.ControlPermissions window = new swing_1.ControlPermissions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ControlPermissions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 730, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	
		seconds = new JTextField();
		seconds.setBounds(156, 28, 86, 20);
		frame.getContentPane().add(seconds);
		seconds.setColumns(10);
		
		JLabel lblSeconds = new JLabel("Seconds:");
		lblSeconds.setBounds(65, 31, 75, 14);
		frame.getContentPane().add(lblSeconds);
		
		JLabel lblMinutes = new JLabel("Minutes:");
		lblMinutes.setBounds(65, 68, 75, 14);
		frame.getContentPane().add(lblMinutes);
		
		minutes = new JTextField();
		minutes.setBounds(156, 65, 86, 20);
		frame.getContentPane().add(minutes);
		minutes.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours:");
		lblHours.setBounds(65, 102, 76, 20);
		frame.getContentPane().add(lblHours);
		
		hours = new JTextField();
		hours.setBounds(156, 102, 86, 20);
		frame.getContentPane().add(hours);
		hours.setColumns(10);
		
		
		
		JButton btnClear = new JButton("Clear");
		
		btnClear.setBounds(312, 387, 89, 23);
		frame.getContentPane().add(btnClear);

		
		JLabel clientOrServer = new JLabel("Setting:");
		clientOrServer.setBounds(65, 148, 76, 14);
		frame.getContentPane().add(clientOrServer);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Client");
		comboBox.addItem("Server");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		comboBox.setBounds(156, 145, 91, 20);
		frame.getContentPane().add(comboBox);
		
		
		JButton btnSubmit = new JButton("submit");
		
		btnSubmit.setBackground(Color.BLUE);
		btnSubmit.setForeground(Color.MAGENTA);
		btnSubmit.setBounds(65, 387, 89, 23);
		frame.getContentPane().add(btnSubmit);
		
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(seconds.getText().isEmpty()||(minutes.getText().isEmpty())||(hours.getText().isEmpty())||(comboBox.getSelectedItem().equals("Select")))
					JOptionPane.showMessageDialog(null, "Data Missing");
				else {
					try {
						FileWriter fw = new FileWriter("/cs/usr/elkanatovey/foo.txt", false);
						BufferedWriter br = new BufferedWriter(fw);
						int hour = Integer.parseInt(hours.getText().toString());
						int minute = Integer.parseInt(minutes.getText().toString()) +60*hour ;
						int second = Integer.parseInt(seconds.getText().toString())+ 60*minute;
						br.write(Integer.toString(second));
						br.newLine();
						br.write((String)comboBox.getSelectedItem());
						br.flush();
						br.close();
						fw.flush();
						fw.close();
					}
					catch (IOException e){
						e.printStackTrace();;
					}
					JOptionPane.showMessageDialog(null, "Data Submitted");
				}

			}
		});
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				minutes.setText(null);
				hours.setText(null);
				seconds.setText(null);
				comboBox.setSelectedItem("Select");
				
				
			}
		});
		
	}
}
