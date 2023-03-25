package calculator;

import java.util.function.Consumer;

import static java.lang.Double.parseDouble;

/**
 * Cheap calculator based on double precision.
 */
public class Calculator {

    private String currentNumber;
    private Operator operator;
    private double prevNumber;
    private boolean numberEntered;

    private Consumer<String> onDisplayChanged;

    public Calculator() {
        clear();
    }

    public String getDisplay() {
        return currentNumber;
    }

    public void setOnDisplayChanged(Consumer<String> onDisplayChanged) {
        this.onDisplayChanged = onDisplayChanged;
    }

    public void clear() {
        currentNumber = "0";
        operator = null;
        numberEntered = false;
        triggerDisplayChanged();
    }

    public void clearEntry() {
        currentNumber = "0";
        numberEntered = false;
        triggerDisplayChanged();
    }

    public void backspace() {
        if (numberEntered) {
            currentNumber = currentNumber.substring(0, currentNumber.length() - 1);
            if (currentNumber.isEmpty()
                    || currentNumber.equals("-")
                    || currentNumber.equals("-0")) {
                currentNumber = "0";
            }
            triggerDisplayChanged();
        }
    }

    public void digit(int digit) {
        if (digit < 0 || digit > 9) {
            throw new IllegalArgumentException();
        }
        if (numberEntered && !currentNumber.equals("0")) {
            currentNumber += digit;
        } else {
            currentNumber = "" + digit;
        }
        numberEntered = true;
        triggerDisplayChanged();
    }

    public void negate() {
        if (!currentNumber.equals("0")) {
            if (currentNumber.startsWith("-")) {
                currentNumber = currentNumber.substring(1);
            } else {
                currentNumber = "-" + currentNumber;
            }
            triggerDisplayChanged();
        }
    }

    public void point() {
        if (numberEntered) {
            if (!currentNumber.contains(".")) {
                currentNumber += ".";
            }
        } else {
            currentNumber = "0.";
        }
        numberEntered = true;
        triggerDisplayChanged();
    }

    public void operator(Operator op) {
        if (operator != null && numberEntered) {
            calculate(); // in case there is an outstanding operation, complete it first
        }
        prevNumber = parseDouble(currentNumber);
        operator = op;
        numberEntered = false;
    }

    public void equals() {
        if (operator != null) {
            calculate();
            operator = null;
        }
        numberEntered = false;
    }

    private void calculate() {
        var current = parseDouble(currentNumber);
        currentNumber = Double.toString(switch (operator) {
            case PLUS -> prevNumber + current;
            case MINUS -> prevNumber - current;
            case TIMES -> prevNumber * current;
            case DIVIDED_BY -> prevNumber / current;
        }).replaceAll("\\.0$", ""); // remove trailing ".0"
        triggerDisplayChanged();
    }

    private void triggerDisplayChanged() {
        if (onDisplayChanged != null) {
            onDisplayChanged.accept(currentNumber);
        }
    }
}
