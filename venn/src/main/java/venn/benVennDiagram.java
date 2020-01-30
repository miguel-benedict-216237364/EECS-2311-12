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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
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
import java.util.ArrayList;
import java.beans.PropertyChangeEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

public class benVennDiagram {

	private JFrame frame;
	private static int numberC = 0;
	//private JTextField textArea;
	private JTextArea textArea;
	private JTextField txtLeftTitle;
	private JTextField txtRightTitle;
	private JScrollPane spTemp;

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

		///// INITIALIZE THE APPLICATION
		setNumberC(0);
		frame = new JFrame();
		frame.setBounds(100, 100, 1280, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		///// INITIALIZE PANEL FOR TWO CIRCLES BUT ONLY ADD THE DRAWINGS
		twoCircle twoCircle = new twoCircle();
		frame.getContentPane().add(twoCircle, "name_592021815164900");
		twoCircle.setVisible(false);
		twoCircle.setEnabled(false);
		twoCircle.setLayout(null);
		

		///// INITIALIZE PANEL FOR THREE CIRCLES BUT ONLY ADD THE DRAWINGS

		threeCircle threeCircle = new threeCircle();
		frame.getContentPane().add(threeCircle, "name_592021830095400");
		threeCircle.setLayout(null);
		threeCircle.setVisible(false);
		threeCircle.setEnabled(false);
		threeCircle.setOpaque(false);

		///// INTIALIZE THE MENU

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 89, 21);
		// twoCircle.add(menuBar);
		frame.setJMenuBar(menuBar);

		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(help);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(save);
		file.add(open);
		file.add(exit);

		JMenuItem about = new JMenuItem("About");
		help.add(about);

		///// INITIALIZE THE SELECTION PANEL AND ALL OF ITS COMPONENTS AND ACTION
		///// EVENTS.
		///// THIS IS WHERE IN LAUNCHES THE OTHER METHODS DEPENDING ON THE NUMBER OF
		///// CIRCLES SELECTED

		JPanel pnlCircleSelection = new JPanel();
		frame.getContentPane().add(pnlCircleSelection, "name_592277363698600");
		pnlCircleSelection.setLayout(null);
		pnlCircleSelection.setEnabled(true);
		pnlCircleSelection.setVisible(true);

		JRadioButton rdbtnTwo = new JRadioButton("2");
		rdbtnTwo.setBounds(513, 288, 109, 23);
		pnlCircleSelection.add(rdbtnTwo);

		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnConfirm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (rdbtnTwo.isSelected()) {

					initializeTwo(twoCircle, frame);

					pnlCircleSelection.setEnabled(false);
					pnlCircleSelection.setVisible(false);
					twoCircle.setVisible(true);
					twoCircle.setEnabled(true);
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

		ButtonGroup btnGtest = new ButtonGroup();
		btnGtest.add(rdbtnTwo);
		btnGtest.add(rdbtnThree);
	
		frame.revalidate();
		frame.repaint();
		
		
		///// TESTING PURPOSES
	
		
	}

	public void initializeTwo(twoCircle twoCircle, JFrame frame) {
		
		

		///// INITIALIZE ARRAYLISTS FOR EACH PANEL

		ArrayList<JTextArea> leftList = new ArrayList<JTextArea>();
		ArrayList<JTextArea> middleList = new ArrayList<JTextArea>();
		ArrayList<JTextArea> rightList = new ArrayList<JTextArea>();

		int[] leftDimensions = { 10, 11, 155, 20 };
		int[] rightDimensions = { 10, 11, 155, 20 };
		int[] middleDimensions = { 10, 11, 130, 20 };
		
		int[] leftPaneDimensions ={ 10, 11, 155, 20 };
		int[] rightPaneDimensions = { 10, 11, 155, 20 };
		int[] middlePaneDimensions = { 10, 11, 130, 20 };
		
		
		///// LABELS AND THEIR EVENT ACTIONS
		
		
		
		///// LABELS AND THEIR EVENT ACTION
		///// LEFT LABEL
			JPanel pnlLeftTitle = new JPanel();
			pnlLeftTitle.setBounds(455, 114, 120, 55);
			twoCircle.add(pnlLeftTitle);
			pnlLeftTitle.setOpaque(false);
			pnlLeftTitle.setLayout(null);
			
			txtLeftTitle = new JTextField();
			
			txtLeftTitle.setText("Tap to Edit");
			txtLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
			txtLeftTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
			txtLeftTitle.setColumns(10);
			txtLeftTitle.setBounds(0, 0, 120, 55);
			txtLeftTitle.setOpaque(false);
			txtLeftTitle.setBorder(null);
			pnlLeftTitle.add(txtLeftTitle);
			
			///// Action
			txtLeftTitle.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					//txtLeftTitle.requestFocus();
					txtLeftTitle.setText(null);
				}
			});
		
			///// RIGHT PANEL
			JPanel pnlRightTitle = new JPanel();
			pnlRightTitle.setBounds(722, 112, 120, 55);
			twoCircle.add(pnlRightTitle);
			pnlRightTitle.setLayout(null);
			
			txtRightTitle = new JTextField();
			txtRightTitle.setText("Tap to Edit");
			txtRightTitle.setHorizontalAlignment(SwingConstants.CENTER);
			txtRightTitle.setFont(new Font("Times New Roman", Font.BOLD, 20));
			txtRightTitle.setColumns(10);
			txtRightTitle.setBounds(0, 0, 120, 55);
			txtRightTitle.setOpaque(false);
			txtRightTitle.setBorder(null);
			pnlRightTitle.add(txtRightTitle);
			///// Action
			txtRightTitle.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					//txtRightTitle.requestFocus();
					//String rightTemp = txtRightTitle.getText();
				txtRightTitle.setText(null);

					//txtRightTitle.setText("");
				
				

			}
		});
			
		////// PANELS FOR EACH SECTION AND THEIR EVENT ACTIION
		///// Left Panel
		JPanel pnlLeft = new JPanel();
		pnlLeft.setBounds(345, 178, 175, 340);
		twoCircle.add(pnlLeft);
		pnlLeft.setLayout(null);

		///// Actions
		pnlLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				spTemp = new JScrollPane();
				spTemp.setBounds(leftPaneDimensions[0], leftPaneDimensions[1], leftPaneDimensions[2], leftPaneDimensions[3]);
				leftPaneDimensions[1]= leftPaneDimensions[1]+30;
				//leftPaneDimensions[3] =leftPaneDimensions[3]+30;
				spTemp.setOpaque(true);
				spTemp.setBorder(null);
				
				pnlLeft.add(spTemp);
				
				textArea = new JTextArea();
				textArea.setBounds(leftDimensions[0], leftDimensions[1], leftDimensions[2], leftDimensions[3]);
				leftDimensions[1] = leftDimensions[1] + 30;
				textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
				textArea.setOpaque(false);
				textArea.setBorder(null);
				spTemp.setColumnHeaderView(textArea);
				textArea.setColumns(10);
				frame.revalidate();
				frame.repaint();
				textArea.requestFocus();
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				leftList.add(textArea);

				
				// For Testing
				textArea.setText(" - This is text number: " + Integer.toString(leftList.size() - 1));
				textArea.setText(leftList.get(leftList.size() - 1).getText());

			}

		});

		///// Right Panel
		JPanel pnlRight = new JPanel();
		pnlRight.setBounds(774, 178, 175, 340);
		twoCircle.add(pnlRight);
		pnlRight.setLayout(null);

		///// Actions
		pnlRight.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				
				spTemp = new JScrollPane();
				spTemp.setBounds(rightPaneDimensions[0], rightPaneDimensions[1], rightPaneDimensions[2], rightPaneDimensions[3]);
				rightPaneDimensions[1]= rightPaneDimensions[1]+30;
				//leftPaneDimensions[3] =leftPaneDimensions[3]-30;
				spTemp.setOpaque(false);
				spTemp.setBorder(null);
				
				pnlRight.add(spTemp);
				
				
				
				textArea = new JTextArea();
				textArea.setBounds(rightDimensions[0], rightDimensions[1], rightDimensions[2], rightDimensions[3]);
				rightDimensions[1] = rightDimensions[1] + 30;
				textArea.setFont(new Font("Times New Roman", Font.BOLD, 14));
				textArea.setOpaque(false);
				textArea.setBorder(null);
				textArea.setWrapStyleWord(true);
				spTemp.setColumnHeaderView(textArea);
				textArea.setColumns(10);
				frame.revalidate();
				frame.repaint();
				textArea.requestFocus();
				textArea.setLineWrap(true);
				rightList.add(textArea);
				// For Testing
				textArea.setText(" - This is text number: " + Integer.toString(rightList.size() - 1));
				textArea.setText(rightList.get(rightList.size() - 1).getText());

			}

		});

		///// Middle Panel

		JPanel pnlMiddle = new JPanel();
		pnlMiddle.setBounds(569, 227, 160, 237);
		twoCircle.add(pnlMiddle);
		pnlMiddle.setLayout(null);

		///// Actions

		pnlMiddle.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				
				spTemp = new JScrollPane();
				spTemp.setBounds(middleDimensions[0], middleDimensions[1], middleDimensions[2], middleDimensions[3]);
				middleDimensions[1]= middleDimensions[1]+30;
				//leftPaneDimensions[3] =leftPaneDimensions[3]-30;
				spTemp.setOpaque(false);
				spTemp.setBorder(null);
				
				pnlMiddle.add(spTemp);
				
				
				
				textArea = new JTextArea();
				textArea.setBounds(middleDimensions[0], middleDimensions[1], middleDimensions[2], middleDimensions[3]);
				middleDimensions[1] = middleDimensions[1] + 30;
				textArea.setFont(new Font("Times New Roman", Font.BOLD, 12));
				textArea.setOpaque(false);
				textArea.setBorder(null);
				textArea.setWrapStyleWord(true);
				textArea.setLineWrap(true);
				spTemp.setColumnHeaderView(textArea);
				textArea.setColumns(10);
				frame.revalidate();
				frame.repaint();
				textArea.requestFocus();
				middleList.add(textArea);

				// For Testing
				textArea.setText(" - This is text number: " + Integer.toString(middleList.size() - 1));
				textArea.setText(middleList.get(middleList.size() - 1).getText());

			}

		});

		///// END OF METHOD

	}

	public static int getNumberC() {
		int result = numberC;
		return result;
	}

	public static void setNumberC(int i) {
		numberC = i;
	}
	
}
