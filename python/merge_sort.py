class Solution(object):
	def merge_sort(self, vals):
		return self.divide(vals, 0, len(vals)-1)

	def divide(self, vals, start, end):
		if start > end:
			return None
		if start == end:
			return [vals[start]]
		mid = (start + end)/2
		first = self.divide(vals, start, mid)
		second = self.divide(vals, mid+1, end)
		return self.merge(first, second)

	def merge(self, list1, list2):
		ret = [None for i in xrange(len(list1) + len(list2))]
		i = j = r = 0
		while (i < len(list1)) and (j < len(list2)):
			if list1[i] <= list2[j]:
				ret[r] = list1[i]
				i += 1
			else:
				ret[r] = list2[j]
				j += 1
			r += 1

		while i < len(list1):
			ret[r] = list1[i]
			i += 1
			r += 1

		while j < len(list2):
			ret[r] = list2[j]
			j += 1
			r += 1
		return ret

if __name__ == "__main__":
	# x = [1,3]
	# y = [2]
	z = Solution()
	# print z.merge(x,y)

	import random
	x = [random.randint(1,500) for i in xrange(random.randint(1,50))]
	print x
	print z.merge_sort(x)