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

public class vennDiagram {

	private JFrame frame;
	private JTextField txtThisWork;

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
		
		txtThisWork = new JTextField();
		txtThisWork.setText("This works!");
		txtThisWork.setBounds(27, 44, 130, 26);
		frame.getContentPane().add(txtThisWork);
		txtThisWork.setColumns(10);
		
		JTextPane txtpnThisWorks = new JTextPane();
		txtpnThisWorks.setText("This works!");
		txtpnThisWorks.setBounds(80, 124, 178, 16);
		frame.getContentPane().add(txtpnThisWorks);
	}
}
