import java.util.*; 

public class Bulgarian{
   
    private int numofPiles;
    private int totalCards;  
    private LinkedList<Pile> thePiles;
    private String triangleNumKey; 

    public Bulgarian(){
        System.out.println("Normally Bulgarian, solitaire is played with 45 cards, but any triangular number of cards will work. How many cards do you wnat to play with?");
        Scanner a = new Scanner(System.in);
        boolean notGood = true;
        int theint = 45;
        while(notGood){
            try{
                theint = Integer.parseInt(a.next());
                int testnum = 8*theint+1;
                double square = Math.sqrt(testnum);
                int floorSquare = (int) Math.floor(square);
                if (square -floorSquare != 0){
                    throw new NumberFormatException();
                }
                else{
                    totalCards = theint;
                }

                notGood = false; 
            }
            catch(NumberFormatException e){
                System.out.println("Please enter a triangular number.");
                notGood  = true;
            }    
        }
        totalCards = theint; 
        triangleNumKey = makeAnswer();
        numofPiles = (int)((Math.random()*(totalCards/2))+1);
        System.out.println("Number of Piles = " +numofPiles);
        thePiles = new LinkedList<Pile>();
        makePiles(totalCards-(numofPiles-1), totalCards, 1);
       
    }

   private void makePiles(int max, int cardsLeft, int iteration){
        if (iteration <= numofPiles){
           // System.out.println("Max = "+ max +" cards left = " + cardsLeft + " iteration = " + iteration);
                Pile a = new Pile(max);
                //System.out.println("Pile " + iteration +" initial size = " + a.getNumofCards() );
                if((iteration == numofPiles) && (cardsLeft - a.getNumofCards() != 0)){
                    int cardstoAdd = cardsLeft - a.getNumofCards();
                    a.addToPile(cardstoAdd);
                }
                System.out.println("Pile " + iteration +", size = " + a.getNumofCards());
                System.out.println();
                thePiles.add(a);
                cardsLeft  -= a.getNumofCards();
                iteration += 1; 
                max = cardsLeft-(numofPiles-iteration);
                makePiles(max, cardsLeft, iteration);
                
        }   
    }
    
 
    private String makeAnswer(){
        String answer = "";
        int add = 1; 
        int sum = 0;
        while(sum < totalCards){
            sum+= add; 
            answer += Integer.toString(add);
            add++;
        }
        return answer; 
    }

    private void round(){
        int cardstoAdd = 0;
        Iterator<Pile> throughPiles = thePiles.iterator();
        while (throughPiles.hasNext()){
            Pile pileA = throughPiles.next();
            pileA.removeCard();
            if (pileA.isEmpty()){
                throughPiles.remove();
            }
            cardstoAdd += 1;
        }
        Pile newPile = new Pile();
        newPile.addToPile(cardstoAdd);
        thePiles.add(newPile);
    }

    public void play(){
        boolean solitaire = false;
        int numofRounds = 0;
        int thenumCheck = triangleNumKey.length();
        while (solitaire == false){
            if(thePiles.size() == thenumCheck && isSolitaire()){
                    solitaire = true; 
                    //return; 
            }
            
            else{
                this.round();
                System.out.println("Piles:");
                Iterator<Pile> throughPiles = thePiles.iterator();
                while (throughPiles.hasNext()){
                    Pile pileA = throughPiles.next();
                    System.out.println(pileA.toString());
                }
                numofRounds++; 
            }
        }
        System.out.println("Solitaire!");
        System.out.println("Total Number of Rounds = " + numofRounds);
    }
    
    private boolean isSolitaire(){
        boolean returnval = false;
        Collections.sort(thePiles);
        Iterator<Pile> pilesIt = thePiles.iterator();
        String triangle = "";
        while(pilesIt.hasNext()){
            Pile b = pilesIt.next();
            triangle += Integer.toString(b.getNumofCards());
        }
        if(triangle.equals(triangleNumKey)){
            returnval = true;
        }
        return returnval;
    } 

    
    public static void main(String[] args){
        Bulgarian theGame = new Bulgarian();
        theGame.play();
        
        
    }
}
