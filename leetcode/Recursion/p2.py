# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def isPalindrome(self, head: Optional[ListNode]) -> bool:
        temp = []
        while head != None:
            temp.append(head.val)
            head = head.next
        start = 0
        end = len(temp) -1
        while start < end:
            if temp[start] != temp[end]:
                return False
            start +=1 
            end -= 1 

        return True