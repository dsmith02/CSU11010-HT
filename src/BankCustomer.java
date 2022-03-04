import java.util.ArrayList;

public class BankCustomer
{
    private int accountNumber;
    private String customerName;
    private String customerAddress;
    private int customerDateOfBirth;

    public int getAccountNumber()
    {
        return accountNumber;
    }

    public void setAccountNumber(int accNumber)
    {
        accountNumber = accNumber;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(String name)
    {
        customerName = name;
    }

    public String getCustomerAddress()
    {
        return customerAddress;
    }

    public void setCustomerAddress(String address)
    {
        customerAddress = address;
    }

    public int getCustomerDateOfBirth()
    {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(int dob)
    {
        customerDateOfBirth = dob;
    }

    public static String findCustomer(int accountNumber, BankCustomer[] customerList)
    {
        for (BankCustomer customer : customerList)
        {
            if (accountNumber == customer.accountNumber)
            {
                return customer.customerName;
            }
        }
        return null;
    }

    public static String findCustomer(int dateOfBirth, String customerAddress, BankCustomer[] customerList)
    {
        for (BankCustomer customer : customerList)
        {
            if (dateOfBirth == customer.customerDateOfBirth && customerAddress.equalsIgnoreCase(customer.customerAddress))
            {
                return customer.customerName;
            }
        }
        return null;
    }

    public static String findCustomer(ArrayList<BankCustomer> list, int accountNumber)
    {
        for (BankCustomer customer : list)
        {
            if (customer.accountNumber == accountNumber)
            {
                return customer.customerName;
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        BankCustomer cust1 = new BankCustomer();

        cust1.setAccountNumber(12345);
        cust1.setCustomerName("John Smith");
        cust1.setCustomerAddress("Beverly Hills");
        cust1.setCustomerDateOfBirth(290271);
        BankCustomer[] test = new BankCustomer[1];
        test[0] = cust1;
        ArrayList<BankCustomer> customers = new ArrayList<>();
        customers.add(cust1);
        System.out.println(findCustomer(12345, test));
    }
}