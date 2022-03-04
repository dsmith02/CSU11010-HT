public class Person
{
    private String forename;
    private String surname;
    private String address;
    private String college;
    private String nationality;
    private int age;
    private int birthDay;
    private int birthMonth;
    private int birthYear;
    private boolean isEmployed;

    public Person(String forename, String surname, String address, String college, String nationality, int age, int birthDay, int birthMonth, int birthYear, boolean isEmployed)
    {
        this.forename = forename;
        this.surname = surname;
        this.address = address;
        this.college = college;
        this.nationality = nationality;
        this.age = age;
        this.birthDay = birthDay;
        this.birthMonth = birthMonth;
        this.birthYear = birthYear;
        this.isEmployed = isEmployed;
    }

    public String toString()
    {
        return "Name: " + forename
                + surname
                + "Address: " + address
                + "College: " + college
                + "Nationality: " + nationality
                + "Age: " + age
                + "Birthdate: " + dateOfBirth()
                + "Employed: " + (isEmployed ? "Yes" : "No");
    }

    public String dateOfBirth()
    {
        return birthDay + "\\" + birthMonth + "\\" + birthYear;
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

    public String getCollege()
    {
        return college;
    }

    public void setCollege(String college)
    {
        this.college = college;
    }

    public String getNationality()
    {
        return nationality;
    }

    public void setNationality(String nationality)
    {
        this.nationality = nationality;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getBirthDay()
    {
        return birthDay;
    }

    public void setBirthDay(int birthDay)
    {
        this.birthDay = birthDay;
    }

    public int getBirthMonth()
    {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth)
    {
        this.birthMonth = birthMonth;
    }

    public int getBirthYear()
    {
        return birthYear;
    }

    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    public boolean isEmployed()
    {
        return isEmployed;
    }

    public void setEmployed(boolean employed)
    {
        isEmployed = employed;
    }
}
