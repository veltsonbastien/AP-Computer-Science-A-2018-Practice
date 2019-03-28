import java.util.*; 

public class ArrayTester{
  
   /** Precondition: c is a valid column index 
    *  Postcondition: arr2D remains unchanged 
    */ 
    
   public static int[] getColumn (int [][] arr2D, int c){
      /* to be implemented in part (a) */ 
      int[] result = new int [arr2D.length];
      int arrayCounter = 0; 
      
      for(int i = 0; i<arr2D.length; i++){
           for(int j = 0; j<arr2D[i].length; j++){
               if(j==c){  
                   result[arrayCounter] = arr2D[i][j];   
                   arrayCounter++; 
                }
            }
        }
      
      //System.out.println(Arrays.toString(result)); 
      return result;
    }
    
    /**Precondition: arr1 and arr2 are the same length
     * Postcondition: they are both unchanged 
     */
    
    public static boolean hasAllValues(int[] arr1, int[] arr2){
          /* implementation not shown */ 
          for(int i: arr1){
            boolean smallCheck = false;
            for(int j: arr2){
              if(i==j){ 
              smallCheck = true; 
              break; 
             }
            }
            if(!smallCheck) return false; 
          }
          return true; 
    }
    
    public static boolean containsDuplicates(int[] arr){
        /*implementation not shown */ 
        boolean smallCheck = false; 
        
        for(int i = 0; i<arr.length-1; i++){
           for(int j = i+1; j<arr.length; j++){
              if(arr[i] == arr[j]) return true;    
            }
        }
        
        return smallCheck; 
    }
    
    /** Precondition: square has an equal amount of rows and columns 
     *                square has at least one row 
     */
    public static boolean isLatin(int [][] square){
       /* to be implemented in part (b) */     
       boolean checkRows = false;
       boolean checkCols = false; 
       
       if(!containsDuplicates(square[0])){
         System.out.println("No duplicates found in: "+Arrays.toString(square[0])); 
         for(int i = 0; i<square.length; i++){
           for(int j = 0; j<square[i].length; j++){
               if(hasAllValues(square[0], getColumn(square,j))){
                  checkCols = true;   
                } else{
                 return false;    
                }
            }
         }
         for(int k = 1; k<square.length; k++){
          if(hasAllValues(square[0],square[k])){
              checkRows = true; 
           } else{
             return false;   
            }
        }
       }
   
       return (checkRows && checkCols) ; 
    }
    
    
    public static void main (String args[]){
       int[][] arr2D = { {0,1,2}, 
                         {3,4,5}, 
                         {6,7,8},
                         {9,5,3} }; 
                       
       int[] result = ArrayTester.getColumn(arr2D, 1);  
       
       int[][] arrLatin = { {1,2,3},
                            {2,3,1},
                            {3,1,2} };
                            
       int[][] arrNotLatin = { {3,2,1},
                               {2,3,1},
                               {1,1,2} };
                               
       if(ArrayTester.isLatin(arrLatin))System.out.println("arrLatin is shown as a latin, test passed"); 
       else System.out.println("arrLatin is not shown as a latin, test failed");
       
       if(!ArrayTester.isLatin(arrNotLatin))System.out.println("arrLatin is not shown as a latin, test passed"); 
       else System.out.println("arrNotLatin is shown as a latin, test failed");
       
    }
    
}