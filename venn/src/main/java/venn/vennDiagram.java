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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.JLabel;

public class vennDiagram {

	private JFrame frmVennDiagram;
	private JTextField txtFldLeft;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vennDiagram window = new vennDiagram();
					window.frmVennDiagram.setVisible(true);
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
		frmVennDiagram = new JFrame();
		frmVennDiagram.setTitle("Venn Diagram Application");
		frmVennDiagram.getContentPane().setBackground(Color.GREEN);
		frmVennDiagram.getContentPane().setForeground(new Color(51, 51, 51));
		frmVennDiagram.setBackground(Color.BLACK);
		frmVennDiagram.setForeground(Color.GREEN);
		frmVennDiagram.getContentPane().setLayout(null);
		//
		txtFldLeft = new JTextField();
		txtFldLeft.setBounds(23, 181, 98, 20);
		frmVennDiagram.getContentPane().add(txtFldLeft);
		txtFldLeft.setColumns(10);
		
		txtFldLeft.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String input = txtFldLeft.getText();
						txtFldLeft.setText(input);
					}
				});
		
		JLabel lblNewLabel = new JLabel("lblLeft");
		lblNewLabel.setBounds(44, 38, 55, 16);
		frmVennDiagram.getContentPane().add(lblNewLabel);
		
		JButton btnAddLeft = new JButton("+Add");
		btnAddLeft.setForeground(Color.GREEN);
		btnAddLeft.setBackground(Color.BLACK);
		btnAddLeft.setBounds(23, 209, 98, 26);
		frmVennDiagram.getContentPane().add(btnAddLeft);
		
		JButton btnAddCenter = new JButton("+Add");
		btnAddCenter.setForeground(Color.GREEN);
		btnAddCenter.setBackground(Color.BLACK);
		btnAddCenter.setBounds(170, 209, 98, 26);
		frmVennDiagram.getContentPane().add(btnAddCenter);
		
		JButton btnAddRight = new JButton("+Add");
		btnAddRight.setForeground(Color.GREEN);
		btnAddRight.setBackground(Color.BLACK);
		btnAddRight.setBounds(308, 209, 98, 26);
		frmVennDiagram.getContentPane().add(btnAddRight);
		
		JTextPane txtpnLeft = new JTextPane();
		txtpnLeft.setToolTipText("Left\r\n");
		txtpnLeft.setSelectedTextColor(Color.MAGENTA);
		txtpnLeft.setBackground(Color.BLACK);
		txtpnLeft.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnLeft.setForeground(Color.GREEN);
		txtpnLeft.setText("           Left");
		txtpnLeft.setBounds(12, 12, 124, 237);
		frmVennDiagram.getContentPane().add(txtpnLeft);
		
		JTextPane txtpnCenter = new JTextPane();
		txtpnCenter.setBackground(Color.BLACK);
		txtpnCenter.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnCenter.setForeground(Color.GREEN);
		txtpnCenter.setText("        Center");
		txtpnCenter.setBounds(155, 12, 124, 237);
		frmVennDiagram.getContentPane().add(txtpnCenter);
		
		JTextPane txtpnRight = new JTextPane();
		txtpnRight.setFont(new Font("Dialog", Font.BOLD, 14));
		txtpnRight.setForeground(new Color(0, 255, 0));
		txtpnRight.setBackground(Color.BLACK);
		txtpnRight.setText("          Right");
		txtpnRight.setBounds(298, 12, 124, 237);
		frmVennDiagram.getContentPane().add(txtpnRight);
	}
}
