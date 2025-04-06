class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        rows = len(grid)
        cols = len(grid[0])
        visited = [[False] * cols for _ in range(rows)]
        max_area = 0

        direction = [[1,0],[0,1],[-1,0],[0,-1]]
        def dfs(grid: List[List[int]], visited: List[List[bool]], i: int, j: int) -> int:
            visited[i][j] = True
            area = 1
            for x, y in direction:
                next_x = i + x
                next_y = j + y
                if next_x < 0 or next_y < 0 or next_x >= len(grid) or next_y >= len(grid[0]):
                    continue
                if not visited[next_x][next_y] and grid[next_x][next_y] == 1:
                    area += dfs(grid, visited, next_x, next_y)

            return area

        for i in range(rows):
            for j in range(cols):
                if not visited[i][j] and grid[i][j] == 1:
                    max_area = max(dfs(grid, visited, i, j), max_area)
        return max_area