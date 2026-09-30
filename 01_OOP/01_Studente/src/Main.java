import java.util.Scanner;

public class Main {
    static void calcolabmi (studente a) {
        a.bmi = a.peso/(a.altezza*a.altezza);
    }

    public static void main(String[] args) {
        studente a;
        a = new studente("mario", "rossi", "3ai", 1.60, 60.00);
        calcolabmi(a);
        System.out.print("lo studente " + a.nome + " " + a.cognome + " è");
        if (a.bmi < 18.5) {
            System.out.print(" sottopeso");
        } else if (a.bmi < 25.0) {
            System.out.print(" normopeso");
        } else if (a.bmi < 30.0) {
            System.out.print(" sovrappeso");
        } else {
            System.out.print(" obeso");
        }
    }

}

