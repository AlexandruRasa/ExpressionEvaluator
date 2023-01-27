# ExpressionEvaluator

ExpressionEvaluator calculates the value of an expression by using the shunting yard algorithm. This is a stack-based algorithm that produces a postfix notation string, starting from an infixed one. Infix expressions are the form of mathematical notation most people are used to, for instance "3 + 4" or "3 + 4 × (2 − 1)". For the conversion there are two text variables (strings), the input and the output. There is also a stack that holds operators not yet added to the output queue. To convert, the program reads each symbol in order and does something based on that symbol. The result for the above examples would be (in Reverse Polish notation) "3 4 +" and "3 4 2 1 − × +", respectively.
The shunting yard algorithm will correctly parse all valid infix expressions, but does not reject all invalid expressions. For example, "1 2 +" is not a valid infix expression, but would be parsed as "1 + 2". The algorithm can however reject expressions with mismatched parentheses.

3 − 4 + 5

The concept of a stack, a last-in/first-out construct, is integral to these actions. So in the above example, the 3 is loaded onto the bottom of the stack and a separate special keypress terminates that entry. Without this action, the 4 would append to the 3, giving 34, which is not desired. When the 4 is entered the 3 is promoted to the second stack level; the 3 is now above the 4, currently visible. The subtraction operator acts immediately on the first two levels of the stack contents, subtracting the lower value from the upper, yielding -1 at level one. This also terminates data entry, so the 5 can be immediately entered. This automatically raises the -1 to the second level. When the user then presses + (add), the first two levels are added, and the result, 4, appears in the lower. This automatic promotion (and demotion) of data among levels in the stack as each operation is performed automatically sets up successive operators just as they are needed.
