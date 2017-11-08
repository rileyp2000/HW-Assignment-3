
/**
 * <p>This is the index of the document</p>
 * @author Patrick Riley
 */

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
	private void foundOrInserted(String word, int line) {
		word = word.toUpperCase();
		//boolean isInserted = false;

		String compWord = "";

		Set<String> keys = this.keySet();
		Iterator<String> iter = keys.iterator();

		while (iter.hasNext() /*&& !isInserted*/) {
			compWord = super.get(iter.next()).getWord();

			if (compWord.equals(word)) {
				this.get(word).add(line);
				return;
			} else {
				if (compWord.compareTo(word) < 0) {
					break;
				} else {
					if(!this.containsKey(word))
						this.put(word, new IndexEntry(word));
					this.get(word).add(line);
					// System.out.println(this);
					// isInserted = true;
					return;
				}
			}
		}
		this.put(word, new IndexEntry(word,line));
		// System.out.println(this);
		return;
	}

	/**
	 * 
	 * @param word
	 *            add this word
	 * @param num
	 *            on this page line
	 */
	public void addWord(String word, int num) {
		foundOrInserted(word, num);
		// System.out.println(this);
		// this.get(word).add(num);
		/*
		 * IndexEntry wordsd = this.get(word); IndexEntry toBeAppended = new
		 * IndexEntry(this.get(word)); toBeAppended.add(num); this.put(word,
		 * toBeAppended);
		 */

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
