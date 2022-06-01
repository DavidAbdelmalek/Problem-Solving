class Solution:
    def decodeString(self, s: str) -> str:
        stack = []
        output=''
        # process input
        prev = s[0]
        for char in s[1:len(s)+1]:
            if char.isnumeric() and prev.isnumeric():
                prev += char
            elif char.isalpha() and prev.isalpha():
                prev += char
            else:
                stack.append(prev)
                prev = char
        stack.append(prev)

        new_stack =[]
        for char in stack:
            if char == ']':
                new_stack= recurs(new_stack[:-1],new_stack[-1])
            else:
                new_stack.append(char)
        return ''.join(new_stack)
            

        
    
def recurs(stack,input_str) -> List:
    if len(stack) == 0:
        return []
    char = stack[-1]
    if char =='[':
        stack.pop()
        return recurs(stack,input_str)
    elif char.isalpha():
        # concatenate
        stack.pop()
        input_str = char+input_str
        return recurs(stack,input_str)
    elif char.isdigit():
        stack.pop()
        stack.append(int(char)* input_str)
        return stack