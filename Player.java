import java.util.ArrayDeque;
import java.util.Iterator;

public class Player{
  /* these are the valid ranks and suits (both represented as Strings) */
  /* (they may be useful to you.  You do not need to use them though)  */
  String playerName;
  ArrayDeque<Card> playerHand;


  public Player(String name){
    playerName = name;
    playerHand = new ArrayDeque<Card>();
  }

  /* required methods for all cards to have */
  //public abstract int getRank();
  //public abstract String getSuit();
  
  /* override Object's toString() */
  @Override
  public final String toString(){
    return playerName + " has " + playerHand.size() + " cards.";
  }

  public void printHand(){
    for(Iterator itr = playerHand.iterator();itr.hasNext();){
      System.out.println(itr.next());
    } 
  }

  public void pushLast(Card card){
    playerHand.addLast(card);
  }

  public Card drawCard(){
    return playerHand.pollFirst();
  }
}