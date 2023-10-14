package dojo.portfolio.stringcalculator;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class StringCalculator {

    /**
     * Calculate the result of the given arithmetic calculation
     * For example. "1 + 2" should return 3.0
     */
    public double calculate(String value) throws IllegalArgumentException {
        List<String> tokens =  Arrays.stream(value.split(" "))
                .filter(token ->!token.isEmpty())
                .map(token -> token.trim())
                .collect(Collectors.toList());

        //No tokens at all (empty string)
        if(tokens.isEmpty()){
            return 0;
        }
        //1 token left (single number)
        if(tokens.size() == 1){
            return Double.parseDouble(tokens.get(0));
        }

        // 2 tokens left (syntax error because it will be 1 +)
        if(tokens.size() == 2){
            throw new IllegalArgumentException("Invalid expression: " + value);
        }

        //3 or more tokens left -> expression to be evaluated
        String leftHandSide = evaluateExpression(tokens.get(0), tokens.get(1), tokens.get(2));
        String rightHandSide = String.join(" ", tokens.subList(3, tokens.size()));

        return calculate(leftHandSide + " " + rightHandSide);
    }


    private String evaluateExpression(String left, String operator, String right) throws IllegalArgumentException {
            double leftValue  = Double.parseDouble(left);
            double rightValue = Double.parseDouble(right);

            switch (operator){
                case "+":
                    return Double.toString(leftValue + rightValue);
                case  "-":
                    return Double.toString(leftValue - rightValue);
                case  "*":
                    return Double.toString(leftValue * rightValue);
                case  "/":
                    return Double.toString(leftValue / rightValue);

                default:
                    throw new IllegalArgumentException("Unknown Operator: " + operator);
            }
        }
    }

