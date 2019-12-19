package org.example;

public class Expression {
    public final String exp;

    public Expression(String exp) {
        System.out.println("Ща буду парсить: " + exp);
        this.exp = exp;
    }
}
