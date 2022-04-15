public class PayrollSystemTest
{
    private static final int NUMBER_OF_EMPLOYEES = 5;
    public static void main(String[] args)
    {
        Employee[] list = new Employee[NUMBER_OF_EMPLOYEES];
        list[0] = new SalariedEmployee("John", "Smith", "111-11-111", 800.0);
        list[1] = new HourlyEmployee("Karen", "Price", "222-22-2222",
                16.75, 40.0);
        list[2] = new CommissionEmployee("Sue", "Jones", "333-33-3333",
                10000.0, 0.06);
        list[3] = new BasePlusCommissionEmployee("Bob", "Lewis", "444-44-4444",
                5000.0, 0.04, 300.0);
        list[4] = new PieceWorker("Rick", "Bridges", "555-55-5555", 2.25, 400);

        System.out.println("Employees processed polymorphically:");
        for (Employee employee : list)
        {
            System.out.printf("%s%n%s $%.2f%n%n", employee.toString(), "earned",
                    employee.earnings());
        }
    }
}