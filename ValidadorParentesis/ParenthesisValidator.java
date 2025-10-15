package ValidadorParentesis;

import java.util.Stack;


public class ParenthesisValidator {
    String openingBrackets = "({[";
    String closingBrackets = ")}]";

    public ParenthesisValidator(String openingBrackets, String closingBrackets) {
        this.openingBrackets = openingBrackets;
        this.closingBrackets = closingBrackets;
    }

    public boolean isValid(String expression) {
        Stack <String> stack = new Stack<String>();
        String[] tokenizador = expression.split("");
        for (int i = 0; i < tokenizador.length; i++){
            char currentChar = tokenizador[i].charAt(0);
            if (openingBrackets.indexOf(currentChar) != -1){
                stack.push(currentChar);
            } else if (closingBrackets.indexOf(currentChar) != -1){
                if (stack.isEmpty()){
                    return false;
                }
                String topChar = stack.pop();
                if (openingBrackets.indexOf(topChar) != closingBrackets.indexOf(currentChar)){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
