/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataAccess;

import common.Library;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import model.CSV;

/**
 *
 * @author MINH TUAN
 */
public class CSVFileAccess {

    Library l = new Library();

    private static CSVFileAccess instance = null;

    public static CSVFileAccess Instance() {
        if (instance == null)
            synchronized (CSVFileAccess.class) {
            if (instance == null) {
                instance = new CSVFileAccess();
            }
        }
        return instance;
    }

    public void formarAddress(ArrayList<CSV> al) {
        for (int i = 0; i < al.size(); i++) {
            String address = al.get(i).getAddress().trim();
            address = address.toLowerCase().replaceAll("\\s+", ",");
            String arr[] = address.split(",");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (!arr[j].isEmpty()) {
                    char firstChar = arr[j].charAt(0);
                    char upperCaseFirstChar = Character.toUpperCase(firstChar);
                    String restOfString = arr[j].substring(1);
                    sb.append(upperCaseFirstChar);
                    sb.append(restOfString);
                    sb.append(" ");
                }
            }
            al.get(i).setAddress(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void formatName(ArrayList<CSV> al) {
        for (int i = 0; i < al.size(); i++) {
            String name = al.get(i).getName().trim();
            name = name.toLowerCase().replaceAll("\\s+", ",");
            String arr[] = name.split(",");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < arr.length; j++) {
                if (!arr[j].isEmpty()) {
                    char firstChar = arr[j].charAt(0);
                    char upperCaseFirstChar = Character.toUpperCase(firstChar);
                    String restOfString = arr[j].substring(1);
                    sb.append(upperCaseFirstChar);
                    sb.append(restOfString);
                    sb.append(" ");
                }
            }
            al.get(i).setName(sb.toString().trim());
        }
        System.err.println("Format: Done");
    }

    public void ImportFile(ArrayList<CSV> al, String filename) {

        try {
            // Import file
            FileInputStream fis = new FileInputStream(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    al.add(new CSV(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (IOException ex) {
            System.err.println("Can't read file.");
        }
    }

    public void ExportFile(ArrayList<CSV> al, String filename) {
        try {
            // savefile
            FileOutputStream fos = new FileOutputStream(filename);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            BufferedWriter bw = new BufferedWriter(osw);

            for (CSV csv : al) {
                bw.write(csv.toString());
                bw.newLine();
            }
            bw.close();
            System.err.println("Export: Done");
        } catch (IOException ex) {
            System.out.println("Can’t export file");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
