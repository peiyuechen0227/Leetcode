import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;

class Solution {
    boolean[] onPath;
    boolean[] visited;
    List<Integer> postOrder = new ArrayList<>();
    boolean hasCycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (hasCycle) {
            return new int[]{};
        }
        int[] result = new int[numCourses];
        Collections.reverse(postOrder);
        for (int i = 0; i < numCourses; i++) {
            result[i] = postOrder.get(i);
        }
        return result;
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
        for (int next: graph[s]) {
            traverse(graph, next);
        }
        postOrder.add(s);
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] courses = {{1,0}, {0,1}};
        solution.findOrder(2, courses);
    }
}
