package vennDiagram;

import static org.junit.Assert.*;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.Test;

public class Tester1 {
	private VennDiagram venn;
	@Test
	public void test() {
		venn = new VennDiagram();
		venn.initialize();
		venn.initializeTwo();
		venn.initializeMenu();
	}
	
	/*@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
	@Test
	public void test2() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.refresh();
	}

	@Test
	public void test3() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.resortTextAreaList(new ArrayList<JPanel>());
	}
	
	
	@Test
	public void test4() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
*/
}
