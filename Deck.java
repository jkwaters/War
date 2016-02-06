import java.util.ArrayList;
import java.util.Random;

public class Deck{
  int size, numDecks;
  ArrayList<Card> cards;
  String[] suits = {"Hearts", "Clubs", "Spades", "Diamonds"};
  
  
  public Deck(int n){
    numDecks = n;
    size = n*52;
    cards = new ArrayList<Card>(size);
    spawnCards();
    System.out.println("\n Fresh Deck");
    printDeck(cards);
    
    shuffle(cards);
    System.out.println("\n Shuffled Deck");
    printDeck(cards);
  } 
  
  void printDeck(ArrayList<Card> deck){
    for (int i = 0; i < deck.size(); i ++){
      System.out.print(deck.get(i) + " ");
    }
  }

  void spawnCards(){
    for(int k = 0; k < numDecks; k++){
      for(int i = 0; i<4; i++){
        for(int j = 0; j<13; j++){
          cards.add(new Card(suits[i],j+1));
        }
      }
    }
  }
  
  void shuffle(ArrayList<Card> deck){
    boolean shuffled = false;
    Card lastCard = deck.get(deck.size()-1);
    Random rand = new Random();
    int i = 0;
    while(!shuffled){
      if(deck.get(0) == lastCard){shuffled = true;}
      int x = rand.nextInt(deck.size())+1;
      deck.add(x,deck.get(0));
      deck.remove(0);
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