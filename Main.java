public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        ExpressionEvaluator test0 = new ExpressionEvaluator("3+(2+1)*2^3^2-8/(5-1*2/2)");
        System.out.println(test0.calculateResult());
        test0.calculateResult();
        test0.setInput("3 + (2 - 5) - 1");
        System.out.println(test0.calculateResult());

        int[] arr = {1000,4,25,319,88,51,3430,8471,701,1,2989,657,713};
        int[] arr1 = {1,22,8,6,44,9};
        RadixSort x = new RadixSort(arr);
        x.sort();
        x.printArr();
        x.setNumbers(arr1);
        System.out.println();
        x.sort();
        x.printArr();



    }



}
