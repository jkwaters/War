import java.util.HashMap;

public class Card{
  private String suit;
  private int value;



  public Card(){
    suit = "Spades";
    value = 14;
  }

  public Card(String s, int v){
    suit = s;
    value = v;
  }

  public int getRank(){
    return value;
  }

  //@Override
  public int compare(Card other){
    return this.value - other.value;
  }

  @Override
  public final String toString(){
    if(this.value == 11){
      return "J" + suit.charAt(0);
    }else if(this.value == 12){
      return "Q" + suit.charAt(0);
    }else if(this.value == 13){
      return "K" + suit.charAt(0);
    }else if (this.value == 1){
      return "A" + suit.charAt(0);
    }
    return "" + this.value + suit.charAt(0);
  }
}
