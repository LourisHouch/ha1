package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    //Teilaufgabe ha1   1.grüner Test minus 2 positive nummer
    @Test
    @DisplayName("should correctly display result after subtracting two positive multi-digit numbers")
    void testPositiveSubtraction() {
        Calculator calc = new Calculator();

        // Zahlen 85 und 27 eingeben
        calc.pressDigitKey(8);
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(2);
        calc.pressDigitKey(7);
        calc.pressEqualsKey();

        // Erwartetes Ergebnis nach der Subtraktion
        String expected = "58";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    //Teilaufgabe1 ha1 2.grüner Test division 2 positive nummer
    @Test
    @DisplayName("should correctly display result after dividing two positive multi-digit numbers")
    void testPositiveDivision() {
        Calculator calc = new Calculator();

        // Zahlen 144 und 12 eingeben
        calc.pressDigitKey(1);
        calc.pressDigitKey(4);
        calc.pressDigitKey(4);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(1);
        calc.pressDigitKey(2);
        calc.pressEqualsKey();

        // Erwartetes Ergebnis nach der Division
        String expected = "12";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //Teilaufgabe2 ha1. 1. roter Test division durch null ,error muss sein.

    @Test
    @DisplayName("should display error when dividing a positive number by zero")
    void testNullDivision() {
        Calculator calc = new Calculator();

        // Zahl 5 und 0 eingeben
        calc.pressDigitKey(5);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        // Erwartetes Ergebnis bei Division durch Null
        String expected = "error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //Teilaufgabe2 ha1 2. roter Test negative square root nummer muss error sein.

    @Test
    @DisplayName("should display error when calculating the square root of a negative number")
    void testNegativeSquareRoot() {
        Calculator calc = new Calculator();

        // Zahl -9 eingeben
        calc.pressNegativeKey(); // Negativtaste drücken
        calc.pressDigitKey(9);
        calc.pressUnaryOperationKey("√"); // Quadratwurzel-Taste drücken
        calc.pressEqualsKey();

        // Erwartetes Ergebnis bei der Quadratwurzel aus einer negativen Zahl
        String expected = "error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }



}

