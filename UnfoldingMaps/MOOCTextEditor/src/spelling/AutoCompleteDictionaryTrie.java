package spelling;

import java.util.List;
import java.util.Set;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;

/** 
 * An trie data structure that implements the Dictionary and the AutoComplete ADT
 * @author You
 *
 */
public class AutoCompleteDictionaryTrie implements  Dictionary, AutoComplete {

    private TrieNode root;
    private int size;
    

    public AutoCompleteDictionaryTrie()
	{
		root = new TrieNode();
	}
	
	
	/** Insert a word into the trie.
	 * For the basic part of the assignment (part 2), you should ignore the word's case.
	 * That is, you should convert the string to all lower case as you insert it. */
	public boolean addWord(String word)
	{
	    //TODO: Implement this method.
		char[] wordChar = word.toLowerCase().toCharArray();
		insertWordInDict(wordChar);
	    return true;
	}
	
	private void insertWordInDict(char[] wordChar) {
		// TODO Auto-generated method stub
		TrieNode currentNode=root;
		/**
		 * This is iterative approach as first pass will try to work
		 * on recursive approach later
		 */
		
		for(int i=0;i<wordChar.length;i++){
			TrieNode nextNode = currentNode.insert(wordChar[i]);
			// this traverses if a word already exists
			if(nextNode==null){
				nextNode = currentNode.getChild(wordChar[i]);
			}
						
			currentNode = nextNode;
			
			if(i==wordChar.length-1){
				nextNode.setEndsWord(true);
			}
	
		}
		
	}


	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
		
	    return 0;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		char[] wordChar = s.toLowerCase().toCharArray();
		TrieNode currentNode = root; 
		System.out.println(s.length());
		for(int i=0;i<=s.length();i++){
			
			if(i==s.length()){
				return currentNode.endsWord();
			}
			
			TrieNode nextNode = currentNode.getChild(wordChar[i]);
			//since we could not find next letter the word does not exist.
			if(nextNode == null){
				return false;
			}else{
				currentNode = nextNode;
			}
			
			
		}
		return false;
	}

	/** 
	 *  * Returns up to the n "best" predictions, including the word itself,
     * in terms of length
     * If this string is not in the trie, it returns null.
     * @param text The text to use at the word stem
     * @param n The maximum number of predictions desired.
     * @return A list containing the up to n best predictions
     */@Override
     public List<String> predictCompletions(String prefix, int numCompletions) 
     {
    	 // TODO: Implement this method
    	 // This method should implement the following algorithm:
    	 // 1. Find the stem in the trie.  If the stem does not appear in the trie, return an
    	 //    empty list
    	 // 2. Once the stem is found, perform a breadth first search to generate completions
    	 //    using the following algorithm:
    	 //    Create a queue (LinkedList) and add the node that completes the stem to the back
    	 //       of the list.
    	 //    Create a list of completions to return (initially empty)
    	 //    While the queue is not empty and you don't have enough completions:
    	 //       remove the first Node from the queue
    	 //       If it is a word, add it to the completions list
    	 //       Add all of its child nodes to the back of the queue
    	 // Return the list of completions
    	 
         return null;
     }

 	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return;
 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}
 	}
 	

	
}