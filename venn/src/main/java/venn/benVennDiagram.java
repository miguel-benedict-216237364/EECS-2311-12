package venn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class benVennDiagram {

	private JFrame frame;
	private JTextField txtLeftTitle;
	private JTextField txtRightTitle;
	private JTextField txtF;
	private static int numberC = 0;

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

		/////////////////////////////////////////////////////////////////////
		///////// THIS SECTION IS FOR TEXTS
		/////////////////////////////////////////////////////////////////////
		//////// START

		setNumberC(0);
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		makeCircle mainFrame = new makeCircle();
		frame.getContentPane().add(mainFrame);
		mainFrame.setLayout(null);

		mainFrame.revalidate();
		mainFrame.repaint();
		frame.revalidate();
		frame.repaint();

		ButtonGroup btnGtest = new ButtonGroup();

		JPanel pnlRadioButtons = new JPanel();
		pnlRadioButtons.setBounds(46, 36, 221, 206);
		mainFrame.add(pnlRadioButtons);
		pnlRadioButtons.setLayout(null);

		JRadioButton btnrCircle2 = new JRadioButton("2");
		btnrCircle2.setBounds(54, 90, 141, 23);
		pnlRadioButtons.add(btnrCircle2);
		btnrCircle2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {

				makeCircle.setNOC(2);
				setNumberC(2);
				mainFrame.revalidate();
				mainFrame.repaint();
				frame.revalidate();
				frame.repaint();

			
					initialize2(mainFrame, frame);
					pnlRadioButtons.setEnabled(false);
					pnlRadioButtons.setVisible(false);

				

			}
		});
		btnGtest.add(btnrCircle2);

		JRadioButton btnrCircle3 = new JRadioButton("3");
		btnrCircle3.setBounds(54, 145, 141, 23);
		pnlRadioButtons.add(btnrCircle3);
		btnrCircle3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) { // makeCircle.setNOC(3); setNumberC(3);

				
				


			}
		});
		btnGtest.add(btnrCircle3);

		JLabel lblNumberOfCircles = new JLabel("Number of Circles");
		lblNumberOfCircles.setBounds(32, 48, 233, 61);
		pnlRadioButtons.add(lblNumberOfCircles);

	}

	public void initialize2(makeCircle mainFrame, JFrame frame) {

		txtLeftTitle = new JTextField();
		txtLeftTitle.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		txtLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeftTitle.setText("Tap to edit");
		txtLeftTitle.setBounds(454, 31, 118, 53);
		mainFrame.add(txtLeftTitle);
		txtLeftTitle.setColumns(10);

		txtRightTitle = new JTextField();
		txtRightTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtRightTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtRightTitle.setText("Tap to Edit");
		txtRightTitle.setColumns(10);
		txtRightTitle.setBounds(726, 31, 116, 53);
		mainFrame.add(txtRightTitle);

		JTextArea txtaLeft = new JTextArea();
		txtaLeft.setBounds(345, 205, 151, 314);
		mainFrame.add(txtaLeft);

		JTextArea txtaRight = new JTextArea();
		txtaRight.setBounds(791, 205, 151, 314);
		mainFrame.add(txtaRight);

		JTextArea txtaMiddle = new JTextArea();
		txtaMiddle.setBounds(569, 241, 151, 233);
		mainFrame.add(txtaMiddle);

		//////// END

		/////////////////////////////////////////////////////////////////////
		///////// THIS SECTION IS FOR BUTTONS
		/////////////////////////////////////////////////////////////////////
		//////// START
		JButton btnLeftReset = new JButton("Clear");
		btnLeftReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtaLeft.setText("");

			}
		});
		btnLeftReset.setBounds(407, 614, 89, 23);
		mainFrame.add(btnLeftReset);

		JButton btnMiddleReset = new JButton("Clear");
		btnMiddleReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtaMiddle.setText("");
			}
		});
		btnMiddleReset.setBounds(603, 614, 89, 23);
		mainFrame.add(btnMiddleReset);

		JButton btnRightReset = new JButton("Clear");
		btnRightReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtaRight.setText("");
			}
		});
		btnRightReset.setBounds(791, 614, 89, 23);
		mainFrame.add(btnRightReset);

		//////// END

	}

	public static int getNumberC() {
		int result = numberC;
		return result;
	}

	public static void setNumberC(int i) {
		numberC = i;
	}
}
