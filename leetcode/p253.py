
from typing import List
import random

class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        """253. Meeting Rooms II
        Heap topic:
            parent_index = (index-1)/2
            left_child_index = (2*index) + 1 
            left_child_index = (2*index) + 2
        Sol:
            1. Sort by start time
            2. create min_heap
            3. loop over intervals:
                - if current[i][start] >= end
                    use the room heappop
                - Add end date to the heap
                     
        """
        # sort by start date
        intervals = (sorted(intervals, key=lambda x: x[0]))
        print(intervals)
        intervals_diff = (sorted(intervals, key = lambda: (x[1]-x[0])))
        print(intervals_diff)
        num_intervals = 1 # at least one room conference.
        for indx in range(1,len(intervals)):
            start,_ = intervals[indx]
            _,end_prev = intervals[indx-1]
            if start < end_prev:
                num_intervals +=1
        
        return num_intervals

def main():
    Solution()

if __name__ == 'main':
    main()