import java.util.ArrayList;

class ATM {
  ArrayList<Card> cards;
  int balance;
  boolean error = false;
  int currentCard = 0;

  ATM(ArrayList<Card> cards, int balance) {
    this.balance = balance;
    this.cards = cards;
  }

  void checkCardNum(String cardNum) throws Error {
    if (cardNum.length() != 6 || !checkIfCardNumExists(cardNum)) {
      error = true;
      throw new Error("Wrong card number");
    }

 }

  boolean checkIfCardNumExists(String cardNum) {

    for (int i = 0; i <= cards.size(); i++) {
      if (cards.get(i).getCardNum().equals(cardNum)) {
        return true;
      }
    }

    return false;
  }

  void checkIfSecurityCodeIsCorrect(String cardNum, String securityCode) throws Error {
    
    boolean found = false;

    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).getSecurityCode().equals(securityCode) && cards.get(i).getCardNum().equals(cardNum)) {
        currentCard = i;
        found = true;
        break;
      }
    }

    if (!found) throw new Error("Wrong security code."); 
  }

  void cashOut(int cashExtractAmount) throws Error {
    if (error) {
      throw new Error("Error occured.");
    }

    int cardBalance = getCardBalance();

    if (cashExtractAmount > balance || cashExtractAmount > cardBalance) {
      throw new Error("Not enough balance.");
    }

    int newCardBalance = cardBalance - cashExtractAmount;
    balance = balance - cashExtractAmount;

    System.out.printf("You've extracted %s \n Your balance is %s", cashExtractAmount, newCardBalance);
  }

  int getCardBalance() {
    return cards.get(currentCard).getBalance();
  }
}