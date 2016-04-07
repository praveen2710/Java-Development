package week5;
/**
 * This is implementation of insertion sort which is very different from how 
 * selection sort works 
 * @author praveen
 *
 */
public class InsertionSort {
	
	/**
	 * method that implements selectionSort 
	 * @param val
	 */
	public static void selectionSort(int[] val){
		
		for(int i = 1;i<val.length;i++){
			int curIndex = i;
			while(curIndex > 0 && val[curIndex]<val[curIndex-1]){
				SelectionSort.swapIntegers(val, curIndex-1,curIndex);
				curIndex--;
			}
		}
		
	}
	
	public static void main(String args[]){
		int[] toSelSort = {41,12,87,65,90,11,2,54,16,81};
		
		selectionSort(toSelSort);
		
		SelectionSort.displaySortedList(toSelSort);
	}
}
