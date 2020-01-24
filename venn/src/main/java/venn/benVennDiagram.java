package venn;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
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
import java.awt.CardLayout;

import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class benVennDiagram {

	private JFrame frame;
	private JTextField txtLeftTitle;
	private JTextField txtRightTitle;
	private JTextField txtF;
	private static int numberC = 0;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

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

		setNumberC(0);
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		twoCircle twoCircle = new twoCircle();
		frame.getContentPane().add(twoCircle, "name_592021815164900");
		twoCircle.setVisible(false);
		twoCircle.setEnabled(false);
		twoCircle.setLayout(null);

		threeCircle threeCircle = new threeCircle();
		frame.getContentPane().add(threeCircle, "name_592021830095400");
		threeCircle.setLayout(null);
		threeCircle.setVisible(false);
		threeCircle.setEnabled(false);
		threeCircle.setOpaque(false);

		JPanel pnlCircleSelection = new JPanel();
		frame.getContentPane().add(pnlCircleSelection, "name_592277363698600");
		pnlCircleSelection.setLayout(null);
		pnlCircleSelection.setEnabled(true);
		pnlCircleSelection.setVisible(true);

		JRadioButton rdbtnTwo = new JRadioButton("2");
		rdbtnTwo.setBounds(513, 288, 109, 23);
		pnlCircleSelection.add(rdbtnTwo);

		ButtonGroup btnGtest = new ButtonGroup();
		btnGtest.add(rdbtnTwo);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnTwo.isSelected()) {

					initializeTwo(twoCircle, frame);

					pnlCircleSelection.setEnabled(false);
					pnlCircleSelection.setVisible(false);
					frame.revalidate();
					frame.repaint();

				}

			}
		});
		btnConfirm.setBounds(513, 352, 158, 76);
		pnlCircleSelection.add(btnConfirm);

		JRadioButton rdbtnThree = new JRadioButton("3");
		rdbtnThree.setBounds(513, 314, 109, 23);
		pnlCircleSelection.add(rdbtnThree);

		JLabel lblNewLabel = new JLabel("Select Number of Intersecting Lines");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblNewLabel.setBounds(473, 242, 272, 36);
		pnlCircleSelection.add(lblNewLabel);

		JLabel lblBorder = new JLabel("");
		lblBorder.setBackground(Color.BLACK);
		lblBorder.setBounds(413, 193, 379, 286);
		pnlCircleSelection.add(lblBorder);

	}

	public void initializeTwo(twoCircle twoCircle, JFrame frame) {

		txtLeftTitle = new JTextField();
		txtLeftTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtLeftTitle.setText("Tap to Edit");
		txtLeftTitle.setBounds(454, 31, 118, 53);
		twoCircle.add(txtLeftTitle);
		txtLeftTitle.setColumns(10);
		txtLeftTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				if (txtLeftTitle.getText().equals("Tap to Edit")) {
					txtLeftTitle.setText("");
				}
			}
		});

		txtRightTitle = new JTextField();
		txtRightTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
		txtRightTitle.setHorizontalAlignment(SwingConstants.CENTER);
		txtRightTitle.setText("Tap to Edit");
		txtRightTitle.setColumns(10);
		txtRightTitle.setBounds(726, 31, 116, 53);
		twoCircle.add(txtRightTitle);
		txtRightTitle.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (txtRightTitle.getText().equals("") || txtRightTitle.getText().equals("Tap to Edit")) {
					txtRightTitle.setText("");
				}

			}
		});

		JTextArea txtaLeft = new JTextArea();
		txtaLeft.setBounds(345, 205, 151, 314);
		twoCircle.add(txtaLeft);

		JTextArea txtaRight = new JTextArea();
		txtaRight.setBounds(791, 205, 151, 314);
		twoCircle.add(txtaRight);

		JTextArea txtaMiddle = new JTextArea();
		txtaMiddle.setBounds(569, 241, 151, 233);
		twoCircle.add(txtaMiddle);

		JButton btnLeftReset = new JButton("Clear");
		btnLeftReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtaLeft.setText("");

			}
		});
		btnLeftReset.setBounds(407, 614, 89, 23);
		twoCircle.add(btnLeftReset);

		JButton btnMiddleReset = new JButton("Clear");
		btnMiddleReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtaMiddle.setText("");
			}
		});
		btnMiddleReset.setBounds(603, 614, 89, 23);
		twoCircle.add(btnMiddleReset);

		JButton btnRightReset = new JButton("Clear");
		btnRightReset.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtaRight.setText("");
			}
		});
		btnRightReset.setBounds(791, 614, 89, 23);
		twoCircle.add(btnRightReset);

	}

	public static int getNumberC() {
		int result = numberC;
		return result;
	}

	public static void setNumberC(int i) {
		numberC = i;
	}
}
