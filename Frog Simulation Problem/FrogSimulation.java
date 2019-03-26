import java.util.*; 
import java.lang.Math; 

public class FrogSimulation
{
 /** Distance, in inches, from the starting position to the goal. */
 private int goalDistance; 
 
 /** Maximum number of hops allowed to reach the goal */ 
 private int maxHops; 
 
 ArrayList<Integer> testArray = new ArrayList<Integer>(); 
 
 /**Precondition: dist > 0; numHops >0 */ 
  
 public FrogSimulation(int dist, int numHops){
    goalDistance = dist; 
    maxHops = numHops; 
    
    //i added this in for the sake of testing, not part of actual answer
    testArray.add(5);
    testArray.add(7);
    testArray.add(-2);
    testArray.add(8);
    testArray.add(6);
  }
  
  /** Returns an integer representing the distance, in inches, to be move
   * when the frog hops. 
   */
  private int hopDistance()
  {
   return testArray.get(0);
  }
  
  /** Simulates a frog attempting to reach the goal as described in
   * part (a). Returns true if the frog successfully reached or passed 
   * the goal during the simulation; false otherwise
   */
  
  public boolean simulate()
  {
   /* to be implemented in part (a) */
   int frogPosition = 0; 
   for(int i = 0; i<this.maxHops; i++){ 
     frogPosition+= this.hopDistance(); 
     //System.out.println("Current Position: "+frogPosition); 
     testArray.remove(0); 
     if(frogPosition == goalDistance){
        //System.out.println("Reached the Goal!"); 
        return true;   
      }
   }
   //System.out.println("Didn't reach the goal..."); 
   return false;
  }
  
  /** Runs num simulations and returns the proportion of simulations
   * in which the frog successfully reached or passed the goal
   * Precondition: num > 0
   */
  
  public double runSimulations(int num){
     /* to be implemented in part (b) */ 
     int totalTrue = 0; 
     for(int i = 0; i<num; i++){
       if(this.simulate()){
          totalTrue++;       
        }
     }
     //System.out.println("Passed Simulations: "+(totalTrue/num)*1.0);
     return (totalTrue/num)*1.0; 
  }
  
  public static void main (String args[]){
    FrogSimulation sim = new FrogSimulation(24,5);     
   // System.out.println("Testing the Game: "); 
   // System.out.println("Current Frog Stats:\n"+
   //                    "Goal Distance: "+sim.goalDistance+"\n"+
   //                    "Max Hops: "+sim.maxHops+"\n"+
   //                    "****************************"
   //                    );
    //Begin Everything 
    sim.simulate(); 
  }
  
 
}
