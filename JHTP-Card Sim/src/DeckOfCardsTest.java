public class DeckOfCardsTest
{
    public static void main(String[] args)
    {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();

        for (int index = 1; index <= DeckOfCards.NUMBER_OF_CARDS; index++)
        {
            System.out.printf("%-19s", deck.dealCard());
            if (index % 4 == 0)
            {
                System.out.println();
            }
        }
    }
}
