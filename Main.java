import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

//        ExpressionEvaluator test0 = new ExpressionEvaluator("3+(2+1)*2^3^2-8/(5-1*2/2)");
//        System.out.println(test0.calculateResult());
//        test0.calculateResult();
//        test0.setInput("3 + (2 - 5) - 1");
//        System.out.println(test0.calculateResult());

        Scanner sc = new Scanner(System.in);
        ExpressionEvaluator calculator = new ExpressionEvaluator("0");
        String exp;
        System.out.println(" Valorile trebuie sa contina o singura cifra, operatii permise: +,-,*,/,^ " +
                "ex: 3 + (2 - 5) - 1");

        do {
            System.out.println("Introduceti expresia: ");
            exp = getExpression(sc);
            calculator.setInput(exp);
            System.out.println("Rezultat:" + calculator.calculateResult());
            System.out.println("Apasati 0 pentru inchiderea programului, alt key pentru a continua.");
            exp = getExpression(sc);
        } while (!exp.equals("0"));


    }

    public static String getExpression(Scanner scanner) {
        String option;
        while (true) {
            try {
                option = scanner.next();
                return option;
            } catch (NoSuchElementException e) {
                scanner.close();
                System.out.println("Aplicatia a fost inchisa.");
            }
        }
    }
}
