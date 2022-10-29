class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        result = []
        sMap = {}
        index = 0
        flag = 0
        for s in strs:
            originS = s
            s = list(s)
            s.sort()
            sLocate = -1
            try:
                sLocate = sMap[''.join(s)]
                flag = 1
            except:
                sMap[''.join(s)] = index
                index += 1
                tempList = []
                tempList.append(originS)
                result.append(tempList)
            if flag == 1:
                result[sLocate].append(originS)
                flag = 0
        return result
