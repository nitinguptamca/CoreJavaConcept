package com.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.util.stream.Collectors.toList;

public class Anagrams {
	private static Map<String, List<String>> anagramsMap = new HashMap<>(100);

	private static String canonicalize(String s) {
		System.out.println("test  : "+Stream.of(s.split("")).sorted().collect(Collectors.joining()));
		return Stream.of(s.split("")).sorted().collect(Collectors.joining());
	}

	public static void main(String[] args) {
		String[] input = { "akka", "akak", "baab", "baba", "bbaa" };

		CopyOnWriteArrayList copyOnWriteArrayList=new CopyOnWriteArrayList();
		  Stream<String> stream=Arrays.stream(input); stream.collect
		 (Collectors.groupingBy(java.util.function.Function.identity(),HashMap::new,
		  java.util.stream.Collectors.counting())) .entrySet().forEach(word ->
		  System.out.println(word.getKey() +" ,"+word.getValue()));
		  
		  Map<String, Set<String>> map=Arrays.stream(input)
		  .flatMap(Pattern.compile("\\W+")::splitAsStream)
		  .collect(Collectors.groupingBy(Anagrams::canonicalize, Collectors.toSet()));
		 

		Arrays.stream(input).flatMap(Pattern.compile("\\W+")::splitAsStream)
				.collect(Collectors.groupingBy(Anagrams::canonicalize, Collectors.toSet())).values().stream()
				.filter(list -> list.size() > 1).collect(Collectors.toList()).forEach(System.out::println);

		Arrays.stream(input).flatMap(Pattern.compile("\\W+")::splitAsStream)
				.collect(Collectors.groupingBy(Anagrams::canonicalize, HashMap::new, Collectors.toSet())).entrySet()
				.stream().collect(toList()).forEach(wordcount -> System.out.print(wordcount.toString()));
		
		Arrays.stream(input).flatMap(Pattern.compile("\\W+")::splitAsStream)
		.collect(Collectors.groupingBy(Anagrams::canonicalize, HashMap::new, Collectors.toSet())).entrySet()
		.stream().collect(toList()).toString();
		
		
		
		

		for (String s : input) {
			char[] word = s.toCharArray();
			Arrays.sort(word);
			String key = String.valueOf(word);
			if (!anagramsMap.containsKey(key)) {
				anagramsMap.put(key, new ArrayList<String>());
			}
			anagramsMap.get(key).add(s);
		}
		System.out.println("anagramsMap = " + anagramsMap);

	}
}