package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

import java.util.TreeMap;

public class MyWordCountApp {
	// public static final String fileName = "data/hamlet.txt";
	public static final String fileName = "data/fit.txt";
	
	private Map<String, Integer> map = new HashMap<String, Integer>();

	
	MyWordCountApp() throws FileNotFoundException{
		loadData();
	}
	// Load data from fileName into the above map (containing <word, its occurences>)
	// using the guide given in TestReadFile.java
	
	public void loadData() throws FileNotFoundException {
		Scanner input = new Scanner(new File(fileName));
		while(input.hasNext()) {
			String word = input.next();
			map.put(word, map.getOrDefault(word, 0)+1);
		}
		System.out.println(map);
	}

	// Returns the number of unique tokens in the file data/hamlet.txt or fit.txt
	public int countUnique() {
		// TODO
		return map.size();
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public void printWordCounts() throws FileNotFoundException {
		HashMap<String, Integer> map = new HashMap<>();
	
		map.putAll(this.map);
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according to ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public void printWordCountsAlphabet() {
		TreeMap<String,Integer> map = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		}
		);
		map.putAll(this.map);
		System.out.println(map);
	}
}
