package main;

public class QuickSort
{
	private static int length = 30;
	private static int[] array = {15, 21, 19, 4, 6, 29, 30, 12, 29, 22, 24, 16, 8, 14, 25, 4, 20, 17, 18, 30, 17, 27, 20, 20, 22, 23, 9, 3, 9, 21};
	private static int[] array_clone = new int[length];
	
	public static long assignment()
	{
		array_clone = array.clone();
		return quickSort();
	}
	
	private static long quickSort()
	{
	    int startIndex = 0;
	    int endIndex = length - 1;
	    long startTime = System.nanoTime();
	    doSort(startIndex, endIndex);
	    long endTime = System.nanoTime();
	    return endTime - startTime;
	}

	private static void doSort(int start, int end)
	{
	    if (start >= end)
	    {
	        return;
	    }
	    int i = start, j = end;
	    int current = i - (i - j) / 2;
	    while (i < j)
	    {
	        while (i < current && (array_clone[i] <= array_clone[current]))
	        {
	            i++;
	        }
	        while (j > current && (array_clone[current] <= array_clone[j]))
	        {
	            j--;
	        }
	        if (i < j)
	        {
	            int temp = array_clone[i];
	            array_clone[i] = array_clone[j];
	            array_clone[j] = temp;
	            if (i == current)
	            {
	                current = j;
	            }
	            else if (j == current)
	            {
	                current = i;
	            }
	        }
	    }
	    doSort(start, current);
	    doSort(current + 1, end);
	}
}
