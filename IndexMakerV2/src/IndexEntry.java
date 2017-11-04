import java.util.ArrayList;
import java.util.TreeSet;

/**
 * <p></p>
 * @author Patrick Riley
 */

public class IndexEntry implements Comparable<IndexEntry>{
	
	private String word;
	//private ArrayList<Integer> numsList;
	private TreeSet<Integer> lineNums;
	
	/**
	 * <p>Constructs a new IndexEntry object</p>
	 * @param wd word to add
	 */
	public IndexEntry(String wd){
		word = wd.toUpperCase();
		//numsList = new ArrayList<Integer>();
		lineNums = new TreeSet<Integer>();
	}
	
	/**
	 * 
	 * @return String word
	 */
	public String getWord() {
		return word;
	}
	
	/**
	 * 
	 * @param num the line number to add to the IndexEntry
	 */
	public void add(int num){
		/*if(!numsList.contains(num))
			numsList.add(num);*/
		if(!lineNums.contains(num))
			lineNums.add(num);
	}
	
	@Override
	public int compareTo(IndexEntry i){
		return word.toUpperCase().compareTo(i.getWord().toUpperCase());
	}
	
	@Override
	public String toString() {
		return "IndexEntry for " + word + " Appears on lines: " + lineNums;
	}
	
	
}
