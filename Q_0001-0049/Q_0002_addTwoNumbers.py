# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        result = ListNode()
        nowListNode = ListNode()
        nowListNode = result
        addFlag = 0
        num = 0
        while True:
            if addFlag == 1:
                num = l1.val + l2.val + 1            
                if num >= 10:
                    nowListNode.val = num-10
                    addFlag = 1
                else:
                    nowListNode.val = num
                    addFlag = 0
            else:
                num = l1.val + l2.val
                if num >= 10:
                    nowListNode.val = num-10
                    addFlag = 1
                else:
                    nowListNode.val = num
            
            
            if l1.next != None:
                if l2.next != None:
                    l1 = l1.next
                    l2 = l2.next
                else:
                    l2.val = 0
                    l1 = l1.next
            elif l2.next != None:
                l1.val = 0
                l2 = l2.next
            else:
                if addFlag == 1:
                    nowListNode.next = ListNode()
                    nowListNode = nowListNode.next
                    nowListNode.val = 1
                return result
            nowListNode.next = ListNode()
            nowListNode = nowListNode.next
            
