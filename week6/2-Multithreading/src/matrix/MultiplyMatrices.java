

package matrix;

import java.util.concurrent.RecursiveAction;
import jsr166y.ForkJoinPool;
//import jsr166y.
//import java.util.Arrays;

public class MultiplyMatrices extends RecursiveAction{
    
    
    
    
    
    
    
   /* private static final long serialVersionUID = 1L;
    @SuppressWarnings("unused")
    private int[][] matrix1;
    @SuppressWarnings("unused")
    private int[][] matrix2;
   
    
    public MultiplyMatrices(int [][] m, int[][] n){
        this.matrix1 = m;
        this.matrix2 = n;
    }
    
    public static int[][] multiply(int[][] m, int[][] n){
        int[][] result = new int[m[0].length][m[0].length];
        int length = result.length;
        for(int i = 0; i<length; i++){
            for(int j = 0; j<m[i].length; j++){
                for(int k = 0;k<length; k++){
                    result[i][j] += m[i][k]*n[k][j];
                }
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int [][] x ={{1,3,1},
                     {2,1,1},
                     {2,1,1}};
        int [][] y = {{2,2,2},
                      {2,2,2},
                      {2,2,2}};
        int[][] result = multiply(x,y);
        for(int i=0; i<x.length; i++){
          for(int j=0; j<x.length; j++){
              System.out.print(result[i][j]);
          }  
          System.out.println();
            
        }
        //System.out.println(multiply(x,y));
    }**/


    public int[] multiply(int[] m, int[] n, int length){
        int[] result = new int[length];
        
        for(int i=0; i<length; i++){
            result[i] = m[i]*n[i];
        }        
        return result;
    
    }

    @Override
    protected void compute() {
        
        
    }
    

}
