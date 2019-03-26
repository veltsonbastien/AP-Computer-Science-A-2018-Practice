import java.util.*; 

public class WordPairList{
  
    /* The list of word pairs, initialized by a constructor */
    private ArrayList<WordPair> allPairs = new ArrayList<WordPair>(); 
    
    /** Construct a WordPairList object as described in part (a)
     * Precondition: words.length > 2 
     */
    
    public WordPairList(String[] words){
         /* to be implemented in part a */ 
         for(int i = 0; i<words.length-1; i++){
             String firstWords = words[i]; 
             String secondWords = ""; 
             for(int j = i+1; j<words.length; j++){
               secondWords = words[j];   
               allPairs.add(new WordPair(firstWords, secondWords)); 
             }
         }
         
         //print them out to test it 
         //for(WordPair w: allPairs){
         //   System.out.println("("+w.getFirst()+","+w.getSecond()+")"); 
         // }
    }
    
    /** Returns the number of matches as described in part (b)
     * 
     */
    
    public int numMatches(){
      /* to be implemented in part b */   
      int matchCounter = 0; 
      
      for(WordPair w: allPairs){
        if(w.getFirst().equals(w.getSecond())){
          matchCounter++;    
        }
      }
      //System.out.println(matchCounter);  
      return matchCounter; 
    }
    
    public static void main (String args[]){
      String[] wordNums = {"the","red","fox","the","red"}; 
      WordPairList exampleOne = new WordPairList(wordNums); 
      exampleOne.numMatches();
    }
   
}