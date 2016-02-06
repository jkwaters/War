import java.util.ArrayDeque;
import java.util.Iterator;

public class Player{
  /* these are the valid ranks and suits (both represented as Strings) */
  /* (they may be useful to you.  You do not need to use them though)  */
  String playerName;
  ArrayDeque<Card> playerHand;
  ArrayDeque<Card> playerPlay;

  public Player(String name){
    playerName = name;
    playerHand = new ArrayDeque<Card>();
    playerPlay = new ArrayDeque<Card>();
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
      System.out.print(itr.next() + " ");
    }
  }

  public void printPlay(){
    for(Iterator itr = playerPlay.iterator();itr.hasNext();){
      System.out.print(itr.next() + " ");
    }
  }

  public void pushLast(Card card){
    playerHand.addLast(card);
  }

  public void drawCard(){
    playerPlay.addLast(playerHand.pollFirst());
  }

  public Card giveCard(){
    return playerPlay.pollFirst();
  }

  public void returnPlayToHand(){
    while (playerPlay.size() > 0){
      playerHand.addLast(playerPlay.pollFirst());
    }
  }

  public int handSize(){
    return playerHand.size();
  }

  public int playSize(){
    return playerPlay.size();
  }

  public int lastPlay(){
    return playerPlay.peekLast().getRank();
  }

}
