public class CodeWordChecker implements StringChecker{
     
    private int minLength = 6; 
    private int maxLength = 20;
    private String forbidden = ""; 
    
    public CodeWordChecker(String except){
          this.forbidden = except; 
    }
    
    public CodeWordChecker(int min, int max, String except){
          this.minLength = min; 
          this.maxLength = max;
          this.forbidden = except; 
    }
    
    public boolean isValid(String str){
         int currentLength = str.length(); 
         for(int i = 0; i<str.length(); i++){
           String currentChar = str.substring(i,i+this.forbidden.length());  
           //System.out.println("Checking: "+currentChar); 
           if(currentChar.equals(this.forbidden)){
             // System.out.println("Contains the forbidden character/word: "+this.forbidden); 
              return false;   
            }   
          }
          
         if(currentLength<=this.minLength) System.out.println("Word is too short"); 
         else if(currentLength>=this.maxLength) System.out.println("Word is too long"); 
         
         return (currentLength>=this.minLength && currentLength <= this.maxLength); 
     }
     
     public static void main (String args[]){
         StringChecker sc1 = new CodeWordChecker(5,8,"$");   
         //Some testing code 
         if(sc1.isValid("Code")) System.out.println("Valid Word");
         else System.out.println("Not Valid"); 
         
         StringChecker sc2 = new CodeWordChecker("pass"); 
         //Some testing code 
         if(sc2.isValid("Mypassport")) System.out.println("Valid Word");
         else System.out.println("Not Valid"); 
     }
}