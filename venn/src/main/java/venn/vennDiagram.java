package venn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.Box;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;

public class vennDiagram {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vennDiagram window = new vennDiagram();
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
	public vennDiagram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JButton btnAddLeft = new JButton("+Add");
		btnAddLeft.setForeground(Color.GREEN);
		btnAddLeft.setBackground(Color.BLACK);
		btnAddLeft.setBounds(23, 209, 98, 26);
		frame.getContentPane().add(btnAddLeft);
		
		JButton btnAddCenter = new JButton("+Add");
		btnAddCenter.setForeground(Color.GREEN);
		btnAddCenter.setBackground(Color.BLACK);
		btnAddCenter.setBounds(170, 209, 98, 26);
		frame.getContentPane().add(btnAddCenter);
		
		JButton btnAddRight = new JButton("+Add");
		btnAddRight.setForeground(Color.GREEN);
		btnAddRight.setBackground(Color.BLACK);
		btnAddRight.setBounds(308, 209, 98, 26);
		frame.getContentPane().add(btnAddRight);
		
		JTextPane txtpnLeft = new JTextPane();
		txtpnLeft.setToolTipText("Left\r\n");
		txtpnLeft.setSelectedTextColor(Color.MAGENTA);
		txtpnLeft.setBackground(Color.BLACK);
		txtpnLeft.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnLeft.setForeground(Color.GREEN);
		txtpnLeft.setText("           Left");
		txtpnLeft.setBounds(12, 12, 124, 237);
		frame.getContentPane().add(txtpnLeft);
		
		JTextPane txtpnCenter = new JTextPane();
		txtpnCenter.setBackground(Color.BLACK);
		txtpnCenter.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnCenter.setForeground(Color.GREEN);
		txtpnCenter.setText("        Center");
		txtpnCenter.setBounds(155, 12, 124, 237);
		frame.getContentPane().add(txtpnCenter);
		
		JTextPane txtpnRight = new JTextPane();
		txtpnRight.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnRight.setForeground(new Color(0, 255, 0));
		txtpnRight.setBackground(Color.BLACK);
		txtpnRight.setText("          Right");
		txtpnRight.setBounds(298, 12, 124, 237);
		frame.getContentPane().add(txtpnRight);
	}
}
