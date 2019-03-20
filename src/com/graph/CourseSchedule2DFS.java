package com.graph;
import java.util.*;
//https://leetcode.com/problems/course-schedule-ii/
class CourseSchedule2DFS {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] status = new int[numCourses];// 0 new, 1 visiting, 2 visited
        Stack<Integer> res = new Stack<>();
        List<List<Integer>> graph = buildGraph(prerequisites, numCourses);
        for(int i = 0; i < numCourses; i++){
            if(dfs(res, graph, i, status)) return new int[]{};
        }
        return toArray(res);
    }

    private List<List<Integer>> buildGraph(int[][] prerequisites, int numCourses){
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            g.add(new ArrayList<Integer>());
        }
        for(int[] pair : prerequisites){
            g.get(pair[1]).add(pair[0]);
        }
        return g;
    }

    private boolean dfs(Stack<Integer> res, List<List<Integer>> g, int i, int[] status){
        if(status[i] == 1) return true;
        if(status[i] == 2) return false;
        status[i] = 1;
        for(Integer node : g.get(i)){
            if(dfs(res, g, node, status)) return true;
        }
        status[i] = 2;
        res.push(i);
        return false;
    }

    private int[] toArray(Stack<Integer> stack){
        int[] arr = new int[stack.size()];
        int size = stack.size();
        for(int i = 0; i < size; i++){
            arr[i] = stack.pop();
            System.out.println(arr[i]);
        }

        return arr;
    }
}