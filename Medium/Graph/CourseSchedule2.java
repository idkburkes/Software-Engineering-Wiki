import java.util.LinkedList;
import java.util.Queue;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You
 * are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must
 * take course bi first if you want to take course ai.
 * 
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * 
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers,
 * return any of them. If it is impossible to finish all courses, return an empty array.
 * 
 * The solution pattern used is Breadth First Search
 * 
 * 
 */


public class CourseSchedule2 {

    public static void main(String[] args) {

        int[][] prereqs = new int[4][2];
        prereqs[0][0] = 2;
        prereqs[0][1] = 0;

        prereqs[1][0] = 1;
        prereqs[1][1] = 0;

        prereqs[2][0] = 3;
        prereqs[2][1] = 1;

        prereqs[3][0] = 3;
        prereqs[3][1] = 2;
        int[] order = findOrder(4, prereqs);

        for(int i : order) {
            System.out.print(i + " ");
        }
    }

    


    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        //Edge cases
        if(prerequisites == null || numCourses == 0) {
            return new int[0];
        } 

        int[] topologicalOrder = new int[numCourses];
        int[] inDegree = new int[numCourses];
        int coursesCompleted = 0;

        //Determine in-degree of each vertex
        for(int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }

        //Add vertices that have an in-degree of 0 to Queue
        Queue<Integer> Q = new LinkedList<>();
       for(int i = 0; i < inDegree.length; i++) {
           if(inDegree[i] == 0) {
               Q.offer(i);
           }
       }

        //Perform BFS on all vertices that have no more pre-reqs 
       while(!Q.isEmpty()){
         int prereq = Q.poll();
         topologicalOrder[coursesCompleted] = prereq; //Place this prereq at front of toplogical order
         coursesCompleted++;
        //Decrement in-degree of all courses that require this prereq
        for(int i = 0; i < prerequisites.length; i++) {
            if(prerequisites[i][1] == prereq) {
                inDegree[prerequisites[i][0]]--;
                if(inDegree[prerequisites[i][0]] == 0) { //If new in degree is 0 add it to the Queue
                    Q.offer(prerequisites[i][0]);
                }
            }
        }
       }


       //Return topological order if all classes completed
        if(coursesCompleted == numCourses) {
            return topologicalOrder;
        }
        return new int[0];
    }
}