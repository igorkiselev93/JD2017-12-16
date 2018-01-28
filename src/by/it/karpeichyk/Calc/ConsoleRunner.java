package by.it.karpeichyk.Calc;

import java.util.Scanner;

/**
 * Created by user on 13.01.2018.
 */
public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String line;

        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(line=sc.nextLine()).equals("end")){
            Var result=parser.calc(line.trim());
            printer.print(result);
        }
    }
}
