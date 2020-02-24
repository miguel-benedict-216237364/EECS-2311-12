package vennDiagram;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.junit.Test;

public class VennTest {
	private VennDiagram venn;

	@Test
//Tests
	
	public void test() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();

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
		VennDiagram.main(null);
	}
	
	@Test
	public void test5() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.lowestTextArea(new ArrayList<JPanel>());
	}
	
	@Test
	public void test6() {
		venn = new VennDiagram();
		VennDiagram.initialize();
		VennDiagram.initializeTwo();
		VennDiagram.initializeMenu();
		VennDiagram.getWrappedLines(new JTextArea("Hello"));
	}
}
