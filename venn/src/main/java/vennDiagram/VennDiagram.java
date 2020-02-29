package vennDiagram;

//this is a comment
import javax.swing.*;
import java.awt.*;

import javax.swing.GroupLayout.Alignment;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.awt.event.WindowEvent;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.JTextComponent;
import javax.swing.text.View;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import java.awt.event.WindowAdapter;

public class VennDiagram {
	static JFrame mainFrame = new JFrame();
	static JLayeredPane pnlMain = new JLayeredPane();
	private static JTextField tfLeftTitle;
	private static JTextArea textArea;
	private static JPanel panel;
	private static String unchanged = "Insert Title";
	static Color c = new Color(0, 00, 00, 75);

	// Create necesarry variables and Arraylist
	static ArrayList<JPanel> leftList = new ArrayList<JPanel>();
	static ArrayList<JPanel> rightList = new ArrayList<JPanel>();
	static ArrayList<JPanel> middleList = new ArrayList<JPanel>();

	static ArrayList<JTextArea> allTextArea = new ArrayList<JTextArea>();

	static int[] leftDimensions = { 10, 11, 155, 20 };

	static int[] leftPanelDimensions = { 10, 11, 161, 23 };

	static int leftTextAreaHeight = 14;
	private static JTextField tfRightTitle;

	public static void main(String[] args) {
		// JFrame mainFrame = new JFrame();
		initializeMenu();
		initialize();
		initializeTwo();
		
	}

	// Initializes the main JFrame and the main Panel
	public static void initialize() {

	
		mainFrame.setAlwaysOnTop(true);
		mainFrame.setSize(1280, 720);
		mainFrame.setVisible(true);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.requestFocusInWindow();

		mainFrame.getContentPane().add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(null);
		pnlMain.setOpaque(false);
		pnlMain.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				pnlMain.requestFocusInWindow();
			}
		});

	}

	// Initializes the Menu
	public static void initializeMenu() {
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 89, 21);
		// twoCircle.add(menuBar);
		mainFrame.setJMenuBar(menuBar);

		JMenu file = new JMenu("File");
		JMenu help = new JMenu("Help");
		menuBar.add(file);
		menuBar.add(help);
		JMenuItem save = new JMenuItem("Save");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem exit = new JMenuItem("Exit");

		// Exit Event Handler
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				System.exit(0);
			}
		});
		file.add(save);
		file.add(open);
		file.add(exit);

		JMenuItem about = new JMenuItem("About");
		help.add(about);
	}

	// Initializes Venn Diagram with Two Circles
	public static void initializeTwo() {

Font font = new Font("Times New Roman", Font.PLAIN, 20);
		
		// Add the main title
	JTextField tfMainTitle = new JTextField();
		tfMainTitle.setBounds(486, 41, 275, 30);
		pnlMain.add(tfMainTitle);
		tfMainTitle.setOpaque(false);
		tfMainTitle.setColumns(10);
		tfMainTitle.setText("Insert Title");
		tfMainTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tfMainTitle.setFont(font);
		tfMainTitle.setForeground(c);
		tfMainTitle.setBorder(null);
		tfMainTitle.addFocusListener(new FocusEventDemo());
		pnlMain.setLayer(tfMainTitle,0);
		tfMainTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				tfMainTitle.setForeground(null);
				tfMainTitle.selectAll();
				refresh();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfMainTitle.getText().equals(unchanged) || tfMainTitle.getText().equals("")) {
					tfMainTitle.setForeground(c);
					tfMainTitle.setText("Insert Title");
				}
			}
		});
		
		// Left Title
		tfLeftTitle = new JTextField();
		tfLeftTitle.setOpaque(false);
		Font tmp = new Font("Times New Roman", Font.PLAIN, 20);
		tfLeftTitle.setFont(tmp);
		tfLeftTitle.setForeground(c);
		tfLeftTitle.setText("Insert Title");
		tfLeftTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tfLeftTitle.setBorder(null);
		tfLeftTitle.setBounds(360, 150, 175, 30);
		pnlMain.add(tfLeftTitle);
		tfLeftTitle.setColumns(10);
		pnlMain.setLayer(tfLeftTitle, 0);

		tfLeftTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				tfLeftTitle.setForeground(null);
				tfLeftTitle.selectAll();
				refresh();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfLeftTitle.getText().equals(unchanged) || tfLeftTitle.getText().equals("")) {
					tfLeftTitle.setForeground(c);
					tfLeftTitle.setText("Insert Title");
				}
			}
		});

		// Right Title
		tfRightTitle = new JTextField();
		tfRightTitle.setText("Insert Title");
		tfRightTitle.setOpaque(false);
		tfRightTitle.setBorder(null);
		tfRightTitle.setHorizontalAlignment(SwingConstants.CENTER);
		tfRightTitle.setForeground(new Color(0, 0, 0, 75));
		tfRightTitle.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		tfRightTitle.setColumns(10);
		tfRightTitle.setBounds(715, 150, 175, 30);
		pnlMain.add(tfRightTitle);
		pnlMain.setLayer(tfRightTitle, 0);

		tfRightTitle.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {

				tfRightTitle.setForeground(null);
				refresh();
				tfRightTitle.selectAll();
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (tfRightTitle.getText().equals(unchanged) || tfRightTitle.getText().equals("")) {
					tfRightTitle.setForeground(c);
					tfRightTitle.setText("Insert Title");
				}
			}
		});

		// the first Panel for TextArea
		panel = new JPanel();
		panel.setBounds(0, 0, 161, 26);
		panel.setEnabled(false);
		panel.setOpaque(false);
		pnlMain.add(panel);
		panel.setVisible(false);
		panel.setLayout(null);
		middleList.add(panel);
		leftList.add(panel);
		rightList.add(panel);

		// Create Left Panel
		JPanel pnlLeft = new JPanel();
		pnlLeft.setOpaque(false);
		pnlLeft.setBounds(310, 180, 175, 300);
		pnlMain.add(pnlLeft);
		pnlLeft.setLayout(null);
		pnlMain.setLayer(pnlLeft, 1);
		

		// Create Action Event for Left Panel
		pnlLeft.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				leftTextAreaHeight = leftList.get(lowestTextArea(leftList)).getY()
						+ leftList.get(lowestTextArea(leftList)).getHeight() + 10;
				// Create a panel
				panel = new JPanel();
				panel.setBounds(0, leftTextAreaHeight, 161, 26);
				pnlLeft.add(panel);
				panel.setLayout(null);
				panel.setOpaque(true);
				pnlLeft.add(panel);

				// Create the text Area
				textArea = new JTextArea();
				textArea.setBounds(13, 7, 155, 20);
				textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14));
				textArea.setOpaque(false);
				textArea.setText("- This is text number " + leftList.size());
				// textArea.requestFocusInWindow();
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				allTextArea.add(textArea);
				panel.add(textArea);
				leftList.add(panel);
				refresh();
				textArea.requestFocusInWindow();		
				
			}
		});


	
		// Draw circle
		drawCircle circle = new drawCircle();
		circle.setBounds(247, 80, 750, 500);
		pnlMain.add(circle);
		pnlMain.setLayer(circle, 0);
		circle.setLayout(null);
		pnlMain.setLayer(circle, 0);

	}

	// Refreshes the main Frame and the main Panel

	public static void refresh() {
		mainFrame.revalidate();
		mainFrame.repaint();
		pnlMain.revalidate();
		pnlMain.repaint();
	}

	public static void resortTextAreaList(ArrayList<JPanel> list) {
		for (int i = 1; i < list.size(); i++) {
			list.get(i).setBounds(0, list.get(i - 1).getY() + list.get(i - 1).getHeight() + 10, list.get(i).getWidth(),
					list.get(i).getHeight());
		}
	}

	public static int lowestTextArea(ArrayList<JPanel> list) {
		int result = 0;
		for (int i = 0; i < list.size(); i++) {

			if (result < list.get(i).getY()) {
				
				result = i;
			}
		}
		return result;
		//
	}


	public static void removeEmptyTextArea(ArrayList<JPanel> list) {
		for (int i = 0; i < allTextArea.size(); i++) {
			if (!(allTextArea.get(i).hasFocus()) && allTextArea.get(i).getText().equals("")) {
				for (int j = 1; j < list.size(); j++) {
					if (allTextArea.get(i).getParent().equals(list.get(j))) {
						list.remove(j);
					}
				}
			}
		}
	}

	public static void removeTextArea(ArrayList<JPanel> list, JTextArea textArea) {
		for (int i = 0; i < list.size(); i++) {
			if (textArea.getParent().equals(list.get(i))) {
				list.remove(i);
			}
		}
	}

	// *********************************
	// The method getWrappedLines(JTextComponent component) was created by
	// Rob Comick on October 26, 2008
	// The method is in the site, without the brackets:
	// "https://tips4java.wordpress.com/2008/10/26/text-utilities/"
	// *********************************

	public static int getWrappedLines(JTextArea component) {
		View view = component.getUI().getRootView(component).getView(0);
		int preferredHeight = (int) view.getPreferredSpan(View.Y_AXIS);
		int lineHeight = component.getFontMetrics(component.getFont()).getHeight();
		return preferredHeight / lineHeight;
	}

	public static void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (mainFrame.getFocusOwner() instanceof JTextArea) {
			tfLeftTitle.setText("I Got It!");
		}
	}
}
