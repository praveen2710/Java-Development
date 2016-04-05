package week5;

/**
 * My implementation to convert selectionSortAlgorith To implementation
 * @author praveen
 *
 */
public class SelectionSort {
	
	/**
	 * This will take a array object and sort it based on selection sort
	 * @param val
	 */
	public static void selectionSort(int[] val){
		//this will loop through all elements but last.
		for(int i=0;i<val.length-1;i++){
			int postionToSwapWith = i;
			for(int j=i+1;j<val.length;j++){
				if(val[postionToSwapWith]> val[j]){
					postionToSwapWith = j;
				}
			}		
			swapIntegers(val,i,postionToSwapWith);
		}
		
	}
	
	public static void swapIntegers(int[] val,int posToSwap,int posToSwapWith){
		int temp;
		temp = val[posToSwap];
		val[posToSwap] = val[posToSwapWith];
		val[posToSwapWith]=temp;
	}
	

	public static void main(String args[]){
		int[] toSort= {14,2,13,32,15,56,63,19,21,11};
		
		//since array is a object the reference gets passed in
		selectionSort(toSort);
		
		//the actual list gets sorted 
		for(int sorted:toSort){
			System.out.println(sorted);
		}
		
	}
	
}
