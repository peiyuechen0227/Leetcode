class Solution {
    boolean[] visited;
    boolean[] onPath;
    boolean hasCycle;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);

        visited = new boolean[numCourses];
        onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        return !hasCycle;
    }

    public void traverse(List<Integer>[] graph, int s) {
        if (hasCycle) {
            return;
        }
        if (onPath[s]) {
            hasCycle = true;
            return;
        }
        if (visited[s]) {
            return;
        }
        visited[s] = true;
        onPath[s] = true;
        for (int neighbor: graph[s]) {
            traverse(graph, neighbor);
        }
        onPath[s] = false;
    }

    public List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] course: prerequisites) {
            int from = course[1];
            int to = course[0];
            graph[from].add(to);
        }

        return graph;
    }
}
