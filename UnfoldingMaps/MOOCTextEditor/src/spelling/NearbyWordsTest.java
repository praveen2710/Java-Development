package spelling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class NearbyWordsTest {
	
	NearbyWords w;
	
	@Before
	public void setUp(){
		Dictionary d = new DictionaryHashSet();
		DictionaryLoader.loadDictionary(d, "data/dict.txt");
		w = new NearbyWords(d);
	}

	
	@Test
	public void testInsertion(){
		List<String> retList = new ArrayList<String>();
		w.insertions("part", retList, true);
		assertEquals("Word apart is present", true, retList.contains("apart"));
		assertEquals("Word party is present", true, retList.contains("party"));
		assertEquals("Word party is present", false, retList.contains("jpart"));
	}
	
	@Test
	public void testDeletion(){
		List<String> retList = new ArrayList<String>();
		w.deletions("apart", retList, true);
		assertEquals("Word apart is present", true, retList.contains("part"));
		assertEquals("Word party is present", false, retList.contains("apar"));
		assertEquals("Word party is present", false, retList.contains("apart"));
	}
}
