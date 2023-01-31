import java.util.ArrayList;
import java.util.Scanner;

public class Blackjack {

    static ArrayList<Integer> playerCards = new ArrayList<>();
    static ArrayList<Integer> dealerCards = new ArrayList<>();

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            // initial cards
            playerCards.add((int) (Math.random() * 10) + 1);
            playerCards.add((int) (Math.random() * 10) + 1);
            dealerCards.add((int) (Math.random() * 10) + 1);
            dealerCards.add((int) (Math.random() * 10) + 1);

            System.out.println("Your cards are: " + playerCards + " and the sum is " + sum(playerCards));
            System.out.println("Dealer's cards are: " + dealerCards.get(0) + " and [hidden]");

            // player turn
            while (sum(playerCards) < 21) {
                System.out.print("Do you want to hit or stand? (H)it or (S)tand): ");
                String playerChoice = sc.nextLine();
                if (playerChoice.equals("h") || playerChoice.equals("H")) {
                    int newCard = (int) (Math.random() * 10) + 1;
                    playerCards.add(newCard);
                    System.out.println("Your cards are now: " + playerCards + " and the sum is " + sum(playerCards));
                } else {
                    break;
                }
            }
        }

        // dealer turn
        while (sum(dealerCards) < 17) {
            int newCard = (int) (Math.random() * 10) + 1;
            dealerCards.add(newCard);
        }

        System.out.println("Dealer's cards are now: " + dealerCards + " and the sum is " + sum(dealerCards));

        int playerSum = sum(playerCards);
        int dealerSum = sum(dealerCards);

        if (playerSum > 21) {
            System.out.println("You busted! You lose.");
        } else if (dealerSum > 21) {
            System.out.println("Dealer busted! You win.");
        } else if (dealerSum > playerSum) {
            System.out.println("Dealer wins.");
        } else if (dealerSum < playerSum) {
            System.out.println("You win!");
        } else {
            System.out.println("It's a tie!");
        }
    }

    static int sum(ArrayList<Integer> cards) {
        int sum = 0;
        for (int card : cards) {
            sum += card;
        }
        return sum;
    }
}