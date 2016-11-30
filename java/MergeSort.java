import java.util.ArrayList;

public class MergeSort
{

		public ArrayList<Integer> mergeSort(final ArrayList<Integer> vals)
		{
			return divide(vals, 0, vals.size()-1);
		}

		public ArrayList<Integer> divide(final ArrayList<Integer> vals, final int start, final int end){
			if(start > end)
				return null;
			if(start == end)
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
			int i, j;
			i = 0;
			j = 0;
			ArrayList<Integer> ret = new ArrayList<Integer>(list1.size() + list2.size());
			while((i < list1.size()) && (j < list2.size()))
			{
				if(list1.get(i) <= list2.get(j))
				{
					ret.add(list1.get(i));
					i++;
				}
				else
				{
					ret.add(list2.get(j));
					j++;
				}
			}

			while(i < list1.size())
			{
				ret.add(list1.get(i));
				i++;
			}

			while(j < list2.size())
			{
				ret.add(list2.get(j));
				j++;
			}
			return ret;
		}

}