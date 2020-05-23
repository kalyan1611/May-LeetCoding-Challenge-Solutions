class Solution:
    def intervalIntersection(self, A: List[List[int]], B: List[List[int]]) -> List[List[int]]:
        ans = []
        index_a = 0
        index_b = 0
        len_a = len(A)
        len_b = len(B)
        while (index_a < len_a and index_b < len_b):
            start = max(A[index_a][0], B[index_b][0])
            end = min(A[index_a][1], B[index_b][1])
            if (start <= end):
                ans.append([start, end])
            if (A[index_a][1] <= end):
                index_a += 1
            if (B[index_b][1] <= end):
                index_b += 1
        return ans
               
