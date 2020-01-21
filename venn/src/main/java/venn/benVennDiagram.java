package venn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class benVennDiagram {

	private JFrame frame;
	private JTextField txtLeftTitle;
	private JTextField txtRightTitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					benVennDiagram window = new benVennDiagram();
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
	public benVennDiagram() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeCircle test = new makeCircle();
		frame.getContentPane().add(test);
		test.setLayout(null);
		
		JTextPane txtLeft = new JTextPane();
		txtLeft.setText("left");
		txtLeft.setBounds(345, 205, 151, 314);
		//txtLeft.setOpaque(false);
		test.add(txtLeft);
		
		JTextPane txtMiddle = new JTextPane();
		txtMiddle.setText("middle");
		txtMiddle.setBounds(569, 241, 151, 233);
		//txtMiddle.setOpaque(false);
		test.add(txtMiddle);
		
		JTextPane txtRight = new JTextPane();
		txtRight.setText("right");
		txtRight.setBounds(791, 205,  151, 314);
		//txtRight.setOpaque(false);
		test.add(txtRight);
		
		
		txtLeftTitle = new JTextField();
		txtLeftTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		txtLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeftTitle.setText("Tap to edit");
		txtLeftTitle.setBounds(454, 31, 118, 53);
		test.add(txtLeftTitle);
		txtLeftTitle.setColumns(10);
		
		txtRightTitle = new JTextField();
		txtRightTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtRightTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtRightTitle.setText("Tap to Edit");
		txtRightTitle.setColumns(10);
		txtRightTitle.setBounds(726, 31, 116, 53);
		test.add(txtRightTitle);
		
		JButton btnLeftReset = new JButton("Clear");
		btnLeftReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtLeft.setText("");
			
			}
		});
		btnLeftReset.setBounds(407, 614, 89, 23);
		test.add(btnLeftReset);
		
		JButton btnMiddleReset = new JButton("Clear");
		btnMiddleReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMiddle.setText("");
			}
		});
		btnMiddleReset.setBounds(603, 614, 89, 23);
		test.add(btnMiddleReset);
		
		JButton btnRightReset = new JButton("Clear");
		btnRightReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtRight.setText("");
			}
		});
		btnRightReset.setBounds(791, 614, 89, 23);
		test.add(btnRightReset);
	}
}
