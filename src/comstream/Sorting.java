package comstream;

import static java.util.Arrays.asList;

import java.util.ArrayList;
//import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Sorting {
	static class Person {
		String name;
		int age;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public String toString() {
			return "name=" + name + ",age=" + age + '}';
		}
	}

	public static void main(String[] args) {

		String str = "zzzzzbbbccccddehhhhiii";
		int[] countingArray = new int[128];
		str.chars().forEach(value -> countingArray[value]++);
		int nonRepeatingCharAsInt = 0;
		for (int i = 0; i < countingArray.length; i++) {
			if (countingArray[i] == 1) {
				nonRepeatingCharAsInt = i;
				break;
			}
		}
		System.out.println("character = " + Character.valueOf((char) nonRepeatingCharAsInt));
		
		Optional<Character> s=str.chars()
		.mapToObj(i -> Character.valueOf((char) i)).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
		.entrySet().stream()
		.filter(entry -> entry.getValue() == 1L)
		.map(entry -> entry.getKey())
		.findFirst();
		System.out.println(s);
		
		/*.map(c -> {	c.accept(c);
		return c;
		});*/
	}

	public static void main12(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Second", 26));
		persons.add(new Person("Abc", 21));
		persons.add(new Person("Nitin", 38));
		Set<Person> personset = new TreeSet<Person>();
		personset.add(new Person("Second", 26));
		/**
		 * Exception in thread "main" java.lang.ClassCastException:
		 * comstream.Sorting$Person cannot be cast to java.lang.Comparable at
		 * java.util.TreeMap.compare(Unknown Source) at java.util.TreeMap.put(Unknown
		 * Source) at java.util.TreeSet.add(Unknown Source) at
		 * comstream.Sorting.main(Sorting.java:49)
		 */
	}

	public static void main11(String[] args) {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Second", 26));
		persons.add(new Person("Abc", 21));
		persons.add(new Person("Nitin", 38));
		java.util.Collections.sort(persons, new Comparator<Person>() {
			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age) {
					return o1.name.compareToIgnoreCase(o2.name);
				} else if (o1.age < o2.age) {
					return -1;
				}
				return 1;
			}
		});
		System.out.println(java.util.Arrays.toString(persons.toArray()));

		persons.add(new Person("Seco23nd", 26));
		persons.add(new Person("12Abc", 21));
		persons.add(new Person("11Nitin", 3118));
		System.out.println("***************************");
		persons.sort(Comparator.comparing(Person::getName).thenComparing(Person::getAge));

		System.out.println(java.util.Arrays.toString(persons.toArray()));

		List<String> names = new ArrayList<>(asList("1st", "2nd", "3rd", "4th"));

	}
}