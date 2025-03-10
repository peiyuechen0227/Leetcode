class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        result = []
        path = [0] 
        
        def dfs(graph, x, n):
            if x == n:
                result.append(path.copy())
                return

            for i in graph[x]:
                path.append(i)
                dfs(graph, i, n)
                path.pop()

        dfs(graph, 0, len(graph) - 1)
        return result