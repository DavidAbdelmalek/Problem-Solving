
from typing import List
import random

class Solution:
    """The idea is Prefix sum. 
        1. Cumulatively add items in list. (assume it is line of sums)
        2. Pick a random num
        3. Multiply random num by total cum sum to get target value
        4. Sol: Try to get the range where the target can lay into.
    """    
    def __init__(self, w: List[int]):
        self.w = w
        self.cum_sum =0
        
        # Sum over all elements in w
        self.prefix_sum = [] 
        for i in w:
            self.cum_sum += i 
            self.prefix_sum.append(self.cum_sum)
        
        
        
    def pickIndex(self) -> int:
        target = random.random() * self.cum_sum
        for i, item in enumerate(self.prefix_sum):
            if  target <= item:
                return i

