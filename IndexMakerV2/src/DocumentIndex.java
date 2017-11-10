
/**
 * <p>This is the index of the document</p>
 * @author Patrick Riley
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class DocumentIndex extends TreeMap<String, IndexEntry> {

	/**
	 * creates a DocumentIndex with a comparator
	 */
	public DocumentIndex() {
		super(new IndexEntryComparator());
	}

	/**
	 * This method adds the line number of a specific words to an Index Entry, and
	 * creates one if it doesn't exist already
	 * 
	 * @param word
	 *            word to find if inserted
	 * @param line
	 *            the line number that the word occurs on
	 * 
	 */
	public void addWord(String word, int line) {
		word = word.toUpperCase();
		/* WHY IS MY LIFE SO BAD
		 * word = word.toUpperCase(); String compWord = "";
		 * 
		 * // creates a set of keys and an iterator to allow traversal of the Index
		 * Set<String> keys = this.keySet(); Iterator<String> iter = keys.iterator();
		 * 
		 * // Iterates through the index, looking for the proper place to insert // the
		 * IndexEntry while (iter.hasNext()) { compWord =
		 * super.get(iter.next()).getWord();
		 * 
		 * if (compWord.equals(word)) { this.get(word).add(line); return; } else { if
		 * (compWord.compareTo(word) < 0) {
		 * 
		 * } else { if (!this.containsKey(word)) this.put(word, new IndexEntry(word));
		 * this.get(word).add(line); return; } } } this.put(word, new IndexEntry(word,
		 * line)); return;
		 */

		if (this.containsKey(word)) {
			this.get(word).add(line);
		} else {
			this.put(word, new IndexEntry(word, line));
		}

	}

	/**
	 * 
	 * @param str
	 *            a line of text
	 * @param num
	 *            the line number of the text
	 */
	public void addAllWords(String str, int num) {
		String[] words = str.split("\\W+");
		for (String s : words) {
			if (!s.equals(""))
				addWord(s, num);
		}
	}
}
