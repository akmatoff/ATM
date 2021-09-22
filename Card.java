class Card {
  private String cardNum;
  private int balance;
  private String securityCode;
  
  Card(String cardNum, int balance, String securityCode) {
    this.cardNum = cardNum;
    this.balance = balance;
    this.securityCode = securityCode;
  }

  public String getCardNum() {
    return cardNum;
  }

  public void setCardNum(String cardNum) {
    this.cardNum = cardNum;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public String getSecurityCode() {
    return securityCode;
  }

  public void setSecurityCode(String securityCode) {
    this.securityCode = securityCode;
  }

}