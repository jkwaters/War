public class Card{
  String suit;
  String value;
  int cardRank;
  
  public Card(){
    suit = "Spades";
    value = "Ace";
    cardRank = 14;
  }
  public Card(String s, String v){
    suit = s;
    value = v;
    if (value == "Ace"){
      this.cardRank = 14;
    }else if (value == "Two"){
      this.cardRank = 2;
    }else if (value == "Three"){
      this.cardRank = 3;
    }else if (value == "Four"){
      this.cardRank = 4;
    }else if (value == "Five"){
      this.cardRank = 5;
    }else if (value == "Six"){
      this.cardRank = 6;
    }else if (value == "Seven"){
      this.cardRank = 7;
    }else if (value == "Eight"){
      this.cardRank = 8;
    }else if (value == "Nine"){
      this.cardRank = 9;
    }else if (value == "Ten"){
      this.cardRank = 10;
    }else if (value == "Jack"){
      this.cardRank = 11;
    }else if (value == "Queen"){
      this.cardRank = 12;
    }else if (value == "King"){
      this.cardRank = 13;
    }
  }
  
  public int getRank(){
    return cardRank;
  }
  
  //@Override
  public int compare(Card other){
    if(this.cardRank < other.cardRank){
      return -1;
    }else if(this.cardRank > other.cardRank){
      return 1;
    }else if(this.cardRank == other.cardRank){
      return 0;
    }
    return -1;
  }
  
  @Override
  public final String toString(){
    if(this.cardRank == 11){
      return "J" + suit.charAt(0);
    }else if(this.cardRank == 12){
      return "Q" + suit.charAt(0);
    }else if(this.cardRank == 13){
      return "K" + suit.charAt(0);
    }else if (this.cardRank == 14){
      return "A" + suit.charAt(0);
    }
    return "" + this.cardRank + suit.charAt(0);
  }
}