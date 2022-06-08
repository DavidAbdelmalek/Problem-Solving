class Solution:
    def totalFruit(self, fruits: List[int]) -> int:
        if len(fruits) == 0:
            return 0 
        max_val = 1
        dict_map = {}
        i =0 
        j = 0
        while j < len(fruits):
            if len(dict_map) <= 2:
                dict_map[fruits[j]] = j
            if len(dict_map) > 2:
                min_value = min(list(dict_map.values()))
                i = min_value +1
                target_key = 0
                for keys , vals in dict_map.items():
                    if vals == min_value:
                        target_key = keys
                        break
                dict_map.pop(target_key)
            j += 1
            max_val = max(max_val, j - i)
            
        return max_val