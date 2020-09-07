import java.util.*;

public class Pile implements Comparable<Pile>{
        private int numofCards;

        public Pile(int i){
            numofCards = (int) ((Math.random()*i)+1); 
            //System.out.println(numofCards);
        }
    
        public Pile(){
            numofCards = 0; 
        }

        public void removeCard(){
            this.numofCards--;
        }

        public boolean isEmpty(){
            if (this.numofCards == 0)
                return true; 
            else
                return false; 
        }
    
        public int getNumofCards(){
            return this.numofCards;
        }
    
        public void addToPile(int addAmount){
            numofCards += addAmount;
        }

        public String toString(){
            return Integer.toString(this.numofCards);
        }
        
        public int compareTo(Pile other){
            int returnval = 0;
            if(this.getNumofCards() < other.getNumofCards()){
                returnval = -1; 
            }
            if(this.getNumofCards() > other.getNumofCards()){
                returnval = 1;
            }
            return returnval; 
        }
    
    public static void main (String args[]){
        Pile pile = new Pile(5);
    }
}

