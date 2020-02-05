package edsVenn;

import java.util.ArrayList;

public class sortTest {

	public static void main(String[] args) {
		ArrayList<String> list = new ArrayList<String>();
		list.add("z");
		list.add("Helloc");
		list.add("Hello");
		list.add("Helloa");
		list.add("Hellob");
		list.add("Hello");
		list.add("aba");
		list.add("aaba");

		printList(list);
		System.out.println("Sorting....");
		sort(list);
		printList(list);

	}

	public static void sort(ArrayList<String> a) {
		// largest refers to the which string is larger in terms of its characters

		for (int lastUnsortedIndex = a.size() - 1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
			int largest = 1; // index of the "largest" string so far

			for (int i = 0; i <= lastUnsortedIndex; i++) {
				String iString = a.get(i);// .replace(" ", ""); // string currently at position i with all spaces
											// removed
				String largestString = a.get(largest);// .replace(" ", ""); // index of the current "largest" string
														// with all spaces removed
				int compare = iString.compareToIgnoreCase(largestString);
				if (compare > 0) {
					largest = i;
				}
			}
			swap(a, largest, lastUnsortedIndex);
		}

	}

	public static void swap(ArrayList<String> a, int largest, int unsortedIndex) {
		String largerString = a.get(largest);
		String smallerString = a.get(unsortedIndex);
		a.set(largest, smallerString);
		a.set(unsortedIndex, largerString);

	}

	public static void printList(ArrayList<String> a) {
		for (int i = 0; i < a.size(); i++) {
			System.out.println(a.get(i));
		}
	}

}
