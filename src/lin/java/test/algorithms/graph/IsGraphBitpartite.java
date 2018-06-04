package lin.java.test.algorithms.graph;

public class IsGraphBitpartite {

    public static void main(String[] args) {

    }
    class Solution {
        public boolean isBipartite(int[][] graph) {
            if(graph == null || graph.length == 0){
                return false;
            }
            int[] colors = new int[graph.length];
            for(int i = 0; i < graph.length; i++){
                if(colors[i] == 0 && !travel(graph,1,i,colors)){
                    return false;
                }
            }
            return true;
        }

        public boolean travel(int[][] graph,int color,int index, int[] colors){
            if(colors[index] != 0) return colors[index] == color;
            colors[index] = color;
            for(int next :graph[index]){
                if(!travel(graph,color * (-1), next,colors)){
                    return false;
                }
            }
            return true;
        }
    }
}
