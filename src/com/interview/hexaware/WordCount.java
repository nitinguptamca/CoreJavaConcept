package com.interview.hexaware;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WordCount {
		public static void main(String[] args) throws IOException {
			Path path = Paths.get("src/com/interview/hexaware/WordCountIncrementOrder.java");
			Stream<String> stream=Files.lines(path);
			stream.flatMap(a -> Arrays.stream(a.trim().split(" ")))
			.collect(Collectors.groupingBy(Function.identity(),LinkedHashMap::new ,java.util.stream.Collectors.counting()))
			.entrySet().stream().sorted(Map.Entry.<String ,Long> comparingByValue().reversed())
			.collect(java.util.stream.Collectors.toList()).forEach(word->System.out.println(word.getKey() +" ,"+word.getValue()));
		}
}
