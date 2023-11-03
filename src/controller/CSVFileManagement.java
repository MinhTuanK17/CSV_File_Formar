/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import common.Library;
import java.io.File;
import java.util.ArrayList;
import model.CSV;
import repository.CSVRepository;
import view.Menu;

/**
 *
 * @author MINH TUAN
 */
public class CSVFileManagement extends Menu<String> {

    static String[] menu = {"Import CSV", "Format Address", "Format Name", "Export CSV", "Exit"};

    Library l = new Library();
    CSVRepository cr = new CSVRepository();
    ArrayList<CSV> list = new ArrayList<>();

    public CSVFileManagement() {
        super("======= Format CSV Program =======", menu);
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                do {
                    String filename = l.getString("Enter Path: ");
                    File file = new File(filename);
                    if (file.exists() && !file.isDirectory()) {
                        System.err.println("Import: Done");
                        cr.ImportFile(list, filename);
                        break;
                    } else {
                        System.err.println("File does not exist or not");
                    }
                } while (true);
                break;
            case 2:
                cr.formarAddress(list);
                break;
            case 3:
                cr.formatName(list);
                break;
            case 4:
                do {
                    String filename = l.getString("Enter Path: ");
                    cr.ExportFile(list, filename);
                    break;
                } while (true);
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
            default:
                this.stop();

        }
    }

}
