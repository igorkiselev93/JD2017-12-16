package by.it.krasutski.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = sc.nextLine()).equals("end")) {
            Var result = parser.calc(line.trim());
            printer.print(result);
            printer.printVariable();
            printer.sortVariable();
//            if (sc.nextLine().equals("print"))
//                printer.printVariable();
//            if (sc.nextLine().equals("sort"))
//                printer.sortVariable();
        }
    }
}