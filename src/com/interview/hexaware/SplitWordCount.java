package com.interview.hexaware;
/*
import static java.util.Collections.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.function.Function;
import java.util.stream.Collectors;
*/

import static java.util.Collections.reverseOrder;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.AbstractMap.SimpleEntry;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SplitWordCount {

	static String str = "Hands on Experience java working with jsp web "
			+ "services handling last large payloads, java and orchestration"
			+ "throws Intel java java test test  Expressway Service Java jsp Gateway.JMS (ActiveMq , Rabbitmq) "
			+ "java jspintegrated with oracleAQ.";

	public static void main(String[] args) {
		findFirstNonRepeatingLetter(str, System.out::println);
	}

	private static void findFirstNonRepeatingLetter(String s, Consumer<Character> callback) {
		s.chars().mapToObj(i -> Character.valueOf((char) i))
				.collect(Collectors.groupingBy(identity(), LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream().filter(entry -> entry.getValue() == 1L).map(entry -> entry.getKey()).findFirst().map(c -> {
					callback.accept(c);
					return c;
				});
	}

	public static void main213213(String[] args) throws IOException {
		Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		Path path1 = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");

		List<Entry<String, Long>> wordcount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList());

		List<Entry<String, Long>> wordcount2 = Files.lines(path1).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList());
		wordcount.forEach(word -> System.out.println(word.getKey() + " ," + word.getValue()));

	}

	public static void main342342(String[] args) throws IOException {
		Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		Stream<String> stream = Files.lines(path);
		Stream<String> stramStr = stream.flatMap(line -> Arrays.stream(line.trim().split(" ")));
		stramStr.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList())
				.forEach(word -> System.out.println(word.getKey() + " ," + word.getValue()));
		// Spliterator<String> splitStr=Files.lines(path).spliterator();

	}

	public static void main2121(String[] args) throws IOException {
		Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.collect(Collectors.groupingBy(identity(), LinkedHashMap::new, counting())).entrySet().stream()
				.sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList())
				.forEach(wordcount -> System.out.println(wordcount.getKey() + "  ," + wordcount.getValue()));

	}

	public static void main111(String[] args) {
		/*
		 * String[] strword =str.trim().split(" "); Stream<String>
		 * stream=Arrays.stream(strword); Map<String, Integer> collected
		 * =stream.collect(groupingBy(Function.identity(), collectingAndThen(counting(),
		 * Long::intValue)));
		 * 
		 * Map<String, Integer> result2 = new LinkedHashMap<>();
		 * collected.entrySet().stream()
		 * .sorted(Map.Entry.<String,Integer>comparingByValue().reversed()) .limit(10)
		 * .forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));
		 * 
		 * result2.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k,
		 * v)));
		 */

		/*
		 * List<Map.Entry<String,Long>> str111=Arrays.stream(str.trim().split(" "))
		 * .map(String::toLowerCase)
		 * .collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new,
		 * Collectors.counting()))
		 * .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().
		 * reversed()).collect(toList());
		 * 
		 * for(Map.Entry<String,Long> strqqq:str111) {
		 * System.out.println(strqqq.getKey() +"  ,"+strqqq.getValue());
		 * 
		 * }
		 */

		Arrays.stream(str.trim().split(" ")).map(String::toLowerCase)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed()).collect(toList())
				.forEach(strqqq -> System.out.println(strqqq.getKey() + "  ," + strqqq.getValue()));

	}

	public static void main2(String[] args) {
		String[] str = { "hello", "bye", "ciao", "bye", "ciao", "java", "hello", "java", "hello" };
		Map<String, Integer> collected = Arrays.stream(str)
				.collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));

		collected.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toMap(Map.Entry::getValue,
				Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		collected.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

		System.out.println("_______________________________");
		Map<String, Integer> result2 = new LinkedHashMap<>();
		collected.entrySet().stream().sorted(Map.Entry.comparingByValue())
				.forEachOrdered(x -> result2.put(x.getKey(), x.getValue()));

		result2.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
	}

	public static void main576576(String[] args) {

		/*
		 * Path path =
		 * Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		 * Map<String, Integer> wordCount = Files.lines(path) .flatMap(line ->
		 * Arrays.stream(line.trim().split(" "))) .map(word ->
		 * word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()) .filter(word ->
		 * word.length() > 0) .map(word -> new SimpleEntry<>(word, 1)) .sorted((e1, e2)
		 * -> e1.getKey().compareTo(e2.getKey())) .reduce(new LinkedHashMap<>(), (acc,
		 * entry) -> { acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v
		 * == null ? 1 : v + 1)); return acc; }, (m1, m2) -> m1);
		 * 
		 * wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k,
		 * v)));
		 */

		/*
		 * Path path =
		 * Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		 * Map<String, Integer> wordCount=Files.lines(path) .flatMap(line ->
		 * Stream.of(line.split("\\s+"))) .map(String::toLowerCase)
		 * .collect(Collectors.toMap(word -> word, word -> 1, Integer::sum)) .entrySet()
		 * .stream() .sorted((a, b) -> a.getValue() == b.getValue() ?
		 * a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
		 */

	}

	public static void main999(String[] args) {
		String[] str = { "hello", "bye", "ciao", "bye", "ciao" };
		Map<String, Integer> collected = Arrays.stream(str)
				.collect(groupingBy(Function.identity(), collectingAndThen(counting(), Long::intValue)));
		collected.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

		Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");

		Map<String, Long> letterToCount = words.map(w -> w.split("")).flatMap(Arrays::stream)
				.collect(groupingBy(identity(), counting()));
		letterToCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

	}

	public static void main11(String[] args) throws IOException {
		Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		Map<String, Integer> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
				.map(word -> new SimpleEntry<>(word, 1))
				.collect(toMap(e -> e.getKey(), e -> e.getValue(), (v1, v2) -> v1 + v2));

		wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));
	}

	public static void main1212(String[] args) throws IOException {
		Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
		Map<String, Integer> wordCount = Files.lines(path).flatMap(line -> Arrays.stream(line.trim().split(" ")))
				.map(word -> word.replaceAll("[^a-zA-Z]", "").toLowerCase().trim()).filter(word -> word.length() > 0)
				.map(word -> new SimpleEntry<>(word, 1)).sorted((e1, e2) -> e1.getKey().compareTo(e2.getKey()))
				.reduce(new LinkedHashMap<>(), (acc, entry) -> {
					acc.put(entry.getKey(), acc.compute(entry.getKey(), (k, v) -> v == null ? 1 : v + 1));
					return acc;
				}, (m1, m2) -> m1);

		wordCount.forEach((k, v) -> System.out.println(String.format("%s ==>> %d", k, v)));

	}

	public static void main121(String[] args) {
		List<String> terms = Arrays.asList("Coding Great engine is great", "Search engine Great Engine are great",
				"Google is a engine nice Great search engine", "Bing engine is Great also a nice engine");
		TopOccurrence topOccurrence = new TopOccurrence(20);
		terms.parallelStream() // Utilizes multi-core hardware
				.flatMap(s -> Arrays.asList(s.split(" ")).stream())
				.collect(Collectors.toConcurrentMap(w -> w.toLowerCase(), w -> 1, Integer::sum)) // Big O(n)
				/*
				 * .collect(groupingBy(Function.identity(), collectingAndThen(counting(),
				 * Long::intValue)));
				 */
				.forEach((s, integer) -> topOccurrence.add(new WordCount(s, integer)));

		System.out.println(topOccurrence);

		String sentence = "Hello alan i am here where are you and what are you doing hello are you there";
		List<String> words = Arrays.asList(sentence.split(" "));

		List<String> result = words.stream().map(String::toLowerCase).collect(groupingBy(identity(), counting()))
				.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue(reverseOrder())
						.thenComparing(Map.Entry.comparingByKey()))
				.limit(7).map(Map.Entry::getKey).collect(toList());

		System.out.println(result);

	}

	static class TopOccurrence {
		private final PriorityQueue<WordCount> minHeap;

		private final int maxSize;

		public TopOccurrence(int maxSize) {
			this.maxSize = maxSize;
			this.minHeap = new PriorityQueue<WordCount>(Comparator.comparingInt(wc -> wc.count));
			// This constructs a min heap (when order of elements is natural i.e. ascending
			// order).
			// We are using Natural order for integers (wc.count)
			// In order to create a max-heap, we just need to provide reversed comparator
			// i.e. that sorts in descending order,
			/// as shown below
			// this.minHeap = new
			// PriorityQueue<WordCount>(Comparator.comparingInt((WordCount wc) ->
			// wc.count).reversed());
		}

		public void add(WordCount data) {
			if (minHeap.size() < maxSize) { // size() is Big O(1)
				minHeap.offer(data); // Big O(log(k)) where k is the number of top occurrences required
			} else if (minHeap.peek().count < data.count) { // peek() is Big O(1)
				minHeap.poll(); // Big O(log(k))
				minHeap.offer(data); // Big O(log(k))
			}
		}

		@Override
		public String toString() {
			return "TopOccurrence{" + "minHeap=" + minHeap + ", maxSize=" + maxSize + '}';
		}
	}

	static class WordCount {
		protected final String word;
		protected final int count;

		WordCount(String word, int count) {
			this.word = word;
			this.count = count;
		}

		@Override
		public String toString() {
			return "{" + "word='" + word + '\'' + ", count=" + count + '}' + "\r\n";
		}
	}
}
