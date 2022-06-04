# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        
        def merge(list1,list2):
            if list2 == None:
                return list1
            elif list1 == None:
                return list2
            if list1.val < list2.val:
                head = ListNode(list1.val)
                head.next = merge(list1.next,list2)
            else:
                head = ListNode(list2.val)
                head.next = merge(list1,list2.next)
        
            return head
        return merge(list1,list2)        