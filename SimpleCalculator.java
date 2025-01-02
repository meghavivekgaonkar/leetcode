import java.util.Stack;

public class SimpleCalculator {
    public static int calculate(String s) {
        Stack<Integer> intStack = new Stack<>();
        Stack<Character> charStack = new Stack<>();
        int result = 0, op1 = Integer.MAX_VALUE, op2 = Integer.MAX_VALUE;
        char operator = ' ';
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                if(op1 == Integer.MAX_VALUE) {
                    op1 = operator == '-' ? (c - '0')*(-1) : c - '0';
                    result = op1;
                } else {
                    op2 = c - '0';
                    if(operator != ' ') {
                        result = calculate(operator, op1, op2);
                        op1 = result;
                    }
                }
            }
            else if( c == '+' || c == '-'){
                operator = c;
            }
            else if( c == '('){
                // if(operator != ' ') {
                    intStack.push(op1);
                    charStack.push(operator);
                // }
            }else if( c == ')') {
                if(!intStack.isEmpty()) {
                    op2 = intStack.pop();
                    operator = charStack.pop();
                }
            } else {
                // ' ' blank case
            }
        }

        return result;
    }

public static int calculate(char operator, int op1, int op2){
    return operator == '+' ? op1 + op2 : op1 - op2;
}

    public static void main(String[] args) {
        // String s = "(1+(4+5+2)-3)+(6+8)";
        // String s = "-( 4 + 5 + 2)";
        // String s = "-1+(2 + (3-1))";
        String s = "(1)";
        System.out.println(calculate(s));

    }
    
}
