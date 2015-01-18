import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Table{
	/* these are the valid ranks and suits (both represented as Strings) */
	/* (they may be useful to you.  You do not need to use them though)  */
	
	ArrayList<Card> redPlay = new ArrayList<>();
	ArrayList<Card> bluePlay = new ArrayList<>();
	int turns, rWin, bWin, war = 0;


	public Table(){
		//Create deck, cards, and shuffle deck
		Deck deck = new Deck(1);

		//Create Players

		Player blue = new Player("blue");
		Player red = new Player("red");

		//Deal to Players
		deal(deck, red, blue);
		deck = null;

		//System.out.println(red);
		//System.out.println(blue);

		//System.out.println("\nRed hand");
		//red.printHand();
		//System.out.println("\nBlue hand");
		//blue.printHand();

		System.out.println("\nGAME ON!!!");
		play(red,blue);

		System.out.println("\n\n\nGAME STATS\n----------------");
		System.out.println("turns:      " + turns);
		System.out.println("red wins:   " + rWin);
		System.out.println("blue wins:  " + bWin);
		System.out.println("WARs:      " + war);

		//System.out.println("\nRed hand");
		//red.printHand();
		//System.out.println("\nBlue hand");
		//blue.printHand();
	}


	void deal(Deck deck, Player red, Player blue){
		for (int i = 0; i < deck.getDeckSize(); i+=2){
			red.pushLast(deck.cards.get(i));
			blue.pushLast(deck.cards.get(i+1));
		}
	}

	void play(Player red, Player blue){
		while(true){
			if(red.playerHand.size() == 0 || blue.playerHand.size() == 0 || turns >= 10000) break;

			redPlay.add(red.drawCard());
			bluePlay.add(blue.drawCard());
			System.out.println("\nRED  " + redPlay.get(0));
			System.out.println("BLUE " + bluePlay.get(0));

			if (redPlay.get(0).getRank() - bluePlay.get(0).getRank() > 0){ // red win
				returnWinToDeck(red);
				rWin++;
				System.out.println("red win");
			}else if(redPlay.get(0).getRank() - bluePlay.get(0).getRank() < 0){ // blue win
				returnWinToDeck(blue);
				bWin++;
				System.out.println("blue win");
			}else{
				System.out.println("WAR!");
				thisMeansWar(red, blue);
				war++;
			}
				
				/*                                      //Returns cards back to deck
				red.pushLast((Card)redPlay.get(0));
				blue.pushLast((Card)bluePlay.get(0));
				redPlay.clear();
				bluePlay.clear();
				draw++;
				*/
			
			turns++;
		}
	}

	int findHighest(Card[] c){
		Card highest = null;
		for(int i = 0; i<3; i++){
			if(highest == null){
				highest = c[i];
			}else{
				if(c[i].cardRank > highest.cardRank){
					highest = c[i];
				}
			}
		}
		return highest.getRank();
	}

	void returnWinToDeck(Player p){
		Random rand = new Random();
		Boolean TF = rand.nextBoolean();
    
    if (TF == true){
    	p.pushLast((Card)redPlay.get(0));
			p.pushLast((Card)bluePlay.get(0));
    }else{
    	p.pushLast((Card)bluePlay.get(0));   
    	p.pushLast((Card)redPlay.get(0));
    }
		
		
		redPlay.clear();
		bluePlay.clear();
	}

	void thisMeansWar(Player red, Player blue){
		while(true){
			for (int i = 0; i <= 2; i++){
				redPlay.add(red.drawCard());
				bluePlay.add(blue.drawCard());
			}
			int j = redPlay.size();
			Card[] warRed = {redPlay.get(j-1),redPlay.get(j-2),redPlay.get(j-3)};
			Card[] warBlue = {bluePlay.get(j-1),bluePlay.get(j-2),bluePlay.get(j-3)};
			
			if(findHighest(warRed) - findHighest(warBlue) > 0){
				returnWinToDeck(red);
				rWin++;
				System.out.println("red win WAR");
				break;
			}else if(findHighest(warRed) - findHighest(warBlue) < 0){
				returnWinToDeck(red);
				bWin++;
				System.out.println("blue win WAR");
				break;
			}else{
				thisMeansWar(red, blue);
			}
		}
	}
}

