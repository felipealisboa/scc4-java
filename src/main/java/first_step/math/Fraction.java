package first_step.math;

public class Fraction {

    int numerator;
    int denominator;

    public Fraction(int numr, int denr) {
        numerator = numr;
        denominator = denr;
        reduce();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    private int calculateGCD(int numerator, int denominator) {
        if (numerator % denominator == 0) {
            return denominator;
        }
        return calculateGCD(denominator, numerator % denominator);
    }

    private void reduce() {
        int gcd = calculateGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public Fraction add(Fraction fractionTwo) {
        int numer = (numerator * fractionTwo.getDenominator()) +
                (fractionTwo.getNumerator() * denominator);
        int denr = denominator * fractionTwo.getDenominator();
        return new Fraction(numer, denr);
    }

    public Fraction subtract(Fraction fractionTwo) {
        int newNumerator = Math.abs((numerator * fractionTwo.denominator) -
                (fractionTwo.numerator * denominator));
        int newDenominator = denominator * fractionTwo.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction multiply(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.numerator;
        int newDenominator = denominator * fractionTwo.denominator;
        return new Fraction(newNumerator, newDenominator);
    }

    public Fraction divide(Fraction fractionTwo) {
        int newNumerator = numerator * fractionTwo.getDenominator();
        int newDenominator = denominator * fractionTwo.numerator;
        return new Fraction(newNumerator, newDenominator);
    }

    @Override
    public String toString() {
        return this.numerator + "/" + this.denominator;
    }

    public static void main(String[] args) {
        Fraction fractionOne = new Fraction(2,10);
        Fraction fractionTwo = new Fraction(7,8);

        Fraction add = fractionOne.add(fractionTwo);
        Fraction subtract = fractionOne.subtract(fractionTwo);
        Fraction multiply = fractionOne.multiply(fractionTwo);
        Fraction divide = fractionOne.divide(fractionTwo);

        System.out.println("Add: " + add);
        System.out.println("Subtract: " + subtract);
        System.out.println("Multiply: " + multiply);
        System.out.println("Divide: " + divide);
    }
}