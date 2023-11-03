/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import dataAccess.CSVFileAccess;
import java.util.ArrayList;
import model.CSV;

/**
 *
 * @author MINH TUAN
 */
public class CSVRepository implements ICSVRepository {

    @Override
    public void formarAddress(ArrayList<CSV> al) {
        CSVFileAccess.Instance().formarAddress(al);
    }

    @Override
    public void formatName(ArrayList<CSV> al) {
        CSVFileAccess.Instance().formatName(al);
    }

    @Override
    public void ImportFile(ArrayList<CSV> al, String filename) {
        CSVFileAccess.Instance().ImportFile(al, filename);
    }

    @Override
    public void ExportFile(ArrayList<CSV> al, String filename) {
        CSVFileAccess.Instance().ExportFile(al, filename);
    }

}
