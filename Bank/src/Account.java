public class Account
{
    private double balance;
    private Person owner;
    private Bank bank;
    private double overdraft;
    private String rollNumber;
    private boolean isActive;

    public Account()
    {
        balance = 0.0;
        owner = null;
        bank = null;
        overdraft = 0.0;
        rollNumber = "PLACEHOLDER";
        isActive = true;
    }

    public void widthraw(double amount)
    {
        if (amount >= balance)
        {
            setBalance(0);
        }
        else
        {
            setBalance(balance - amount);
        }
    }

    public boolean close()
    {
        if (isActive())
        {
            setActive(false);
        }
        else
        {
            System.out.println("Account is already inactive.");
        }
    }
    public boolean isActive()
    {
        return isActive;
    }

    private void setActive(boolean active)
    {
        isActive = active;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public void setOwner(Person owner)
    {
        if (owner == null)
        {
            System.out.println("Owner must not be null. You may want to close the account.");
        }
        this.owner = owner;
    }

    public void setBank(Bank bank)
    {
        this.bank = bank;
    }

    public void setOverdraft(double overdraft)
    {
        this.overdraft = overdraft;
    }

    public void setRollNumber(String rollNumber)
    {
        this.rollNumber = rollNumber;
    }

    public double getBalance()
    {
        return balance;
    }

    public Person getOwner()
    {
        return owner;
    }

    public Bank getBank()
    {
        return bank;
    }

    public double getOverdraft()
    {
        return overdraft;
    }

    public String getRollNumber()
    {
        return rollNumber;
    }
}
