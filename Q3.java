import java.util.ArrayList;
import java.util.HashMap;

import tokenizer.SimpleTokenizer;

public class Q3 {
	private HashMap<String,HashMap<String,Integer>> _TRIE;
	
	// takes a String passed in as the input and builds a TRIE to count bigrams
	void buildTRIE(String s) {
		_TRIE = new HashMap<String,HashMap<String,Integer>>(); // I initially forgot to do
		ArrayList<String> tokens = new ArrayList<String>();
		SimpleTokenizer st = new SimpleTokenizer();
		tokens.addAll(st.tokenize(s));
		for (int i = 0; i < tokens.size()-1; i++) {
			String token = tokens.get(i);
			String nexttoken = tokens.get(i+1);
			if (_TRIE.containsKey(token)) {
				if (_TRIE.get(token).containsKey(nexttoken)) {
					_TRIE.get(token).put(nexttoken,_TRIE.get(token).get(nexttoken)+1);
				}
				else {
					_TRIE.get(token).put(nexttoken,1);
				}			
			}
			else {
				_TRIE.put(token, new HashMap<String,Integer>());
				_TRIE.get(token).put(nexttoken, 1);
			}
		}			
	}
	
	int getFreq(String s1, String s2) {
		if (_TRIE.get(s1) == null || _TRIE.get(s1).get(s2) == null) {
			return 0;
		}
		return _TRIE.get(s1).get(s2);
	}
	
	public static void main(String[] args) {
		SimpleTokenizer it = new SimpleTokenizer();
		String s = "to be or not to be Shakespeare";
		System.out.println(it.tokenize(s)); // [to, be, or, not, to, be, Shakespeare]
		Q3 test = new Q3();
		test.buildTRIE(s);
		System.out.println(test.getFreq("to", "not")); // 0
		System.out.println(test.getFreq("or", "not")); // 1
		System.out.println(test.getFreq("to", "be")); // 2
	}

}