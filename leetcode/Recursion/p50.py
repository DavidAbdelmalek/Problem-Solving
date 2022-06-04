import math
class Solution:
    def __init__(self):
        self.mem={}
    def myPow(self, x: float, n: int) -> float:
        
    
        def yourPow( x: float, n: int) -> float:
            if n == 0:
                return 1
            elif n in self.mem.keys():
                return self.mem[int(n)]
            if n < 0:
                if n%2 ==1:
                    half_n = int(n/2)
                    self.mem[int(n)] = (1/x) * yourPow(x,half_n) * yourPow(x,half_n)
                else:
                    half_n = int(n/2)
                    self.mem[n] =  yourPow(x,half_n) * yourPow(x,half_n)
            elif n%2 ==1:
                half_n = int(n/2)
                self.mem[n] = x * yourPow(x,half_n) * yourPow(x,half_n)
            else:
                half_n = int(n/2)
                self.mem[n] =  yourPow(x,half_n) * yourPow(x,half_n)
            return self.mem[n]
        
        return yourPow(x,n)