package hello.ds;

import java.util.Arrays;

//@Decorator
public class Sorts {
	
	

	public static void main(String s[]) {

		int[] input = { 10, 2, 8, 6, 7, 3 };

		Sorts bs = new Sorts();
		boolean bubbleSort = false;
		boolean selectionSort = false;
		
		boolean insertionSort = false;
		
		boolean mergeSort = false;
		boolean mergeSort1 = true;
		
		if(bubbleSort)
			bs.bubbleSort(input);
		if(selectionSort)
			bs.selectionSort(input);
		
		if(insertionSort)
			bs.insertionSort(input);
		
		if(mergeSort)
			bs.mergeSort(input, 0, input.length-1);
		
		if(mergeSort1)
			bs.mergeSort1(input, 0, input.length-1);
		
		
	}

    // Main function that sorts arr[l..r] using 
    // merge() 
	public void mergeSort1(int arr[], int l, int r) {
		System.out.println(" l -->"+l + " <-- r -->"+r);
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort1(arr, l, m);
			mergeSort1(arr, m + 1, r);

			// Merge the sorted halves
			merge1(arr, l, m, r);
		}
		
		System.out.println("arr -->"+Arrays.toString(arr));
	}

	
	private void merge1(int[] data, int start, int mid, int end) {
		int sizeOfLeft = mid-start+1;
		int sizeOfRight = end - mid;
		int[] left = new int[sizeOfLeft];
		int[] right = new int[sizeOfRight];
		for (int i = 0; i < sizeOfLeft; i++) {
			left[i] = data[start + i]; // be careful here
		}
		for (int j = 0; j < sizeOfRight; j++) {
			right[j] = data[mid + 1 + j]; // be careful
		}
		int i = 0, j = 0;
		for (int k = start; k <= end; k++) {
			if ((j >= sizeOfRight) || (i < sizeOfLeft && left[i] <= right[j])) {
				data[k] = left[i];
				i++;
			} else {
				data[k] = right[j];
				j++;
			}
		}
	}
	
	 // Merges two subarrays of arr[]. 
    // First subarray is arr[l..m] 
    // Second subarray is arr[m+1..r] 
	public void merge(int arr[], int l, int m, int r) {
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int[n1];
		int R[] = new int[n2];

		/* Copy data to temp arrays */
		for (int i = 0; i < n1; ++i)
			L[i] = arr[l + i];
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];

		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarry array
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

    // Main function that sorts arr[l..r] using 
    // merge() 
	public void mergeSort(int arr[], int l, int r) {
		System.out.println(" l -->"+l + " <-- r -->"+r);
		if (l < r) {
			// Find the middle point
			int m = (l + r) / 2;

			// Sort first and second halves
			mergeSort(arr, l, m);
			mergeSort(arr, m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
		
		System.out.println("arr -->"+Arrays.toString(arr));
	}

	private void insertionSort(int[] input) {
		
		
		for (int i = 1; i < input.length; i++) {

			int current = input[i];
			int j = i - 1;
			while (j >= 0 && input[j] > current) {
				System.out.println("current --> "+current+" <-- i --> "+i+"<-- j -->"+j +"<-- input[j] -->"+input[j]);
				input[j+1] = input[j];
				j = j-1;
				
				
			}
			input[j+1] = current;
		}
		System.out.println("Sorted -->"+Arrays.toString(input));
		
	}

	public int[] bubbleSort(int[] input) {

		int loop = 0;

		for (int i = 0; i < input.length - 1; i++) {

			for (int j = 0; j < (input.length - 1 - i); j++) {

				System.out.println("i-->" + i + "<-- j -->" + j);
				
				if (input[j] > input[j + 1]) {

					int swap = input[j];
					input[j] = input[j + 1];
					input[j + 1] = swap;
					loop++;
					System.out.println("Sorted Array -->" + Arrays.toString(input) + " <-- loop -->" + loop);
				}
			}
		}

		return new int[0];
	}
	
	public void selectionSort(int input []) {
		
		
		for (int i = 0; i < input.length - 1; i++) {
			int minIndex = i;

			for (int j = i+1; j < input.length; j++) {
				System.out.println("minIndex -->"+minIndex);
				if (input[j] < input[minIndex]) {
					minIndex = j;
				}
				int temp = input[minIndex];
				input[minIndex] = input[i];
				input[i] = temp;

				System.out.println(" Sorting --> " + Arrays.toString(input));
				
			}
		}
			
	}
}
