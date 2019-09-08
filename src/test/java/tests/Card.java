package tests;

public class Card {
    private String cardHolderName;
    private String numberCard;
    private String expirationYear;

    public Card(String numberCard, String expirationYear, String cardHolderName) {
        this.cardHolderName = cardHolderName;
        this.numberCard = numberCard;
        this.expirationYear = expirationYear;
    }

    public Card() {
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public String getNumberCard() {
        return numberCard;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public void setNumberCard(String numberCard) {
        this.numberCard = numberCard;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }
}
