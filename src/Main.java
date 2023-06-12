class MyCustomException extends Exception {
    public MyCustomException(String message) {
        super(message);
    }

    public MyCustomException(String message, Throwable cause) {
        super(message, cause);
    }
}

public class Main {
    public static void divideInt(int i, int j) throws MyCustomException {
        //changes
        if (j == 0) {
            throw new MyCustomException("Cannot divide by zero.");
        }
        int result = i / j;
        System.out.println(i + " divided by " + j + " = " + result);
    }

    public static void arrayOutOfBound() {
        try {
            int[] arr = new int[5];
            int value = arr[-1];
        } catch (ArrayIndexOutOfBoundsException e) {
            MyCustomException exception = new MyCustomException("Array index out of bounds.", e);
            System.out.println(exception);
        }
    }

    public static void main(String[] args) {
        System.out.println("............... 1st method testing divide by zero ................");
        try {
            divideInt(10, 5);
        } catch (MyCustomException e) {
            System.out.println(e);
        } finally {
            System.out.println("End of try-catch-finally block.");
        }

        try {
            divideInt(10, 0);
        } catch (MyCustomException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("End of try-catch-finally block.");
        }
        System.out.println("............... 2nd method testing Arrayoutofbond ................");

        arrayOutOfBound();
    }
}
