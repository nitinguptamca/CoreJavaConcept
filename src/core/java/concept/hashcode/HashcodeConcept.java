package core.java.concept.hashcode;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

class HashcodeTest {

	private int count = 0;

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public HashcodeTest(int count) {
		super();
		this.count = count;
	}

	@Override
	public int hashCode() {
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashcodeTest other = (HashcodeTest) obj;
		if (count != other.count)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "HashcodeTest [count=" + count + "]";
	}

}

public class HashcodeConcept {
	
	public static void main212(String[] args) {
		Map<HashcodeTest, HashcodeTest> hashMapTest = new HashMap<>();
		HashcodeTest hashcodeTest1 = new HashcodeTest(10);
		HashcodeTest hashcodeTest2 = new HashcodeTest(20);
		HashcodeTest hashcodeTest3 = new HashcodeTest(30);
		HashcodeTest hashcodeTest4 = new HashcodeTest(40);
		HashcodeTest hashcodeTest5 = new HashcodeTest(50);
		HashcodeTest hashcodeTest6 = new HashcodeTest(60);
		hashMapTest.put(hashcodeTest1, hashcodeTest1);
		hashMapTest.put(hashcodeTest2, hashcodeTest3);
		hashMapTest.put(hashcodeTest6, hashcodeTest6);
		hashMapTest.put(hashcodeTest5, hashcodeTest3);
		hashMapTest.put(hashcodeTest4, hashcodeTest5);
		System.out.println("__________________________" + hashMapTest.size());

		System.out.println(hashMapTest.get(hashcodeTest1));
		System.out.println(hashMapTest.get(hashcodeTest2));
		System.out.println(hashMapTest.get(hashcodeTest4));
		System.out.println(hashMapTest.get(hashcodeTest5));
		System.out.println(hashMapTest.get(hashcodeTest6));

	}

	public void testMutableKey() {
		Map<MutableKey, Integer> testMap = new HashMap<>();
		MutableKey mutableKey = new MutableKey();
		mutableKey.setName("TestName");
		testMap.put(mutableKey,12);
		Object o = testMap.get(mutableKey);
		System.out.println("before changing key = " + o);
		
		MutableKey mutableKey1 = new MutableKey();
		mutableKey1.setName("TestName45");
		testMap.put(mutableKey1, 45);
		 o = testMap.get(mutableKey1);
		System.out.println("before changing key = " + o);
		
		 o = testMap.get(mutableKey1);
		System.out.println("before changing key = " + o);
		mutableKey1.setName("abc");//// ====Problematic Instruction
		o = testMap.get(mutableKey1);
		System.out.println("after changing key = " + o);
	}

	public static void main(String[] args) {
		HashcodeConcept test = new HashcodeConcept();
		test.testMutableKey();
	}

}
