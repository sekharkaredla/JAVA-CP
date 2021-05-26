package com.sekhar.coding;

public class ReversePolishCalc {
    private double[] stack;
    private int stackCounter = 0;
    public double evaluate(String expr) {
        if (expr == null || expr.equalsIgnoreCase(""))
            return 0;
        stack = new double[expr.length()];
        for (char eachCharacter : expr.trim().toCharArray()) {
            if (eachCharacter != ' ') {
                if (Character.isDigit(eachCharacter))
                    addToStack(Double.parseDouble(String.valueOf(eachCharacter)));
                else {
                    double b = removeFromStack();
                    double a = removeFromStack();
                    double result = performOperation(a, b, eachCharacter);
                    addToStack(result);
                }
            }
        }
        return stack[stackCounter];
    }
    private double performOperation(double a, double b, char operation) {
        switch (operation) {
            case '+' : return a + b;
            case '-' : return a - b;
            case '*' : return a * b;
            case '/' : return a / b;
            default : return 0;
        }
    }
    private void addToStack(double d){
        stack[stackCounter++] = d;
    }
    private double removeFromStack(){
        return stack[--stackCounter];
    }
}