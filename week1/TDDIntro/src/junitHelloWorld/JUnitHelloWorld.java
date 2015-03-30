package junitHelloWorld;

public class JUnitHelloWorld {

    public int getNumberOfDigits(int n) {
        int counter = 0;
        if (n == 0) {
            return 1;
        }
        while (n != 0) {
            n /= 10;
            counter++;
        }
        return counter;
    }
}
