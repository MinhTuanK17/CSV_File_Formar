/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.util.Scanner;

/**
 *
 * @author MINH TUAN
 */
public class Library {

    Scanner scanner = new Scanner(System.in);

    public String getString(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    public int getIntLimit(String msg, int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(scanner.nextLine());
                if (n < min || n > max) {
                    throw new NumberFormatException();
                }
                return n;
            } catch (NumberFormatException ex) {
                System.err.println("Re-input");
            }
        }
    }

    public double getDouble(String msg) {
        while (true) {
            String check = getString(msg);
            try {
                double output = Double.parseDouble(check);
                if (output < 0) {
                    System.err.println("Salary must be greater than 0.");
                    continue;
                } else {
                    return output;
                }
            } catch (Exception e) {
                System.err.println("Can't follow wrong data type. Please input again.");
            }
        }
    }
}
