import java.util.ArrayList;
import java.util.Random;

public class Deck{
  int size, numDecks;
  ArrayList<Card> cards;
  String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
  String[] value = {"Ace" , "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
  
  
  public Deck(int n){
    int i = 0;
    numDecks = n;
    size = n*52;
    cards = new ArrayList<Card>(size);
    spawnCards();
    while(i<100){
      shuffle();
      i++;
    }
  } 
  
  void spawnCards(){
    for(int k = 0; k < numDecks; k++){
      for(int i = 0; i<4; i++){
        for(int j = 0; j<13; j++){
          cards.add(new Card(suits[i],value[j]));
        }
      }
    }
  }
  
  void shuffle(){
    Random rand = new Random();
    for (int i = 0; i<size; i++){
      int x = rand.nextInt(51);
      Card hold = cards.get(x);
      cards.set(x, cards.get(i));
      cards.set(i, hold);
    }
  }

  public int getDeckSize(){
    return cards.size();
  }

  @Override
  public final String toString(){
    String str = "";
    for (int i=0; i<size; i++){
      str += cards.get(i).toString() + "\n";
    }
    return str;
  }
  
}