package Task2;

import java.io.IOException;

public class Test {
	public static void main(String[] args) throws IOException {
		TextAnalyzer t= new TextAnalyzer();
//		t.displayText();
		t.displayWords();
		System.out.println(t.mostFrequentWord());
	}

}
