public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ExpressionEvaluator test0 = new ExpressionEvaluator("3+(2+1)*2^3^2-8/(5-1*2/2)");
        System.out.println(test0.calculateResult());
        test0.calculateResult();
        test0.setInput("3 + (2 - 5) - 1");
        System.out.println(test0.calculateResult());
    }
}
