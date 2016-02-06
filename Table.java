import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;


public class Table{
	/* these are the valid ranks and suits (both represented as Strings) */
	/* (they may be useful to you.  You do not need to use them though)  */

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

			red.drawCard();
			blue.drawCard();
			System.out.print("\nRED  ");
			red.printPlay();
			System.out.print("\nBLUE ");
			blue.printPlay();

			if (red.lastPlay() > blue.lastPlay()){ // red win
				returnWinToDeck(red,blue);
				rWin++;
				System.out.println("red win");
			}else if(red.lastPlay() < blue.lastPlay()){ // blue win
				returnWinToDeck(blue,red);
				bWin++;
				System.out.println("blue win");
			}else{
				System.out.println("WAR!");
				thisMeansWar(red, blue);
				war++;
			}
			turns++;
		}
	}

	int findHighest(Card[] c){
		Card highest = null;
		for(int i = 0; i < c.length; i++){
			if(highest == null){
				highest = c[i];
			}else{
				if(c[i].getRank() > highest.getRank()){
					highest = c[i];
				}
			}
		}
		return highest.getRank();
	}

	void returnWinToDeck(Player w, Player l){
		w.returnPlayToHand();
		while(l.playSize() > 0){
			w.pushLast(l.giveCard());
		}
	}

	void thisMeansWar(Player red, Player blue){
		int warBet = (Math.min(red.handSize(), blue.handSize()) < 3) ? Math.min(red.handSize(), blue.handSize()) : 3;

		if (warBet == 0){
			if (blue.handSize() == 0){
				returnWinToDeck(red,blue);
				rWin++;
				System.out.println("red win WAR due to blue running out of cards.");
				return;
			}
			if (red.handSize() == 0){
				returnWinToDeck(blue,red);
				bWin++;
				System.out.println("blue win WAR due to red running out of cards.");
				return;
			}
		}

		for (int i = 0; i < warBet; i++){
			red.drawCard();
			blue.drawCard();
		}

		System.out.println("red play");
		red.printPlay();
		System.out.println("\nblue play");
		blue.printPlay();
		System.out.println();

		if(red.lastPlay() > blue.lastPlay()){
			returnWinToDeck(red,blue);
			rWin++;
			System.out.println("red win WAR");
		}else if(red.lastPlay() < blue.lastPlay()){
			returnWinToDeck(blue,red);
			bWin++;
			System.out.println("blue win WAR");
		}else{
			System.out.println("WAR!");
			thisMeansWar(red, blue);
		}
	}
}

