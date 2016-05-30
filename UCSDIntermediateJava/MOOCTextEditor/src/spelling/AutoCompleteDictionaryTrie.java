package spelling;

import java.util.List;
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
		TrieNode lastNode = insertWordInDict(wordChar);
		if(!lastNode.endsWord()){
			lastNode.setEndsWord(true);
			size++;
		}
	    return true;
	}
	
	/**
	 * This will add a node for each char in word to add if not existing
	 * @param wordChar the char of word for which we need to add a node
	 * @return the last char node that ends the word.
	 */
	private TrieNode insertWordInDict(char[] wordChar) {
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
		}
		
//		currentNode.setEndsWord(true);	
		
		return currentNode;
	}


	/** 
	 * Return the number of words in the dictionary.  This is NOT necessarily the same
	 * as the number of TrieNodes in the trie.
	 */
	public int size()
	{
	    //TODO: Implement this method
	    return size;
	}
	
	
	/** Returns whether the string is a word in the trie */
	@Override
	public boolean isWord(String s) 
	{
	    // TODO: Implement this method
		char[] wordChar = s.toLowerCase().toCharArray();
		TrieNode currentNode = root; 
		for(int i=0;i<s.length();i++){
			
			TrieNode nextNode = currentNode.getChild(wordChar[i]);
			//since we could not find next letter the word does not exist.
			if(nextNode == null){
				return false;
			}else{
				currentNode = nextNode;
			}
		}
		if(currentNode.endsWord()){
			return true;
		}else{
			return false;
		}
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
    	 
    	 List<String> predictWords = new LinkedList<String>();
    	 
    	 LinkedList<TrieNode> queueNodes = new LinkedList<TrieNode>();
    	 
    	 TrieNode stemNode = findStem(prefix);
    	 
    	 if(stemNode!=null){
    		 queueNodes.add(stemNode);
    	 }
    	 
    	 while(predictWords.size()!=numCompletions){
    		 TrieNode queueNode ;
    		 if(!queueNodes.isEmpty())
    			 queueNode =queueNodes.removeFirst();
    		 else
    			 return predictWords;
    		 if(queueNode.endsWord())
    			 predictWords.add(queueNode.getText());
    		 
    		 addNodeToQueue(queueNode, queueNodes, numCompletions);
    	 }
    	 
    	 return predictWords;
     }
     
    /**
     * This adds all child nodes to a node until the queue is full or no more child nodes are present
     * 
     * @param currNode the node for which we need to find children
     * @param queueNodes the list to which we are adding child nodes
     * @param numCompletions the number of elements we want to add to list.
     */
 	private void addNodeToQueue(TrieNode currNode, List<TrieNode> queueNodes, int numCompletions) {
		// TODO Auto-generated method stub
 		 for (Character c : currNode.getValidNextCharacters()) {
			 	TrieNode nextNode = currNode.getChild(c);
	 			if(queueNodes.size()<=numCompletions)
	 			  queueNodes.add(nextNode);
	 		}
	}

 	/**
 	 * Based on the input finds the node in the prefix 
 	 * @param prefix the string for which we need to find stem node.
 	 * @return the node of the last char in prefix or
 	 *         {@code NULL} if the node is not found.
 	 */
	private TrieNode findStem(String prefix) {
		// TODO Auto-generated method stub
		TrieNode currentNode = root;
		
		char[] charWords = prefix.toCharArray();
		
		for(char charWord:charWords){
			currentNode = currentNode.getChild(charWord);
			if(currentNode == null)
				return null;
		}
		return currentNode;
	}


	// For debugging
 	public void printTree()
 	{
 		printNode(root);
 	}
 	
 	/** Do a pre-order traversal from this node down 
 	 * @param count 
 	 * @return */
 	public void printNode(TrieNode curr)
 	{
 		if (curr == null) 
 			return ;
	 		
 		System.out.println(curr.getText());
 		
 		TrieNode next = null;
 		for (Character c : curr.getValidNextCharacters()) {
 			next = curr.getChild(c);
 			printNode(next);
 		}

 	}
	
}