package dojo.portfolio.stringcalculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


@DisplayName("When calculating results with the string calculator")
public class WhenCalculatingResults {
    StringCalculator calculator;
    @BeforeEach
    void setUpCalculator(){
     this.calculator = new StringCalculator();
    }


   @DisplayName("The calculator should return zero for empty string")
    @Test
    void shouldReturnZeroForEmptyStrings() throws IllegalArgumentException {
       double result = calculator.calculate("");
       assertThat(result).isEqualTo(0.0);
    }


    @ParameterizedTest
    @DisplayName("The calculator should return the number for a single integer number")
    @CsvSource(
           value = {
            "1 = 1.0",
    },
            delimiterString = "="
    )

    void shouldReturnTheNumberForASingleNumber(String expression, double expected) throws IllegalArgumentException {
        double result = calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("The calculator should return the calculated results for two numbers")
    @CsvSource(
            value = {
                    //Addition
                    "1 + 1 = 2.0",
                    "1 + 2 = 3.0",

                    //Subtraction
                    "10 - 6 = 4.0",

                    //Multiplication
                    "10 * 5 = 50.0",

                    //Division
                    "10 / 5 = 2.0",
            },
            delimiterString = "="
    )

    void shouldReturnTheCalculatedResultsForTwoNumbers(String expression, double expected) throws IllegalArgumentException {
        double result = calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }


    @ParameterizedTest
    @DisplayName("The calculator should return the calculated results for three numbers")
    @CsvSource(
            value = {
                    "1 + 2 + 3 = 6",
                    "10 + 5 - 6  = 9",
            },
            delimiterString = "="
    )

    void shouldReturnTheCalculatedResultsForThreeNumbers(String expression, double expected) throws IllegalArgumentException {
        double result = calculator.calculate(expression);
        assertThat(result).isEqualTo(expected);
    }

}

