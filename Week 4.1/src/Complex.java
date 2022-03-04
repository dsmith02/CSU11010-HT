public class Complex
{
    private double real;
    private double imaginary;

    public Complex()
    {
        real = 0.0;
        imaginary = 0.0;
    }

    public Complex(double real, double imaginary)
    {
        this.real = real;
        this.imaginary = imaginary;
    }

    public double getReal()
    {
        return real;
    }

    public double getImaginary()
    {
        return imaginary;
    }

    public static Complex add(Complex a, Complex b)
    {
        return new Complex(a.real + b.real, a.imaginary + b.imaginary);
    }

    public static Complex multiply(Complex a, Complex b)
    {
        double realPart = a.real * b.real - a.imaginary * b.imaginary;
        double imaginaryPart = a.real * b.real + a.imaginary * b.imaginary;
        return new Complex(realPart, imaginaryPart);
    }
}
