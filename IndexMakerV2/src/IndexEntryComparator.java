import java.util.Comparator;

/**
 * This class compares indexEntries based upon IndexEntry's .compareTo, which compares based on alphabetical order
 */

/**
 * @author Patrick
 *
 */
public class IndexEntryComparator implements Comparator<String>{
	
	boolean ascend;
	
	public IndexEntryComparator(){
		ascend = true;
	}
	
	public IndexEntryComparator(boolean a){
		ascend = a;
	}
	
	@Override
	public int compare(String i1, String i2) {
		return  i1.compareTo(i2);
	}

}
