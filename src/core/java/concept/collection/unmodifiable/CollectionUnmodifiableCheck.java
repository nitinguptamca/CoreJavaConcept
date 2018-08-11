package core.java.concept.collection.unmodifiable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import static java.util.Arrays.asList;

public class CollectionUnmodifiableCheck {

	private List<String> names = new ArrayList<>();

	public void testConcurrency() {
		names.addAll(asList("1", "2", "3", "4"));
		Collection<String> dynamicView = Collections.unmodifiableCollection(names);
		/*for (String s : dynamicView) {// throws ConcurrentModification in 2nd iteration
			System.out.println("s = " + s);
			names.remove(0); // The culprit line modifying the underlying collection
		}*/
		for (Iterator iterator = dynamicView.iterator(); iterator.hasNext();) {
			String string = (String) iterator.next();
			if ("2".equalsIgnoreCase(string)){
				iterator.remove();
			}
		}
	}

	public static void main(String[] args) {
		CollectionUnmodifiableCheck test = new CollectionUnmodifiableCheck();
		test.testConcurrency();
		System.out.println(""+test.names);
	}

}
