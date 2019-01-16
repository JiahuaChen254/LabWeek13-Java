# LabWeek13

**Write the answer to each question in a file src/Q#.java where # is the question number:**

**Q1.** Given two sorted lists of Integers as input, write a method that produces a sorted list of Integers as output that represents the union of the two input lists.  If the size of the two input lists are respectively a and b, the running time and space required by the algorithm should both be O(a + b).

**Q2.** Given an unordered list of Doubles as input, produce a sorted list of the top-k Doubles as output.  Use a Min Heap ("Min" is not a typo -- figure out why) to maintain the top-k results of n doubles in O(n log k) time and O(k) space (not counting the space for the input array of n numbers).

**Q3.** Build a class that maintains a count of all bigrams (pairs of words occurring next to each other) in a TRIE (see <https://en.wikipedia.org/wiki/Trie>).  An example TRIE is below for "to be or not to be Shakespeare":
 
```            
     / to - be: 2
ROOT - or - not: 1
     \ not - to: 1
     \ be - or: 1
          \ shakespeare: 1
```

Here "to be" occurs twice and all other bigrams (pairs of words) occur once.

Note that "be" may be followed by either "or" or "shakespeare", hence the branching at the second level.

Write a method called ``void buildTRIE(String s)`` that takes a String passed in as the input and builds a TRIE to count bigrams like the one given above.  Use a data member ``HashMap<String,HashMap<String,Integer>>`` to store the TRIE.  

Write another method for the class called ``int getFreq(String s1, String s2)`` that returns the frequency of the bigram ``(s1,s2)`` in O(1) time.  For example, given the TRIE example above, we would have the following results:

* ``getFreq("to", "not") -> 0``
* ``getFreq("or", "not") -> 1``
* ``getFreq("to", "be") -> 2``
