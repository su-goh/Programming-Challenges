from sortedcontainers import SortedList

class Solution:
    def containsNearbyAlmostDuplicate(self, nums: List[int], k: int, t: int) -> bool:
        
        l = SortedList()
        
        for i in range(len(nums)):
            if i > k:
                l.remove(nums[i-k-1])
            
            small = SortedList.bisect_left(l, nums[i] - t)
            big = SortedList.bisect_right(l, nums[i] + t)
            
            if small != big and small != len(l):
                return True
            l.add(nums[i])
            
        return False