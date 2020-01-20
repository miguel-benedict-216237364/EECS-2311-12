package venn;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

public class testDiagram extends JFrame {

	private JPanel contentPane;
	private JTextField leftTitle;
	private JTextField rightTitle;
	private JTextField middleTitle;
	private JTextField leftTextField;
	private JTextField middleTextField;
	private JTextField rightTextField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testDiagram frame = new testDiagram();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public testDiagram() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 925, 746);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(UIManager.getBorder("ComboBox.border"));
		leftPanel.setBackground(Color.WHITE);
		leftPanel.setBounds(102, 154, 233, 346);
		contentPane.add(leftPanel);
		leftPanel.setLayout(null);
		
		leftTitle = new JTextField();
		leftTitle.setBounds(62, 11, 116, 24);
		leftTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		leftTitle.setText("         leftTitle");
		leftPanel.add(leftTitle);
		leftTitle.setColumns(10);
		
		leftTextField = new JTextField();
		leftTextField.setBounds(10, 61, 213, 274);
		leftPanel.add(leftTextField);
		leftTextField.setColumns(10);
		
		JPanel rightPanel = new JPanel();
		rightPanel.setBorder(UIManager.getBorder("ComboBox.border"));
		rightPanel.setBackground(Color.WHITE);
		rightPanel.setBounds(592, 154, 233, 346);
		contentPane.add(rightPanel);
		rightPanel.setLayout(null);
		
		rightTitle = new JTextField();
		rightTitle.setBounds(58, 6, 116, 24);
		rightTitle.setText("        rightTitle");
		rightTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rightTitle.setColumns(10);
		rightPanel.add(rightTitle);
		
		rightTextField = new JTextField();
		rightTextField.setBounds(10, 41, 213, 294);
		rightPanel.add(rightTextField);
		rightTextField.setColumns(10);
		
		JPanel middlePanel = new JPanel();
		middlePanel.setBackground(Color.WHITE);
		middlePanel.setBounds(384, 210, 154, 242);
		contentPane.add(middlePanel);
		middlePanel.setLayout(null);
		
		middleTitle = new JTextField();
		middleTitle.setBounds(19, 5, 116, 24);
		middleTitle.setText("      middleTitle");
		middleTitle.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		middleTitle.setColumns(10);
		middlePanel.add(middleTitle);
		
		middleTextField = new JTextField();
		middleTextField.setBounds(10, 40, 134, 191);
		middlePanel.add(middleTextField);
		middleTextField.setColumns(10);
	}
}
