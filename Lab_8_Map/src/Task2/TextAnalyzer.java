package Task2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.*;

public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	TextAnalyzer() throws IOException {
		load("data/short.txt");
	}

	public void load(String fileName) throws IOException {

		BufferedReader reader = new BufferedReader(new FileReader(fileName));
		String line = null;
		int index = 1;
		while (true) {
			line = reader.readLine();

			if (line == null)
				break;
			StringTokenizer tokens = new StringTokenizer(line, " ");

			while (tokens.hasMoreTokens()) {
				// System.out.println(tokens.nextToken());
				String word = tokens.nextToken();
				if (!tokens.hasMoreTokens()) {
					add(word, -index);
				} else {
					add(word, index);
				}

			}
			index++;

		}
		System.out.println(this.map);
		reader.close();

	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		if (map.containsKey(word)) {
			ArrayList<Integer> values = map.get(word);
			values.add(position);
		} else {
			ArrayList<Integer> values = new ArrayList<>();
			values.add(position);
			map.put(word, values);

		}

	}

//	public void add2(String word,int position) {
//		if(map.containsKey(word)) {
//			ArrayList<Integer> values = map.get(word);
//			values.add(position);
//		}else {
//			ArrayList<Integer> values = new ArrayList<>();
//			values.add(position);
//			map.put(word, values);
//		}
//	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		TreeMap<String, ArrayList<Integer>> re = new TreeMap<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				
				return o1.compareToIgnoreCase(o2);
			}
		});

		re.putAll(map);
		System.out.println(re);
	}

	// This method will display the content of the text file stored in the map
	public void displayText() {
		Map<Integer, String> re = new HashMap<>();
		Iterator<Map.Entry<String, ArrayList<Integer>>> iter = map.entrySet().iterator();
		while(iter.hasNext()) {
			Map.Entry<String, ArrayList<Integer>> next = iter.next();
			String key = next.getKey();
			ArrayList<Integer> values = next.getValue();
			for(int index : values) {
				re.put(index, key);
			}
		}
		Set<Integer> keys = re.keySet();
		for (Integer integer : keys) {
			if(integer<0) {
				System.out.println(re.get(integer)+"\n");
			}else {
				System.out.println(re.get(integer)+" ");
			}
		}
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String re = null;
		int max = 0;
		Set<String> keys = map.keySet();
		for (String key : keys) {
			ArrayList<Integer> values = map.get(key);
			if (values.size() > max) {
				max = values.size();
				re = key;
			}
		}
		return re;
	}

}
