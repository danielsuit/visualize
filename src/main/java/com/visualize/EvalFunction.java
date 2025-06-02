package com.visualize;

public class EvalFunction {
    private String function;

    public void setFunction(String function) {
        this.function = function;
    }

    // Evaluates the function for a given x and slider value (a)
    public double evaluate(double x, double a) {
        // Replace 'x' and 'a' with their values
        String expr = function.replaceAll("x", Double.toString(x)).replaceAll("a", Double.toString(a));
        return evalExpr(expr);
    }

    // Basic expression evaluator (supports +, -, *, /, ^)
    private double evalExpr(String expr) {
        // Remove spaces
        expr = expr.replaceAll("\\s+", "");
        // Handle parentheses recursively
        while (expr.contains("(")) {
            int open = expr.lastIndexOf('(');
            int close = expr.indexOf(')', open);
            if (open == -1 || close == -1) break;
            double val = evalExpr(expr.substring(open + 1, close));
            expr = expr.substring(0, open) + val + expr.substring(close + 1);
        }
        // Handle ^
        if (expr.contains("^")) {
            String[] parts = expr.split("\\^");
            double base = evalExpr(parts[0]);
            double exp = evalExpr(parts[1]);
            return Math.pow(base, exp);
        }
        // Handle + and -
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if ((c == '+' || c == '-') && i > 0) {
                double left = evalExpr(expr.substring(0, i));
                double right = evalExpr(expr.substring(i + 1));
                return c == '+' ? left + right : left - right;
            }
        }
        // Handle * and /
        for (int i = expr.length() - 1; i >= 0; i--) {
            char c = expr.charAt(i);
            if ((c == '*' || c == '/') && i > 0) {
                double left = evalExpr(expr.substring(0, i));
                double right = evalExpr(expr.substring(i + 1));
                return c == '*' ? left * right : left / right;
            }
        }
        // Parse as double
        try {
            return Double.parseDouble(expr);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    public String f(double x) {
        return "Evaluated: " + function + " at x=" + x;
    }

    public boolean fRange(double x, double y, double sliderValue, double absX) {
        // Check if y is close to f(x) using the slider value as parameter 'a'
        double fx = evaluate(x, sliderValue);
        return Math.abs(y - fx) < 1.0; // 1.0 is the tolerance
    }
} 