import java.util.ArrayList;
import java.util.TreeSet;

/**
 * <p></p>
 * @author Patrick Riley
 */

public class IndexEntry {
	
	private String word;
	private ArrayList<Integer> numsList;
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
	
	public void add(int num){
		/*if(!numsList.contains(num))
			numsList.add(num);*/
		if(!lineNums.contains(num))
			lineNums.add(num);
	}

	@Override
	public String toString() {
		return "IndexEntry for " + word + "Appears on lines: " + lineNums;
	}
	
	
}
