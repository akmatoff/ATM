// User actions:
// 1. Insert the card (Enter the card number)
// 2. Enter the code
// 3. Choose amount of cash to extract
// 4. Get money

// ATM machine actions:
// Ask for the card
// Ask the code
// Ask to choose an amount of money to get
// Give money if no mistakes
// Warn if no money in the ATM. 
// Warn if the code is wrong

import java.util.Scanner;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Card> cards = new ArrayList<Card>();
    ATM atm = new ATM(cards, 10000);

    init(cards);
    start(scanner, atm);
    
  }

  static void init(ArrayList<Card> cards) {
    
    Card card1 = new Card("342342", 6800, "4560");
    Card card2 = new Card("324223", 2500, "4680");
    Card card3 = new Card("934857", 3000, "8219");

    cards.add(card1);
    cards.add(card2);
    cards.add(card3);
  }

  static void start(Scanner scanner, ATM atm) {

    System.out.println("========================== ATM =========================== \n");
    
    System.out.println("Enter your card number: ");
    String cardNumInput = scanner.nextLine();

    System.out.println(atm.checkCardNum(cardNumInput));
    
    System.out.println("Enter the security code: ");
    String securityCodeInput = scanner.nextLine();

    System.out.println(atm.checkIfSecurityCodeIsCorrect(cardNumInput, securityCodeInput));

    System.out.println("Enter the amount of money to extract: ");
    int cashExtractAmount = scanner.nextInt();

    atm.cashOut(cashExtractAmount);
  }
}