import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MainTester{

	public static void main(String[] args)
	{
		ArrayList<Integer> l = new Random().ints(50,1,1000).boxed().collect(Collectors.toCollection(ArrayList::new));
		Iterator<Integer> l_it = l.iterator();
		MergeSort solution = new MergeSort();
		ArrayList<Integer> sorted = solution.mergeSort(l);
		Iterator<Integer> sorted_it = sorted.iterator();
		System.out.format("%-15s%-15s\n", "Original", "Sorted");
		System.out.format("%-15s%-15s\n", "--------", "------");
		while(l_it.hasNext() && sorted_it.hasNext())
			System.out.format("%-15d%-15d\n", l_it.next(), sorted_it.next());
	}

}