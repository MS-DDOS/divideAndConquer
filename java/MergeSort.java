import java.util.ArrayList;
import java.util.Iterator;

public class MergeSort
{

		public ArrayList<Integer> mergeSort(final ArrayList<Integer> vals)
		{
			return divide(vals, 0, vals.size()-1);
		}

		public ArrayList<Integer> divide(final ArrayList<Integer> vals, final int start, final int end){
			if(start > end)
			{
				return null;
			}
			else if(start == end)
			{
				ArrayList<Integer> v = new ArrayList<Integer>(1);
				v.add(vals.get(start));
				return v;
			}
			int mid = (start + end) / 2;
			ArrayList<Integer> first = divide(vals, start, mid);
			ArrayList<Integer> second = divide(vals, mid + 1, end);
			return merge(first, second);
		}

		public ArrayList<Integer> merge(final ArrayList<Integer> list1, final ArrayList<Integer> list2)
		{
			ArrayList<Integer> ret = new ArrayList<Integer>(list1.size() + list2.size());
			Iterator<int> list1_it = list1.iterator();
			Iterator<int> list2_it = list2.iterator();
			int val1 = list1_it.next();
			int val2 = list2_it.next();
			while(list1_it.hasNext() && list2_it.hasNext())
			{
				if(val1 <= val2)
				{
					ret.add(val1);
					val1 = list1_it.next();
				}
				else
				{
					ret.add(val2);
					val2 = list2_it.next();
				}
			}

			while(list1_it.hasNext())
			{
				ret.add(val1);
				val1 = list1_it.next();
			}

			while(list2_it.hasNext())
			{
				ret.add(val2);
				val2 = list2_it.next();
			}
			return ret;
		}

}