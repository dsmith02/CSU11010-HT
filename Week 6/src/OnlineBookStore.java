import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineBookStore
{
    public static int ISBN_INDEX = 0;
    public static int TITLE_INDEX = 1;
    public static int AUTHOR_INDEX = 2;
    public static int PUBLISHER_INDEX = 3;
    public static int PUBLISHER_YEAR_INDEX = 4;
    public static int QUANTITY_INDEX = 5;
    public static int PRICE_INDEX = 6;

    public static void main(String[] args)
    {
        ArrayList<Book> bookList = new ArrayList<Book>();
        try
        {
            FileReader fileReader = new FileReader("books.txt");// Enter the entire path of the file if needed
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            boolean endOfFile = false;

            while (!endOfFile)
            {
                String bookLine = bufferedReader.readLine();
                if (bookLine != null)
                {
                    String[] bookData = bookLine.split(", ");
                    String isbn = bookData[ISBN_INDEX];
                    String title = bookData[TITLE_INDEX];
                    String author = bookData[AUTHOR_INDEX];
                    String publisher = bookData[PUBLISHER_INDEX];
                    int publishYear = Integer.parseInt(bookData[PUBLISHER_YEAR_INDEX]);
                    int quantity = Integer.parseInt(bookData[QUANTITY_INDEX]);
                    double price = Double.parseDouble(bookData[PRICE_INDEX]);
                    Book book = new Book(isbn, title, author, publisher, publishYear, quantity, price);
                    bookList.add(book);
                }
                else
                {
                    endOfFile = true;
                }
            }
            bufferedReader.close();
            fileReader.close();
        } // End try 

        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        // Uncomment the following lines once you have implemented the required methods
        printBookDetails(bookList);
        purchaseBook(bookList);
    }

    public static void printBookDetails(ArrayList<Book> bookList)
    {
        System.out.println("We have the following books in stock: ");
        for (Book currentBook : bookList)
        {
            System.out.println(currentBook.toString());
        }
    }

    public static Book getBook(ArrayList<Book> bookList, String title)
    {
        for (Book currentBook : bookList)
        {
            if (title.equalsIgnoreCase(currentBook.getTitle()))
            {
                return currentBook;
            }
        }
        return null;
    }

    public static void topUpCard(ChargeCard card, double amount)
    {
        card.topUpFunds(amount);
    }

    public static void purchaseBook(ArrayList<Book> bookList)
    {
        Scanner scanner = new Scanner(System.in);
        String inputRegex = "[0-29]+0*.[0-9]*";
        System.out.println("Enter the funds that you have> ");
        String input = scanner.nextLine();
        while (!input.matches(inputRegex))
        {
            System.out.println("Error: Funds must be a valid positive integer.");
            System.out.println("Enter the funds that you have> ");
            input = scanner.nextLine();
        }
        ChargeCard card = new ChargeCard();
        card.topUpFunds(Double.parseDouble(input));
        boolean isShopping = true;
        while (isShopping)
        {
            System.out.println("Funds: " + card.getFunds() + "\nEnter the title of the book you would like to purchase> ");
            String bookTitle = scanner.nextLine();
            Book book = getBook(bookList, bookTitle);
            if (book != null)
            {
                if (book.getQuantity() >= 1 && card.getFunds() >= book.getPrice())
                {
                    card.removeFunds(book.getPrice());
                    book.setQuantity(book.getQuantity() - 1);
                    System.out.println("Congratulations! You have jut bought " + book.getTitle());
                }
                else
                {
                    System.out.println("Sorry, this book is out of stock or you do not have enough funds.");
                }
            }
            else
            {
                System.out.println("Invalid book! Please try again.");
            }
            System.out.println("Would you like to continue shopping? (Y/N)");
            isShopping = scanner.nextLine().equalsIgnoreCase("Y") ? true : false;
        }
    }
}