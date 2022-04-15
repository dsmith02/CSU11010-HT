public class PieceWorker extends Employee
{
    private double wage;
    private int pieces;

    public PieceWorker(String firstName, String lastName, String socialSecurityNumber,
                       double wage, int pieces)
    {
        super(firstName, lastName, socialSecurityNumber);
        this.wage = wage;
        this.pieces = pieces;
    }

    public double getWage()
    {
        return wage;
    }

    public void setWage(double wage)
    {
        this.wage = wage;
    }

    public int getPieces()
    {
        return pieces;
    }

    public void setPieces(int pieces)
    {
        this.pieces = pieces;
    }

    @Override
    public double earnings()
    {
        return pieces * wage;
    }

    @Override
    public String toString()
    {
        return String.format("%s %s %n%s: $%.2f; %s: %d", "piece worker:", super.toString(), "wage per piece",
                getWage(), "pieces produced", getPieces());
    }
}
