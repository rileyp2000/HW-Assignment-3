import java.util.Comparator;

/**
 * This class compares indexEntries based upon IndexEntry's .compareTo, which compares based on alphabetical order
 */

/**
 * @author Patrick
 *
 */
public class IndexEntryComparator implements Comparator<IndexEntry>{
	
	boolean ascend;
	
	public IndexEntryComparator(){
		ascend = true;
	}
	
	public IndexEntryComparator(boolean a){
		ascend = a;
	}
	
	@Override
	public int compare(IndexEntry i1, IndexEntry i2) {
		return  i1.compareTo(i2);
	}

}
