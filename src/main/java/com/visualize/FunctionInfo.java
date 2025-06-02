package com.visualize;

import javafx.scene.paint.Color;

public class FunctionInfo {
    private String function;
    private Color color;

    public FunctionInfo(String function, Color color) {
        this.function = function;
        this.color = color;
    }

    public String getFunction() {
        return function;
    }

    public Color getColor() {
        return color;
    }
} 