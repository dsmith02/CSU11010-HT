public class TestCircle
{
    public static void main(String[] args)
    {
        Circle circle = new Circle(100.0);
        System.out.printf("The perimeter of the circle is %.2f", circle.getPerimeter());
        System.out.printf("\nThe area of the circle is %.2f", circle.getArea());

        ResizableCircle circle2 = new ResizableCircle(100.0);
        circle2.resize(-10);
        System.out.printf("\nThe perimeter of the circle is %.2f", circle2.getPerimeter());
        System.out.printf("\nThe area of the circle is %.2f", circle2.getArea());
        System.out.println("\nTHE RESULT IS " + sumNumbers(80));
    }

    static int sumNumbers(int n)
    {
        if (n == 0)
        {
            return n;
        }
        else
        {
            return n + sumNumbers(n - 1);
        }
    }
}

/**
 * A class that represents an object that is drawn on the screen and can be clicked/hovered over
 * which allows for further functionality.
 *
 * This class was actually introduced after the other Widget classes were implemented and thus they
 * were refactored. This was due to there being differing functionality between them but they all needed
 * some common interface to be able to use draw() functionality.
 * @a
 * @since 12/04/22
 */
abstract class AbstractWidget
{
    abstract void draw();
    abstract int getEvent(int mX, int mY);
}
