
/**
 * <p>This is the index of the document</p>
 * @author Patrick Riley
 */

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

@SuppressWarnings("serial")
public class DocumentIndex extends TreeMap<String, IndexEntry> {

	public DocumentIndex() {
		super(new IndexEntryComparator());
	}

	/**
	 * 
	 * @param cap
	 *            Capacity
	 */
	public DocumentIndex(int cap) {
		super();
	}

	/**
	 * 
	 * @param word
	 *            word to find if inserted
	 * @return int index of return
	 */
	private int foundOrInserted(String word) {
		word = word.toUpperCase();
		boolean isInserted = false;
		int i = 0;
		String compWord = "";
		Set<String> keys = this.keySet();
		Iterator<String> iter = keys.iterator();
		while (iter.hasNext() && !isInserted) {
			compWord = super.get(iter.next()).getWord();
			if (compWord.equals(word))
				return i;
			else if (compWord.compareTo(word) < 0){
				i++;
			}
			else {
				this.put(word, new IndexEntry(word));
				isInserted = true;
				return i;
			}
		}
		this.put(word,new IndexEntry(word));
		return i;
	}

	/**
	 * 
	 * @param word
	 *            add this word
	 * @param num
	 *            on this page line
	 */
	public void addWord(String word, int num) {
		foundOrInserted(word);
		
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
