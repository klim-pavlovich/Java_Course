package ru.geekbrains.api.seminars;
import java.util.*;

// Класс для работы с дробями

public class Fraction {
    
    // Числитель
    private int numerator;

    // Знаменатель
    private int denominator;

    public int getNumerator(){
        return numerator;
    }

    public void setNumerator(int numerator){
        this.numerator = numerator;
    }

    public int getDenominator(){
        return denominator;
    }

    public void setDenominator(int denominator){
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0.");
        } else {
            this.denominator = denominator;
        }
        
        this.denominator = denominator;
    }



    public Fraction(){
        numerator = 1;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        if (denominator == 0){
            throw new RuntimeException("Знаменатель не может быть равен 0.");
        } else {
            this.denominator = denominator;
            nod();
        }
    }

    public Fraction plus (Fraction f2){
        int common_denominator = denominator == f2.denominator ? denominator : denominator * f2.denominator;
        int common_numerator = denominator == f2.denominator ? numerator + f2.numerator : numerator * f2.denominator + denominator *f2.numerator;
        return new Fraction(common_numerator, common_denominator);

    }

    public static Fraction plus(Fraction f1, Fraction f2){
        int common_denominator = f1.denominator == f2.denominator ? f1.denominator : f1.denominator * f2.denominator;
        int common_numerator = f1.denominator == f2.denominator ? f1.numerator + f2.numerator : f1.numerator * f2.denominator + f1.denominator *f2.numerator;
        return new Fraction(common_numerator, common_denominator);
    }

    private void nod(){
        var num = Math.abs(numerator);
        var den = Math.abs(denominator);
        int temp;

        while (num != 0 && den != 0){
            if (num % den > 0){
                temp = num;
                num = den;
                den = temp % den;
            }
            else break;
        }
        if (num != 0 && den != 0){
            numerator = numerator / den;
            denominator = denominator / den;
        }
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fraction fraction = (Fraction) o;
        return numerator == fraction.numerator && denominator == fraction.denominator;
    }

    @Override
    public int hashCode(){
        return Objects.hash(numerator, denominator);
    }

    @Override
    public String toString(){
        return String.format("%d/%d", numerator, denominator);
    }
}
