import java.util.LinkedList;
import java.util.Queue;



/**
 * 
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses - 1. You are given an array prerequisites where prerequisites[i] =
 * [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *      For example, the pair [0, 1], indicates that to take course 0 you have to first
 *      take course 1.
 * Return true if you can finish all courses. Otherwise, return false.
 * 
 * The solution pattern used is Breadth-First Search. TODO: add explanation
 * 
 * 
 */
public class CourseSchedule {


public static void main(String[] args) {


    int numCourses = 2;
    int[][]  prereq = new int[1][2];
    prereq[0][0] = 1;
    prereq[0][1] = 0;

    System.out.print(canFinish(numCourses, prereq));
}



public static boolean canFinish(int numCourses, int[][] prerequisites) {
    //base case
    if(numCourses == 0 || prerequisites.length == 0) {
        return true;
    }

    //Create array that stores in-degrees for each vertex 
    int[] inDegree = new int[numCourses];

    //Create queue that stores all vertices w/ all pre-reqs satified (in degree 0)
    Queue<Integer> Q = new LinkedList<>();

    //determine in degree of all vertices
    //for each prereq, increment in-degree of vertex a  -> [a,b] 
    for(int i = 0; i < prerequisites.length; i++) {
        inDegree[prerequisites[i][0]]++;
    }

    //for each vertex if in degree is 0 then it can be completed <- add to queue
    for(int i = 0; i < inDegree.length; i++) {
        if(inDegree[i] == 0){
            Q.offer(i);
        }
    }

    //Set initial reachable vertices equal to vertices with no pre-reqs
    int verticesReached = Q.size();

    while(!Q.isEmpty()) { //for each prereq in Q,
        int prereq = Q.remove();
        // if prereq is required for any vertex v in G, decrement in-degree of v
        for(int i = 0; i < prerequisites.length; i++) {
            if(prereq == prerequisites[i][1]){
                inDegree[prerequisites[i][0]]--;
                    //if in degree of v is 0, add it to queue (all pre-reqs satisfied). increment vertices reached
                    if(inDegree[prerequisites[i][0]] == 0) {
                        Q.offer(prerequisites[i][0]);
                        verticesReached++;
                }   
            }
        }
    }

  //if vertices reached is the same as the size of graph then all courses can be completed 
return verticesReached == numCourses;
}

}