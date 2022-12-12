import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class ExpressionEvaluator {

    private Deque<Character> operators;
    private Deque<Integer> numbers;
    private StringBuilder postFixed;
    private StringBuilder result;
    private final HashMap<Character,Integer> precedences;
    private String input;
    private boolean hasCalculatedResult;

    public ExpressionEvaluator(String input) {
        this.input = input;
        this.hasCalculatedResult = false;
        this.precedences = new HashMap<>();
        this.operators = new LinkedList<>();
        this.numbers = new LinkedList<>();
        this.precedences.put('+',11);
        this.precedences.put('-',11);
        this.precedences.put('*',12);
        this.precedences.put('/',12);
        this.precedences.put('^',13);
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
        this.hasCalculatedResult = false;
        this.operators = new LinkedList<>();
        this.numbers = new LinkedList<>();
    }

    public String calculateResult() {
        if (this.hasCalculatedResult) {
            return this.result.toString();
        }
        String expression = this.calculatePostFixedForm();
        this.result = new StringBuilder();
        System.out.println(expression);
        int i = 0, aux1, aux2;
        while (i < expression.length()) {
            char currentValue = expression.charAt(i);
            if (Character.isDigit(currentValue)) {
                this.numbers.push(Character.getNumericValue(currentValue));
            } else if (this.checkOperator(currentValue)) {
                if (!this.numbers.isEmpty()) {
                    aux1 = this.numbers.pop();
                } else {
                    return "error";
                }
                if (!this.numbers.isEmpty()) {
                    aux2 = this.numbers.pop();
                } else {
                    return "error";
                }
                this.numbers.push(checkOpperation(currentValue, aux2, aux1));
            }
            i++;
        }
        if (!this.numbers.isEmpty()) {
            this.result.append(this.numbers.pop());
        }
        if (!this.numbers.isEmpty()) {
            return "error";
        }
        this.hasCalculatedResult = true;
        return this.result.toString();
    }

    private String calculatePostFixedForm() {
        String expression = this.input;
        this.postFixed = new StringBuilder(expression.length());
        int i = 0;
        while (i < expression.length()) {
            char currentValue = expression.charAt(i);
            if (Character.isDigit(currentValue)) {
                this.postFixed.append(currentValue);
            } else if (this.checkOperator(currentValue)) {
                while (!this.operators.isEmpty() && currentValue != '^' && !this.checkParanthesisLeft(currentValue)
                        && this.checkPrecedence(currentValue)) {
                        this.postFixed.append(this.operators.pop());
                }
                this.operators.push(currentValue);
            } else if (this.checkParanthesisLeft(currentValue)) {
                this.operators.push(currentValue);
            } else if (this.checkParanthesisRight(currentValue)) {
                while (!this.operators.isEmpty() && !this.checkParanthesisLeft(this.operators.peek())) {
                    this.postFixed.append(this.operators.pop());
                }
                //check for correct close of paranthesis
                if (this.operators.isEmpty() || !this.checkParanthesisLeft(this.operators.pop())) {
                    return "error";
                }
            }
            i++;
        }
        while (!this.operators.isEmpty()) {
            char aux = this.operators.pop();
            if (checkParanthesisLeft(aux)) {
                return "error";
            }
            this.postFixed.append(aux);
        }
        return this.postFixed.toString();
    }

    private int checkOpperation(char z, int x, int y) {
        switch (z) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            case '^':
                return (int) Math.pow(x, y);
            default:
                return 0;
        }
    }

    private boolean checkParanthesisRight(char op) {
        switch (op) {
            case ')':
            case ']':
            case '}':
                return true;
            default:
                return false;
        }
    }

    private boolean checkParanthesisLeft(char op) {
        switch (op) {
            case '(':
            case '[':
            case '{':
                return true;
            default:
                return false;
        }
    }

    private boolean checkPrecedence(char op) {
        if (this.precedences.get(this.operators.peek()) == null) {
            return false;
        }
        return this.precedences.get(op) <= this.precedences.get(this.operators.peek());
    }

    private boolean checkOperator(char op) {
        switch (op) {
            case '+':
            case '-':
            case '*':
            case '/':
            case '^':
                return true;
            default:
                return false;
        }
    }
}
