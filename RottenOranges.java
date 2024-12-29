import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

    public static int orangesRotting(int[][] grid) {
        int minutes = 0;
        Queue<int[]> rottenQueue = new LinkedList<>();
        int freshOrangeCount = 0;
        int rows = grid.length;
        int cols = grid[0].length; 
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if( grid[i][j] == 1){
                    freshOrangeCount++;
                }
                if(grid[i][j] == 2){
                    rottenQueue.offer(new int[]{ i , j});
                }  
            }
        }
        if(freshOrangeCount == 0){
            return 0;
        }
        if(rottenQueue.isEmpty()){
            return -1;
        }
        while (!rottenQueue.isEmpty()) {
            
            int[] current = rottenQueue.poll();
            int row  = current[0];
            int col = current[1];

            
        }
        return minutes;
    }
    // public static int checkFreshWithoutASurrounding(int i, int j, int[][] grid){
    //     int rows = grid.length;
    //     int cols = grid[0].length; 
    //     if( i > 0 && i < rows && j > 0 && j < cols){
    //         if(grid[i - 1][j] == 0 && grid[i+1][j] == 0 && grid[i][j-1] == 0 && grid[i][j+1] ==0){
    //             return -1;
    //         }
    //     }
    //     if( i == 0){ // first row
    //         if( j ==0 ){ 
    //             if(grid[i+1][j] == 0 && grid[i][j+1] ==0){
    //                 return -1;
    //             }
    //         }else if( j == cols -1){
    //             if(grid[i+1][j] == 0 && grid[i][j-1] == 0){
    //                 return -1;
    //             }
    //         }else{
    //             if(grid[i][j-1] == 0 && grid[i][j+1] ==0){
    //                 return -1;
    //             }
    //         }
    //     }
    //     if( j == 0){ // first col
    //         if( i == rows -1){
    //             // if(){
    //             //     return -1;
    //             // }
    //         }else{
    //             if(grid[i][j-1] == 0 && grid[i][j+1] ==0){
    //                 return -1;
    //             }
    //         }
    //     }
        
    // }
    public static void main(String[] args) {
        /* edge cases 1. No rotten oranges in given matrix 
         *            2. No fresh oranges in given matrix
         *            3. No fresh orange is surrounded by rotten orange
        */
        int[][] grid = {{0,0,0},{0,1,0},{0,1,1}};
        //int[][] grid = {{2,1,1},{1,1,0},{0,1,1}};
        System.out.println(orangesRotting(grid));
    }
    
}
