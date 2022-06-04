# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
        self.visited = False
class Solution:
    
    def findLeaves(self, root: 'TreeNode') -> 'List[List[int]]':
        res = []
        def dfs(root):
            if not root:
                return -1
            height = max(dfs(root.left), dfs(root.right)) + 1
            if height >= len(res):
                res.append([])
            res[height].append(root.val)
            return height
        dfs(root)
        return res
    """
    def findLeaves(self, root: Optional[TreeNode]) -> List[List[int]]:
        # define bool visited
        print(root)
        self.visited =[False for i in range(101)]
#        print(self.recurs(root,0))        
        print('e'*100)
        
    #def recurs(self,root,i):
        
    def recurs(self,root,i):
        left_ind = 2*i + 1 
        right_ind = 2*i + 2
        print(root,i, self.visited[i])
        print('o'*100)
        print(root.val)
        
        if root.val == None or self.visited[i]:
            print('first condition')
            return []
        elif(root.left == None and root.right == None or
             (self.visited[left_ind] and self.visited[right_ind])):
            self.visited[i]= True
            print(f'condition 2 {(self.visited[left_ind] and self.visited[right_ind])}')
            print('-'*20)
            print(root.val)
            return [root.val]
        
        left_list  = self.recurs(root.left,left_ind)
        right_list = self.recurs(root.right,right_ind)
        print(left_list)
        print(right_list)
        
        do_list = left_list + right_list 
        all_list = [do_list]
        
        return all_list.append(self.recurs(root,i))
    """