public class InheritanceTest
{
    public static void main(String[] args)
    {
        Student student = new Student("Diarmuid", "Smith", "Cavan", 2002, 3.2);
        Employee employee = new Employee("Lee", "Conefrey", "Mullagh", 2001, "Cynic");
        student.display();
        employee.display();
    }
}
