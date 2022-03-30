import java.util.ArrayList;

public class Person
{
    String forename;
    String surname;
    String address;
    String dayOfBirth;
    String monthOfBirth;
    String yearOfBirth;
    String gender ;
    Person father;
    Person mother;
    ArrayList<Person> siblings;
    String job;
    double cashOnPerson;
    int age;

    public Person()
    {
    }

    public Person(String forename, String surname, String address, String dayOfBirth, String monthOfBirth, String yearOfBirth,
                  String gender, Person father, Person mother, ArrayList<Person> siblings, String job, double cashOnPerson, int age)
    {
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        this.monthOfBirth = monthOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.siblings = siblings;
        this.job = job;
        this.cashOnPerson = cashOnPerson;
        this.age = age;
    }

    public String getForename()
    {
        return forename;
    }

    public void setForename(String forename)
    {
        this.forename = forename;
    }

    public String getSurname()
    {
        return surname;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getDayOfBirth()
    {
        return dayOfBirth;
    }

    public void setDayOfBirth(String dayOfBirth)
    {
        this.dayOfBirth = dayOfBirth;
    }

    public String getMonthOfBirth()
    {
        return monthOfBirth;
    }

    public void setMonthOfBirth(String monthOfBirth)
    {
        this.monthOfBirth = monthOfBirth;
    }

    public String getYearOfBirth()
    {
        return yearOfBirth;
    }

    public void setYearOfBirth(String yearOfBirth)
    {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public Person getFather()
    {
        return father;
    }

    public void setFather(Person father)
    {
        this.father = father;
    }

    public Person getMother()
    {
        return mother;
    }

    public void setMother(Person mother)
    {
        this.mother = mother;
    }

    public ArrayList<Person> getSiblings()
    {
        return siblings;
    }

    public void setSiblings(ArrayList<Person> siblings)
    {
        this.siblings = siblings;
    }

    public String getJob()
    {
        return job;
    }

    public void setJob(String job)
    {
        this.job = job;
    }

    public double getCashOnPerson()
    {
        return cashOnPerson;
    }

    public void setCashOnPerson(double cashOnPerson)
    {
        this.cashOnPerson = cashOnPerson;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
