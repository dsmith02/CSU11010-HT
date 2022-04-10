import java.util.ArrayList;

public class PhibbyDatabase
{
    private ArrayList<Person> listOfPeople;
    private int numberOfFields;
    private static int numberOfDatabases;

    public PhibbyDatabase()
    {
        listOfPeople = new ArrayList<>();
        numberOfDatabases++;
    }

    public boolean addPerson(Person person)
    {
        if (person == null)
        {
            return false;
        }
        listOfPeople.add(person);
        return true;
    }

    public int indexOfPerson(Person person)
    {

    }

    public boolean removePerson()
}
