public class SudukoSolver {
    static boolean isSafe(int [][] sudokuGrid, int row,int col,int num){
        // row
        for(int i=0;i<9;i++){
            if(sudokuGrid[row][i]==num) return false;
        }
        //col
        for(int i=0;i<9;i++){
            if(sudokuGrid[i][col]==num) return false;
        }
        int i=row/3*3;
        int j=col/3*3;
        for(int k=i;k<i+3;k++){
            for(int l=j;l<j+3;l++){
                if(sudokuGrid[k][l]==num) return false;
            }
        }
        return true;
    }
   static boolean helper(int[][] sudokuGrid, int row, int col) {
       if(row==9){
           return true;
       }
       if(col==9){
            return helper(sudokuGrid,row+1,0);
       }
       else if(sudokuGrid[row][col]!=0){
             return helper(sudokuGrid,row,col+1);
       }
       else{
           for(int i=1;i<=9;i++){
               if(isSafe(sudokuGrid,row,col,i)){
                   sudokuGrid[row][col]=i;
                     if (helper(sudokuGrid,row,col+1)){
                         return true;
                     };

                   sudokuGrid[row][col]=0;
               }
           }
       }
       return false;
    }
      static void printSudoko(int[][] sudokuGrid) {
         for(int i=0;i<9;i++){
             for(int j=0;j<9;j++){
                 System.out.print(sudokuGrid[i][j]);
             }
             System.out.println();
         }
      }
    public static void main(String[] args) {
       int [][] sudoku_grid = {
               {5, 3, 0, 0, 7, 0, 0, 0, 0},
               {6, 0, 0, 1, 9, 5, 0, 0, 0},
               {0, 9, 8, 0, 0, 0, 0, 6, 0},
               {8, 0, 0, 0, 6, 0, 0, 0, 3},
               {4, 0, 0, 8, 8, 3, 0, 0, 1},
               {7, 0, 0, 0, 2, 0, 0, 0, 6},
               {0, 6, 0, 0, 0, 0, 2, 8, 0},
               {0, 0, 0, 4, 1, 9, 0, 0, 5},
               {0, 0, 0, 0, 8, 0, 0, 7, 9}
};
      boolean ans= helper(sudoku_grid,0,0);
      if(ans){
          System.out.println("sudoku exist");
          printSudoko(sudoku_grid);
      }else{
          System.out.println("sudoku does't exist");
      }


    }


}
