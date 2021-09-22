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

  String checkCardNum(String cardNum) {
    if (cardNum.length() != 6 || !checkIfCardNumExists(cardNum)) {
      error = true;
      return "Mistake in the card number.";
    }

    return "Checked the card number.";
  }

  boolean checkIfCardNumExists(String cardNum) {

    for (int i = 0; i <= cards.size(); i++) {
      if (cards.get(i).getCardNum().equals(cardNum)) {
        return true;
      }
    }

    return false;
  }

  boolean checkIfSecurityCodeIsCorrect(String cardNum, String securityCode) {

    for (int i = 0; i < cards.size(); i++) {
      if (cards.get(i).getSecurityCode().equals(securityCode) && cards.get(i).getCardNum().equals(cardNum)) {
        currentCard = i;
        return true;
      }
    }

    return false;
  }

  String cashOut(int cashExtractAmount) {
    if (error) {
      return "Error";
    }

    balance = balance - cashExtractAmount;
    int cardBalance = cards.get(currentCard).getBalance() - cashExtractAmount;

    if (cashExtractAmount > balance || cashExtractAmount > cardBalance) {
      System.out.println("Not enough balance.");
    }

    System.out.printf("You've extracted %s \n Your balance is %s", cashExtractAmount, cardBalance);
    return "Successfull.";
  }
}